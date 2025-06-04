using AmiManeraWeb.ServicioWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services.Description;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AmiManeraWeb
{
    public partial class Productos : System.Web.UI.Page
    {
        ProductoWSClient productoWs = new ProductoWSClient();
        TipoProductoWSClient tipoProductoWs = new TipoProductoWSClient();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                VerificarRol();
                CargarTiposProducto();
                CargarProductos();
            }
        }

        private void VerificarRol()
        {
            string rol = Session["rol"] as string;

            if (rol != "administrador")
            {
                lblMensaje.Text = "Acceso restringido. Solo los administradores pueden gestionar productos.";
                btnGuardar.Enabled = false;
                gvProductos.Enabled = false;
            }
        }

        private void CargarTiposProducto()
        {
            ddlTipoProducto.DataSource = tipoProductoWs.listarTipoProductos();
            ddlTipoProducto.DataBind();
        }

        private void CargarProductos()
        {
            gvProductos.DataSource = productoWs.listarProductos();
            gvProductos.DataBind();
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            try
            {
                producto producto = new producto
                {
                    nombre = txtNombre.Text.Trim(),
                    descripcion = txtDescripcion.Text.Trim(),
                    precioUnitario = double.Parse(txtPrecio.Text.Trim()),
                    tipoProducto = new tipoProducto
                    {
                        idTipoProducto = int.Parse(ddlTipoProducto.SelectedValue)
                    }
                };

                if (!string.IsNullOrEmpty(hdnIdProducto.Value))
                {
                    producto.idProducto = int.Parse(hdnIdProducto.Value);
                    productoWs.guardarProducto(producto,estado.MODIFICAR);
                    lblMensaje.Text = "Producto modificado exitosamente.";
                }
                else
                {
                    productoWs.guardarProducto(producto,estado.NUEVO);
                    lblMensaje.Text = "Producto creado exitosamente.";
                }

                LimpiarFormulario();
                CargarProductos();
            }
            catch (Exception ex)
            {
                lblMensaje.Text = $"Error: {ex.Message}";
            }
        }

        protected void btnCancelar_Click(object sender, EventArgs e)
        {
            LimpiarFormulario();
        }

        private void LimpiarFormulario()
        {
            txtNombre.Text = "";
            txtDescripcion.Text = "";
            txtPrecio.Text = "";
            ddlTipoProducto.SelectedIndex = 0;
            hdnIdProducto.Value = "";
            lblMensaje.Text = "";
        }

        protected void gvProductos_RowCommand(object sender, System.Web.UI.WebControls.GridViewCommandEventArgs e)
        {
            int id = int.Parse(e.CommandArgument.ToString());
            if (e.CommandName == "Editar")
            {
                producto producto = productoWs.buscarProducto(id);
                if (producto != null)
                {
                    hdnIdProducto.Value = producto.idProducto.ToString();
                    txtNombre.Text = producto.nombre;
                    txtDescripcion.Text = producto.descripcion;
                    txtPrecio.Text = producto.precioUnitario.ToString("F2");
                    ddlTipoProducto.SelectedValue = producto.tipoProducto.idTipoProducto.ToString();
                }
            }
            else if (e.CommandName == "Eliminar")
            {
                productoWs.eliminarProducto(id);
                lblMensaje.Text = "Producto eliminado.";
                CargarProductos();
            }
        }
    }
}