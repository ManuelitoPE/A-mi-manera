using AmiManeraWeb.ServicioWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AmiManeraWeb
{
    public partial class Login : System.Web.UI.Page
    {
        
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                Session.Clear();               // Limpia sesión previa
            }
        }

        protected void btnLogin_Click(object sender, EventArgs e)
        {
            string usuario = txtUsuario.Text.Trim();
            string clave = txtPassword.Text;

            try
            {
                // Client proxy al Web Service
                var ws = new CuentaUsuarioWSClient();
                cuentaUsuario cuenta = ws.login(usuario, clave);   // ←  tu método WS
                
                if (cuenta != null)
                {
                    // Guarda el objeto completo por si lo necesitas luego
                    Session["cuenta"] = cuenta;
                    Session["UsuarioNombre"] = cuenta.nombreUsuario;
                    // También el rol por comodidad
                    Session["rol"] = cuenta.tipoUsuario;
                    int id = ws.encontrarRolDelUsuario(cuenta);
                    Session["idTrabajador"] = id;
                    Response.Redirect("~/MenuPrincipal.aspx");
                }
                else
                {
                    MostrarError("Usuario o contraseña incorrectos.");
                }
            }
            catch (Exception ex)
            {
                MostrarError("No se pudo conectar con el servidor: " + ex.Message);
            }
        }

        private void MostrarError(string mensaje)
        {
            lblMensaje.Text = mensaje;
            lblMensaje.Visible = true;
        }
    }
}