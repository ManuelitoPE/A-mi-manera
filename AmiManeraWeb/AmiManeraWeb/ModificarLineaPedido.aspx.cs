using AmiManeraWeb.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AmiManeraWeb
{
    public partial class ModificarLineaPedido : System.Web.UI.Page
    {
        private PedidoWSClient pedidoWS = new PedidoWSClient();
        private ProductoWSClient productoWS = new ProductoWSClient();
        private BindingList<producto> productos;
        private LineaPedidoWSClient lineaPedidoWS = new LineaPedidoWSClient();
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
                    CargarLineasPedido();
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

        private void CargarLineasPedido()
        {
            pedido p = pedidoWS.buscarPedidoPorId(idPedido);
            lineaPedido[] lineaPedido = lineaPedidoWS.listarLineaPedidoPorIdPedido(idPedido);
            gvLineas.DataSource = lineaPedido;
            gvLineas.DataBind();
        }

        protected void btnBuscar_Click(object sender, EventArgs e)
        {
            string criterio = ddlCriterio.SelectedValue;
            string valor = txtBuscar.Text.Trim();

            if (criterio == "ID" && int.TryParse(valor, out int id))
            {
                var prod = productoWS.buscarProducto(id);
                productos = prod != null
                    ? new BindingList<producto>(new[] { prod })
                    : new BindingList<producto>();
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

        protected void btnCancelar_Click(object sender, EventArgs e)
        {
            pedidoWS.eliminarPedido(idPedido);
            Response.Redirect("PedidoMesa.aspx?idMesa=" + ObtenerIdMesaDesdePedido(idPedido));
        }

        private int ObtenerIdMesaDesdePedido(int idPedido)
        {
            pedido p = pedidoWS.buscarPedidoPorId(idPedido);
            return p.mesa.idMesa;
        }

        protected void gvLineas_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName == "Eliminar")
            {
                int idLineaPedido = Convert.ToInt32(e.CommandArgument);
                int idTrabajador = (int)Session["idTrabajador"];
                lineaPedidoWS.eliminarLineaPedido(idLineaPedido,idPedido, idTrabajador);  // Asumiendo que este método existe en tu servicio
                CargarLineasPedido();  // Recarga la grilla después de eliminar
            }
        }
    }
}