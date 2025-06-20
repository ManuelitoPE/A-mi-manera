using AmiManeraWeb.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.ServiceModel.Channels;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AmiManeraWeb
{
    public partial class Mesas : Page
    {
        private MesaWSClient mesaWs = new MesaWSClient();
        private BindingList<mesa> mesas;
        private PedidoWSClient pedidoWS = new PedidoWSClient();
        private BindingList<pedido> pedidos;
        private ProductoWSClient productoWS = new ProductoWSClient();
        private BindingList<producto> productos;
<<<<<<< HEAD

=======
        
>>>>>>> main
        protected void Page_Load(object sender, EventArgs e)
        {

            if (!IsPostBack)
            {
                mesas = new BindingList<mesa>(mesaWs.listarMesas());
                pedidos = new BindingList<pedido>(pedidoWS.listarPedidos());
                productos = new BindingList<producto>(productoWS.listarProductos());
                //PopulateTableDropdown();

                //// Set default date to today
                //txtDate.Text = DateTime.Now.ToString("yyyy-MM-dd");
            }
            rptTables.DataSource = mesas;
            rptTables.DataBind();

<<<<<<< HEAD
            gvProductos.DataSource = productos;
            gvProductos.DataBind();
=======
            //gvProductos.DataSource = productos;
            //gvProductos.DataBind();
>>>>>>> main
            rptReservations.DataSource = pedidos;
            rptReservations.DataBind();
        }

        //    private void PopulateTableDropdown()
        //    {
        //        ddlTable.Items.Clear();

        //        foreach (var table in _tables)
        //        {
        //            ListItem item = new ListItem($"Table #{table.TableNumber}", table.TableId.ToString());
        //            ddlTable.Items.Add(item);
        //        }
        //    }

        protected void TabFilter_Click(object sender, EventArgs e)
        {
            //LinkButton btn = (LinkButton)sender;
            //string tabId = btn.ID;

            //// Set active tab
            //btnAll.CssClass = "tab-filter";
            //btnReservation.CssClass = "tab-filter";
            //btnOnDine.CssClass = "tab-filter";

            //btn.CssClass = "tab-filter active";

            //// Store selected tab
            //if (tabId == "btnAll")
            //    ViewState["SelectedTab"] = "All";
            //else if (tabId == "btnReservation")
            //    ViewState["SelectedTab"] = "Reservation";
            //else if (tabId == "btnOnDine")
            //    ViewState["SelectedTab"] = "OnDine";

            //BindReservations();
        }

        protected void AreaTab_Click(object sender, EventArgs e)
        {
            //LinkButton btn = (LinkButton)sender;
            //string tabId = btn.ID;

            //// Set active tab
            //btnMainDining.CssClass = "area-tab";
            //btnTerrace.CssClass = "area-tab";
            //btnOutdoor.CssClass = "area-tab";

            //btn.CssClass = "area-tab active";

            //// Store selected area
            //if (tabId == "btnMainDining")
            //    ViewState["SelectedArea"] = "MainDining";
            //else if (tabId == "btnTerrace")
            //    ViewState["SelectedArea"] = "Terrace";
            //else if (tabId == "btnOutdoor")
            //    ViewState["SelectedArea"] = "Outdoor";

            //BindTables();
        }

        protected void DateNav_Click(object sender, EventArgs e)
        {
            //LinkButton btn = (LinkButton)sender;
            //string btnId = btn.ID;

            //// Get current date
            //DateTime currentDate = Convert.ToDateTime(lblCurrentDate.Text);

            //// Navigate to previous or next day
            //if (btnId == "btnPrevDate")
            //    currentDate = currentDate.AddDays(-1);
            //else if (btnId == "btnNextDate")
            //    currentDate = currentDate.AddDays(1);

            //// Update label
            //lblCurrentDate.Text = currentDate.ToString("ddd, dd MMMM yyyy");

            //// In a real application, you would load the reservations and tables for the new date
        }

        protected void rptReservations_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            // Handle reservation item commands
        }

        protected void rptTables_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
<<<<<<< HEAD

        }

        protected void dgvProductos_RowDataBound(object sender, GridViewRowEventArgs e)
=======
            if (e.CommandName == "SeleccionarMesa")
            {
                int idMesa = Convert.ToInt32(e.CommandArgument);
                
                Response.Redirect("PedidoMesa.aspx?idMesa=" + idMesa);
            }
        }

        protected void gvProductos_RowDataBound(object sender, GridViewRowEventArgs e)
>>>>>>> main
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[0].Text = DataBinder.Eval(e.Row.DataItem, "idProducto").ToString();
                e.Row.Cells[1].Text = DataBinder.Eval(e.Row.DataItem, "nombre").ToString();
                e.Row.Cells[2].Text = DataBinder.Eval(e.Row.DataItem, "precioUnitario").ToString();
                e.Row.Cells[3].Text = DataBinder.Eval(e.Row.DataItem, "tipoProducto.descripcion").ToString();
            }
        }

