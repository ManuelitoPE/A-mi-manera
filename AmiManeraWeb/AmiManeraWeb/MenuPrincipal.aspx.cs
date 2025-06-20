using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AmiManeraWeb
{
    public partial class MenuPrincipal : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Validar que la sesión esté activa
                if (Session["UsuarioNombre"] == null)
                {
                    // Si no hay sesión activa, redirigir al login
                    Response.Redirect("Login.aspx");
                }
                else
                {
                    // Mostrar el nombre del usuario en la etiqueta
                    lblNombreUsuario.Text = Session["UsuarioNombre"].ToString();
                }
            }
        }
    }
    
}