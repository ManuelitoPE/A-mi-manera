using AmiManeraWeb.ServicioWS;
using System;
using System.ComponentModel;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AmiManeraWeb
{
    public partial class AgregarLineaPedido : System.Web.UI.Page
    {
        private PedidoWSClient pedidoWS = new PedidoWSClient();
        private ProductoWSClient productoWS = new ProductoWSClient();
        private BindingList<producto> productos;
        private int idPedido;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (Request.QueryString["idPedido"] != null)
                {
                    idPedido = Convert.ToInt32(Request.QueryString["idPedido"]);
                    ViewState["idPedido"] = idPedido;
                    CargarProductos();
                }
            }
            else
            {
                idPedido = (int)ViewState["idPedido"];
            }
        }

        private void CargarProductos()
        {
            productos = new BindingList<producto>(productoWS.listarProductos());
            gvProductos.DataSource = productos;
            gvProductos.DataBind();
        }
        //FALTA UN MODULO QUE ME PERMITA BUSCAR PRODUCTOS POR ID O POR NOMBRE
        protected void btnBuscar_Click(object sender, EventArgs e)
        {
            string criterio = ddlCriterio.SelectedValue;
            string valor = txtBuscar.Text.Trim();

            if (criterio == "ID" && int.TryParse(valor, out int id))
            {
                var prod = productoWS.buscarProducto(id);
                if (prod != null)
                    productos = new BindingList<producto>(new[] { prod });
                else
                    productos = new BindingList<producto>();
            }
            else if (criterio == "Nombre")
            {
                var lista = productoWS.buscarProductoPorNombre(valor);
                productos = new BindingList<producto>(lista ?? new producto[0]);
            }
            else
            {
                productos = new BindingList<producto>();
            }

            gvProductos.DataSource = productos;
            gvProductos.DataBind();
        }

        protected void btnMostrarTodos_Click(object sender, EventArgs e)
        {
            CargarProductos();
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            foreach (GridViewRow row in gvProductos.Rows)
            {
                var txtCantidad = (TextBox)row.FindControl("txtCantidad");
                var hfIdProducto = (HiddenField)row.FindControl("hfIdProducto");

                if (int.TryParse(txtCantidad.Text, out int cant) && cant > 0)
                {
                    int idProd = int.Parse(hfIdProducto.Value);
                    int idTrabajador = (int)Session["idTrabajador"];
                    pedidoWS.agregarProductoAPedido(idPedido, idProd, idTrabajador, cant);
                }
            }

            Response.Redirect("PedidoMesa.aspx?idMesa=" + ObtenerIdMesaDesdePedido(idPedido));
        }

        private int ObtenerIdMesaDesdePedido(int idPedido)
        {
            pedido p = pedidoWS.buscarPedidoPorId(idPedido);
            return p.mesa.idMesa;
        }

        //CANCELAR PEDIDO (ELIMINAR)

        protected void btnCancelarPedido_Click(object sender, EventArgs e)
        {
            int id = idPedido;
            pedidoWS.eliminarPedido(id);
            Response.Redirect("Mesas.aspx");
        }
    }
}