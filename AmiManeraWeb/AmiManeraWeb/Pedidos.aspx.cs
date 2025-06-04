using AmiManeraWeb.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AmiManeraWeb
{
    public partial class Pedidos : System.Web.UI.Page
    {
        private PedidoWSClient pedidoWS = new PedidoWSClient();
        private MesaWSClient mesaWS = new MesaWSClient();
        private BindingList<pedido> pedidos;
        private BindingList<mesa> mesas;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Cargar todos los pedidos al inicio
                pedidos = new BindingList<pedido>(pedidoWS.listarPedidos());
                rptPedidos.DataSource = pedidos;
                rptPedidos.DataBind();

                lblMensaje.Visible = pedidos == null || pedidos.Count == 0;
                lblMensaje.Text = "No hay pedidos registrados.";

                // Cargar las mesas para el dropdown
                mesas = new BindingList<mesa>(mesaWS.listarMesas());
                ddlMesa.Items.Clear();
                ddlMesa.Items.Add(new ListItem("-- Todas --", "0"));
                foreach (var m in mesas)
                {
                    ddlMesa.Items.Add(new ListItem("Mesa #" + m.idMesa, m.idMesa.ToString()));
                }

                // Cargar estados
                ddlEstado.Items.Clear();
                ddlEstado.Items.Add(new ListItem("-- Todos --", "TODOS"));
                ddlEstado.Items.Add(new ListItem("En Orden", "EN_ORDEN"));
                ddlEstado.Items.Add(new ListItem("Cancelado", "CANCELADO"));
                ddlEstado.Items.Add(new ListItem("Entregado", "ENTREGADO"));
            }
        }

        protected void btnFiltrar_Click(object sender, EventArgs e)
        {
            int idMesa = int.Parse(ddlMesa.SelectedValue);
            string estado = ddlEstado.SelectedValue;

            List<pedido> listaFiltrada = new List<pedido>();

            if (idMesa > 0 && estado != "TODOS")
            {
                // Filtrar por mesa y estado manualmente
                var porMesa = pedidoWS.listarPedidosPorMesa(idMesa);
                foreach (var p in porMesa)
                {
                    if (p.estadoPedido.ToString() == estado)
                        listaFiltrada.Add(p);
                }
            }
            else if (idMesa > 0)
            {
                listaFiltrada = new List<pedido>(pedidoWS.listarPedidosPorMesa(idMesa));
            }
            else if (estado != "TODOS")
            {
                listaFiltrada = new List<pedido>(
                    pedidoWS.listarPedidosPorEstado(
                        (estadoPedido)Enum.Parse(typeof(estadoPedido), estado)
                    )
                );
            }
            else
            {
                listaFiltrada = new List<pedido>(pedidoWS.listarPedidos());
            }

            rptPedidos.DataSource = listaFiltrada;
            rptPedidos.DataBind();

            // Mostrar mensaje si no hay resultados
            if (listaFiltrada == null || listaFiltrada.Count == 0)
            {
                string mensaje = "No hay pedidos";
                if (idMesa > 0 && estado != "TODOS")
                    mensaje += $" en la mesa {idMesa} con estado '{estado}'";
                else if (idMesa > 0)
                    mensaje += $" en la mesa {idMesa}";
                else if (estado != "TODOS")
                    mensaje += $" con estado '{estado}'";

                lblMensaje.Text = mensaje;
                lblMensaje.CssClass = "alert alert-warning"; // Estilo opcional
                lblMensaje.Visible = true;
            }
            else
            {
                lblMensaje.Text = string.Empty;
                lblMensaje.Visible = false;
            }
        }

        protected string GetEstadoClase(string estado)
        {
            switch (estado)
            {
                case "EN_ORDEN": return "estado-en-orden";
                case "CANCELADO": return "estado-cancelado";
                case "ENTREGADO": return "estado-entregado";
                default: return "";
            }
        }

        public static string GetEstadoLabel(string estado)
        {
            switch (estado)
            {
                case "EN_ORDEN": return "En Orden";
                case "CANCELADO": return "Cancelado";
                case "ENTREGADO": return "Entregado";
                default: return estado;
            }
        }

        public static string GetHoraFormateada(DateTime fecha)
        {
            return fecha.ToString("HH:mm");
        }
    }
}