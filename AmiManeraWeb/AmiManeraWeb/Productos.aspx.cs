using AmiManeraWeb.ServicioWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AmiManeraWeb
{
    public partial class Productos : System.Web.UI.Page
    {
        private ProductoWSClient productoWs = new ProductoWSClient();
        private TipoProductoWSClient tipoProductoWs = new TipoProductoWSClient();
        
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarTipos();
                CargarProductos();
            }
        }

        private void CargarTipos()
        {
            ddlTipoProducto.DataSource = tipoProductoWs.listarTipoProductos();
            ddlTipoProducto.DataTextField = "Descripcion";
            ddlTipoProducto.DataValueField = "IdTipoProducto";
            ddlTipoProducto.DataBind();
        }

        private void CargarProductos()
        {
            gvProductos.DataSource = productoWs.listarProductos();
            gvProductos.DataBind();
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            producto producto = new producto
            {
                idProducto = string.IsNullOrWhiteSpace(hfIdProducto.Value) ? 0 : int.Parse(hfIdProducto.Value),
                nombre = txtNombre.Text.Trim(),
                descripcion = txtDescripcion.Text.Trim(),
                precioUnitario = double.Parse(txtPrecio.Text),
                tipoProducto = new tipoProducto { idTipoProducto = int.Parse(ddlTipoProducto.SelectedValue) }
            };

            if (producto.idProducto == 0)
                productoWs.guardarProducto(producto,estado.NUEVO);
            else
                productoWs.guardarProducto(producto,estado.MODIFICAR);

            LimpiarFormulario();
            CargarProductos();
        }

        protected void btnLimpiar_Click(object sender, EventArgs e)
        {
            LimpiarFormulario();
        }

        private void LimpiarFormulario()
        {
            txtNombre.Text = "";
            txtDescripcion.Text = "";
            txtPrecio.Text = "";
            ddlTipoProducto.SelectedIndex = 0;
            hfIdProducto.Value = "";
        }

        protected void gvProductos_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            int index = Convert.ToInt32(e.CommandArgument);
            GridViewRow row = gvProductos.Rows[index];
            int idProducto = Convert.ToInt32(gvProductos.DataKeys[index].Value);

            producto seleccionado = productoWs.buscarProducto(idProducto);

            if (e.CommandName == "Editar")
            {
                hfIdProducto.Value = seleccionado.idProducto.ToString();
                txtNombre.Text = seleccionado.nombre;
                txtDescripcion.Text = seleccionado.descripcion;
                txtPrecio.Text = seleccionado.precioUnitario.ToString();
                ddlTipoProducto.SelectedValue = seleccionado.tipoProducto.idTipoProducto.ToString();
            }
            else if (e.CommandName == "Eliminar")
            {
                productoWs.eliminarProducto(seleccionado.idProducto);
                CargarProductos();
            }
        }
    }
}