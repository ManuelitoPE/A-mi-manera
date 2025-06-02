using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AmiManeraWeb
{
    public partial class Mesas : Page
    {
        // Mock data - in a real application, this would come from a database
        private List<TableViewModel> _tables;
        private List<ReservationViewModel> _reservations;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                InitializeData();
                BindTables();
                BindReservations();
                PopulateTableDropdown();

                // Set default date to today
                txtDate.Text = DateTime.Now.ToString("yyyy-MM-dd");
            }
        }

        private void InitializeData()
        {
            // Initialize tables data
            _tables = new List<TableViewModel>
            {
                new TableViewModel { TableId = 1, TableNumber = 1, Area = "MainDining", Status = "Available", Capacity = 6, TopChairs = 2, BottomChairs = 2, LeftChairs = 1, RightChairs = 1 },
                new TableViewModel { TableId = 2, TableNumber = 2, Area = "MainDining", Status = "Reserved", Capacity = 2, TopChairs = 1, BottomChairs = 1, LeftChairs = 0, RightChairs = 0 },
                new TableViewModel { TableId = 3, TableNumber = 3, Area = "MainDining", Status = "Available", Capacity = 2, TopChairs = 1, BottomChairs = 1, LeftChairs = 0, RightChairs = 0 },
                new TableViewModel { TableId = 4, TableNumber = 4, Area = "MainDining", Status = "Reserved", Capacity = 3, TopChairs = 1, BottomChairs = 1, LeftChairs = 0, RightChairs = 1 },
                new TableViewModel { TableId = 5, TableNumber = 5, Area = "MainDining", Status = "Available", Capacity = 0, TopChairs = 0, BottomChairs = 0, LeftChairs = 0, RightChairs = 0 },
                new TableViewModel { TableId = 6, TableNumber = 6, Area = "MainDining", Status = "OnDine", Capacity = 7, TopChairs = 2, BottomChairs = 2, LeftChairs = 2, RightChairs = 1 },
                new TableViewModel { TableId = 7, TableNumber = 7, Area = "MainDining", Status = "Available", Capacity = 10, TopChairs = 3, BottomChairs = 3, LeftChairs = 2, RightChairs = 2 },
                new TableViewModel { TableId = 8, TableNumber = 8, Area = "MainDining", Status = "Reserved", Capacity = 2, TopChairs = 1, BottomChairs = 1, LeftChairs = 0, RightChairs = 0 },
                new TableViewModel { TableId = 9, TableNumber = 9, Area = "MainDining", Status = "OnDine", Capacity = 4, TopChairs = 2, BottomChairs = 2, LeftChairs = 0, RightChairs = 0 },
                new TableViewModel { TableId = 10, TableNumber = 10, Area = "MainDining", Status = "Reserved", Capacity = 2, TopChairs = 1, BottomChairs = 1, LeftChairs = 0, RightChairs = 0 },
                new TableViewModel { TableId = 11, TableNumber = 11, Area = "MainDining", Status = "Available", Capacity = 2, TopChairs = 1, BottomChairs = 1, LeftChairs = 0, RightChairs = 0 },
                new TableViewModel { TableId = 12, TableNumber = 12, Area = "MainDining", Status = "Available", Capacity = 8, TopChairs = 2, BottomChairs = 2, LeftChairs = 2, RightChairs = 2 }
            };

            // Initialize reservations data
            _reservations = new List<ReservationViewModel>
            {
                new ReservationViewModel { ReservationId = 1, CustomerName = "Uthman ibn Hunaif", TableNumber = 1, People = 6, Time = "7:30", Status = "Reserved", ContactNumber = "+84 678 890 000", PaymentStatus = "Payment" },
                new ReservationViewModel { ReservationId = 2, CustomerName = "Bashir ibn Sa'ad", TableNumber = 2, People = 2, Time = "", Status = "OnDine", ContactNumber = "", PaymentStatus = "OnDine" },
                new ReservationViewModel { ReservationId = 3, CustomerName = "Ali", TableNumber = 3, People = 2, Time = "8:00", Status = "Reserved", ContactNumber = "+84 342 556 555", PaymentStatus = "Payment" },
                new ReservationViewModel { ReservationId = 4, CustomerName = "Khunais ibn Hudhafa", TableNumber = 4, People = 3, Time = "", Status = "OnDine", ContactNumber = "", PaymentStatus = "OnDine" },
                new ReservationViewModel { ReservationId = 5, CustomerName = "Available Now", TableNumber = 5, People = 0, Time = "", Status = "Available", ContactNumber = "", PaymentStatus = "Free" },
                new ReservationViewModel { ReservationId = 6, CustomerName = "Mus'ab ibn Umayr", TableNumber = 6, People = 7, Time = "8:25", Status = "Reserved", ContactNumber = "+84 800 563 554", PaymentStatus = "Unpaid" },
                new ReservationViewModel { ReservationId = 7, CustomerName = "Shuja ibn Wahb", TableNumber = 7, People = 10, Time = "9:00", Status = "Reserved", ContactNumber = "", PaymentStatus = "Payment" }
            };
        }

        private void BindTables()
        {
            // Filter tables based on selected area (default: MainDining)
            string selectedArea = ViewState["SelectedArea"]?.ToString() ?? "MainDining";

            var filteredTables = _tables.FindAll(t => t.Area == selectedArea);
            rptTables.DataSource = filteredTables;
            rptTables.DataBind();
        }

        private void BindReservations()
        {
            // Filter reservations based on selected tab (default: All)
            string selectedTab = ViewState["SelectedTab"]?.ToString() ?? "All";

            var filteredReservations = _reservations;
            if (selectedTab == "Reservation")
            {
                filteredReservations = _reservations.FindAll(r => r.Status == "Reserved");
            }
            else if (selectedTab == "OnDine")
            {
                filteredReservations = _reservations.FindAll(r => r.Status == "OnDine");
            }

            rptReservations.DataSource = filteredReservations;
            rptReservations.DataBind();
        }

        private void PopulateTableDropdown()
        {
            ddlTable.Items.Clear();

            foreach (var table in _tables)
            {
                ListItem item = new ListItem($"Table #{table.TableNumber}", table.TableId.ToString());
                ddlTable.Items.Add(item);
            }
        }

        protected void TabFilter_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            string tabId = btn.ID;

            // Set active tab
            btnAll.CssClass = "tab-filter";
            btnReservation.CssClass = "tab-filter";
            btnOnDine.CssClass = "tab-filter";

            btn.CssClass = "tab-filter active";

            // Store selected tab
            if (tabId == "btnAll")
                ViewState["SelectedTab"] = "All";
            else if (tabId == "btnReservation")
                ViewState["SelectedTab"] = "Reservation";
            else if (tabId == "btnOnDine")
                ViewState["SelectedTab"] = "OnDine";

            BindReservations();
        }

        protected void AreaTab_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            string tabId = btn.ID;

            // Set active tab
            btnMainDining.CssClass = "area-tab";
            btnTerrace.CssClass = "area-tab";
            btnOutdoor.CssClass = "area-tab";

            btn.CssClass = "area-tab active";

            // Store selected area
            if (tabId == "btnMainDining")
                ViewState["SelectedArea"] = "MainDining";
            else if (tabId == "btnTerrace")
                ViewState["SelectedArea"] = "Terrace";
            else if (tabId == "btnOutdoor")
                ViewState["SelectedArea"] = "Outdoor";

            BindTables();
        }

        protected void DateNav_Click(object sender, EventArgs e)
        {
            LinkButton btn = (LinkButton)sender;
            string btnId = btn.ID;

            // Get current date
            DateTime currentDate = Convert.ToDateTime(lblCurrentDate.Text);

            // Navigate to previous or next day
            if (btnId == "btnPrevDate")
                currentDate = currentDate.AddDays(-1);
            else if (btnId == "btnNextDate")
                currentDate = currentDate.AddDays(1);

            // Update label
            lblCurrentDate.Text = currentDate.ToString("ddd, dd MMMM yyyy");

            // In a real application, you would load the reservations and tables for the new date
        }

        protected void rptReservations_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            // Handle reservation item commands
        }

        protected void rptTables_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            // Handle table item commands
        }

        protected void btnAddReservation_Click(object sender, EventArgs e)
        {
            // This will be handled by the JavaScript to show the modal
        }

        protected void btnSaveReservation_Click(object sender, EventArgs e)
        {
            // In a real application, you would save the reservation to the database
            string customerName = txtCustomerName.Text;
            int tableId = Convert.ToInt32(ddlTable.SelectedValue);
            int people = Convert.ToInt32(txtPeople.Text);
            string date = txtDate.Text;
            string time = txtTime.Text;
            string contactNumber = txtContactNumber.Text;
            string status = ddlStatus.SelectedValue;

            // Create new reservation
            int newId = _reservations.Count + 1;

            ReservationViewModel newReservation = new ReservationViewModel
            {
                ReservationId = newId,
                CustomerName = customerName,
                TableNumber = GetTableNumberById(tableId),
                People = people,
                Time = Convert.ToDateTime(time).ToString("h:mm"),
                Status = status,
                ContactNumber = contactNumber,
                PaymentStatus = "Unpaid"
            };

            // Update table status
            UpdateTableStatus(tableId, status);

            // Add to list
            _reservations.Add(newReservation);

            // Rebind data
            BindTables();
            BindReservations();

            // Close modal (using JavaScript)
            ScriptManager.RegisterStartupScript(this, GetType(), "closeModal", "closeModal();", true);
        }

        private int GetTableNumberById(int tableId)
        {
            var table = _tables.Find(t => t.TableId == tableId);
            return table?.TableNumber ?? 0;
        }

        private void UpdateTableStatus(int tableId, string status)
        {
            var table = _tables.Find(t => t.TableId == tableId);
            if (table != null)
            {
                table.Status = status;
            }
        }

        // Helper methods for UI rendering
        protected string GetStatusClass(string status)
        {
            switch (status)
            {
                case "Reserved": return "reserved";
                case "OnDine": return "ondine";
                case "Available": return "available";
                default: return "";
            }
        }

        protected string GetStatusLabel(string status)
        {
            switch (status)
            {
                case "Reserved": return "";
                case "OnDine": return "On Dine";
                case "Available": return "Free";
                default: return "";
            }
        }

        protected string GetTableStatusClass(string status)
        {
            switch (status)
            {
                case "Reserved": return "table-reserved";
                case "OnDine": return "table-ondine";
                case "Available": return "table-available";
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

        protected string GetChairIcons(int count, string status)
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
                case "Reserved": return "chair-reserved";
                case "OnDine": return "chair-ondine";
                case "Available": return "chair-available";
                default: return "";
            }
        }
    }

    // View Models
    public class TableViewModel
    {
        public int TableId { get; set; }
        public int TableNumber { get; set; }
        public string Area { get; set; }
        public string Status { get; set; }
        public int Capacity { get; set; }
        public int TopChairs { get; set; }
        public int BottomChairs { get; set; }
        public int LeftChairs { get; set; }
        public int RightChairs { get; set; }
    }

    public class ReservationViewModel
    {
        public int ReservationId { get; set; }
        public string CustomerName { get; set; }
        public int TableNumber { get; set; }
        public int People { get; set; }
        public string Time { get; set; }
        public string Status { get; set; }
        public string ContactNumber { get; set; }
        public string PaymentStatus { get; set; }
    }
}