<<<<<<< HEAD
        protected void dgvProductos_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvProductos.PageIndex = e.NewPageIndex;
            gvProductos.DataBind();
=======
        protected void gvProductos_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            //gvProductos.PageIndex = e.NewPageIndex;
            //gvProductos.DataBind();
>>>>>>> main
        }

        private void ShowMessage(string v1, string v2)
        {
            throw new NotImplementedException();
        }

        protected void btnAddReservation_Click(object sender, EventArgs e)
        {
            // This will be handled by the JavaScript to show the modal
        }

        protected void btnSaveReservation_Click(object sender, EventArgs e)
        {
            
            //// In a real application, you would save the reservation to the database
            //string customerName = txtCustomerName.Text;
            //int tableId = Convert.ToInt32(ddlTable.SelectedValue);
            //int people = Convert.ToInt32(txtPeople.Text);
            //string date = txtDate.Text;
            //string time = txtTime.Text;
            //string contactNumber = txtContactNumber.Text;
            //string status = ddlStatus.SelectedValue;

            //// Create new reservation
            //int newId = _reservations.Count + 1;

            //ReservationViewModel newReservation = new ReservationViewModel
            //{
            //    ReservationId = newId,
            //    CustomerName = customerName,
            //    TableNumber = GetTableNumberById(tableId),
            //    People = people,
            //    Time = Convert.ToDateTime(time).ToString("h:mm"),
            //    Status = status,
            //    ContactNumber = contactNumber,
            //    PaymentStatus = "Unpaid"
            //};

            //// Update table status
            //UpdateTableStatus(tableId, status);

            //// Add to list
            //_reservations.Add(newReservation);

            //        // Rebind data
            //        BindTables();
            //BindReservations();

            //// Close modal (using JavaScript)
            //ScriptManager.RegisterStartupScript(this, GetType(), "closeModal", "closeModal();", true);
        }

        //    private int GetTableNumberById(int tableId)
        //    {
        //        var table = _tables.Find(t => t.TableId == tableId);
        //        return table?.TableNumber ?? 0;
        //    }

        //    private void UpdateTableStatus(int tableId, string status)
        //    {
        //        var table = _tables.Find(t => t.TableId == tableId);
        //        if (table != null)
        //        {
        //            table.Status = status;
        //        }
        //    }

        //    // Helper methods for UI rendering
<<<<<<< HEAD
        protected string GetStatusClass(string status)
=======
        public string GetStatusClass(string status)
>>>>>>> main
        {
            switch (status)
            {
                case "RESERVADA": return "reserved";
                case "OCUPADA": return "ondine";
                case "LIBRE": return "available";
                default: return "";
            }
        }

        public string GetStatusLabel(string status)
        {
            switch (status)
            {
                case "RESERVADA": return "";
                case "OCUPADA": return "On Dine";
                case "LIBRE": return "Free";
                default: return "";
            }
        }

        protected string GetTableStatusClass(string status)
        {
            switch (status)
            {
                case "RESERVADA": return "table-reserved";
                case "OCUPADA": return "table-ondine";
                case "LIBRE": return "table-available";
                default: return "";
            }
        }

        protected string GetPaymentStatusClass(string status)
        {
            switch (status)
            {
                case "Payment": return "payment-complete";
                case "Unpaid": return "payment-pending";
                case "OnDine": return "ondine";
                case "Free": return "free";
                default: return "";
            }
        }

        protected string GetPaymentIcon(string status)
        {
            switch (status)
            {
                case "Payment": return "fas fa-check-circle";
                case "Unpaid": return "fas fa-clock";
                case "OnDine": return "fas fa-utensils";
                case "Free": return "";
                default: return "";
            }
        }

        public string GetChairIcons(int count, string status)
        {
            string chairClass = GetChairClass(status);
            string result = "";

            for (int i = 0; i < count; i++)
            {
                result += $"<i class=\"fas fa-chair {chairClass}\"></i>";
            }

            return result;
        }

        private string GetChairClass(string status)
        {
            switch (status)
            {
                case "RESERVADA": return "chair-reserved";
                case "OCUPADA": return "chair-ondine";
                case "LIBRE": return "chair-available";
                default: return "";
            }
        }

<<<<<<< HEAD
        protected string GetMeseroName(Object mesero)
        {

            mesero mesero1 = (mesero)mesero;
=======
        public string GetMeseroName(Object mesero)
        {

            trabajador mesero1 = (trabajador)mesero;
>>>>>>> main
            return mesero1.nombre;
        }

        protected int GetNumberTable(mesa mesa)
        {
            return mesa.idMesa;
        }
        protected int GetAsientosMesa(mesa mesa)
        {
            return mesa.cantidadAsientos;
        }

       
        
    }
}