using AmiManeraWeb.ServicioWS;
using System;
using System.ComponentModel;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AmiManeraWeb
{
    public partial class PedidosMesa : System.Web.UI.Page
    {
        private PedidoWSClient pedidoWS = new PedidoWSClient();
        private LineaPedidoWSClient lineaPedidoWS = new LineaPedidoWSClient();

        protected int idMesa
        {
            get { return ViewState["idMesa"] != null ? (int)ViewState["idMesa"] : 0; }
            set { ViewState["idMesa"] = value; }
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (Request.QueryString["idMesa"] != null)
                {
                    idMesa = Convert.ToInt32(Request.QueryString["idMesa"]);
                    cargarPedidos();
                }
            }
        }

        private void cargarPedidos()
        {
            var listaPedidos = pedidoWS.listarPedidosPorMesa(idMesa);
            rptPedidos.DataSource = listaPedidos;
            rptPedidos.DataBind();
            
        }

        protected void rptPedidos_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            if (e.CommandName == "VerDetalle")
            {
                int idPedido = Convert.ToInt32(e.CommandArgument);
                var lineas = lineaPedidoWS.listarLineaPedidoPorIdPedido(idPedido);
                rptLineasPedido.DataSource = lineas;
                rptLineasPedido.DataBind();

                // Mostrar modal con JavaScript
                ScriptManager.RegisterStartupScript(this, this.GetType(), "mostrarModal", "mostrarModal();", true);
            }
        }

        //BOTON DE MODIFICAR PEDIDO ASOCIADO AL PEDIDO MAS RECIENTE
        protected void btnModificarPedido_Click(object sender, EventArgs e)
        {
            var pedidos = pedidoWS.listarPedidosPorMesa(idMesa);
            
            if (pedidos != null && pedidos.Length > 0)
            {
                // Tomar el más reciente (último por fecha)
                int idUltimoPedido = pedidos[0].idPedido;

                Response.Redirect("ModificarLineaPedido.aspx?idPedido=" + idUltimoPedido);
            }
        }

        protected void btnAgregarPedido_Click(object sender, EventArgs e)
        {
            // Guardar un pedido vacío para la mesa actual
            int idMesero = (int)Session["idTrabajador"];

            int idGenerado = pedidoWS.crearPedido(idMesa, idMesero);

            // Redirigir a AgregarLineaPedido con el id del nuevo pedido
            Response.Redirect("AgregarLineaPedido.aspx?idPedido=" + idGenerado);
        }
    }
}
