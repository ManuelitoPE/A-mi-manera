using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AmiManeraWeb
{
    public partial class Site : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                AplicarPermisosPorRol();
            }
        }

        private void AplicarPermisosPorRol()
        {
            string rol = Session["Rol"] as string;

            // Ocultar todo por defecto
            lnkPedidos.Visible = false;
            lnkMesas.Visible = false;
            lnkProductos.Visible = false;
            lnkAgregarUsuario.Visible = false;

            if (string.IsNullOrEmpty(rol))
            {
                // Si no hay sesión, redirige al login
                Response.Redirect("Login.aspx");
                return;
            }

            switch (rol.ToLower())
            {
                case "administrador":
                    lnkPedidos.Visible = true;
                    lnkMesas.Visible = true;
                    lnkProductos.Visible = true;
                    lnkAgregarUsuario.Visible = true;
                    break;

                case "mesero":
                    lnkPedidos.Visible = true;
                    lnkMesas.Visible = true;
                    break;

                case "bartender":
                    lnkPedidos.Visible = true;
                    break;

                case "cajero":
                    lnkMesas.Visible = true;
                    break;

                default:
                    // Opcional: redirigir o mostrar error si el rol no es válido
                    break;
            }
        }
    }
}