<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Mesas.aspx.cs" Inherits="AmiManeraWeb.Mesas" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <div class="manage-tables-container">
    <h1 class="page-title">Manage Tables</h1>
    
    <!-- Filter Controls -->
    <div class="filter-controls">
        <div class="tab-filters">
            <asp:LinkButton ID="btnAll" runat="server" CssClass="tab-filter active" OnClick="TabFilter_Click">
                <span>All</span>
                <span class="count">12</span>
            </asp:LinkButton>
            <asp:LinkButton ID="btnReservation" runat="server" CssClass="tab-filter" OnClick="TabFilter_Click">
                <span>Reservation</span>
                <span class="count">4</span>
            </asp:LinkButton>
            <asp:LinkButton ID="btnOnDine" runat="server" CssClass="tab-filter" OnClick="TabFilter_Click">
                <span>On Dine</span>
                <span class="count">3</span>
            </asp:LinkButton>
        </div>
        
        <!-- Date Navigation -->
        <div class="date-navigation">
            <asp:LinkButton ID="btnPrevDate" runat="server" CssClass="date-nav-btn" OnClick="DateNav_Click">
                <i class="fas fa-chevron-left"></i>
            </asp:LinkButton>
            
            <div class="current-date">
                <asp:Label ID="lblCurrentDate" runat="server" Text="Thu, 11 January 2024"></asp:Label>
            </div>
            
            <asp:LinkButton ID="btnNextDate" runat="server" CssClass="date-nav-btn" OnClick="DateNav_Click">
                <i class="fas fa-chevron-right"></i>
            </asp:LinkButton>
        </div>
        
        <!-- Search Box -->
        <div class="customer-search">
            <i class="fas fa-search"></i>
            <asp:TextBox ID="txtSearchCustomers" runat="server" placeholder="Search customers" CssClass="search-input"></asp:TextBox>
            <button type="button" class="filter-btn"><i class="fas fa-sliders-h"></i></button>
        </div>
    </div>
    
    <div class="tables-content">
        <!-- Reservations List -->
        <div class="reservations-list">
            <asp:Repeater ID="rptReservations" runat="server" OnItemCommand="rptReservations_ItemCommand">
                <ItemTemplate>
                    <div class="reservation-card <%# GetStatusClass(Eval("Status").ToString()) %>">
                        <div class="reservation-status">
                            <div class="time">
                                <div class="hour"><%# Eval("Time") %></div>
                                <div class="period">PM</div>
                            </div>
                            <div class="status-label"><%# GetStatusLabel(Eval("Status").ToString()) %></div>
                        </div>
                        <div class="reservation-details">
                            <div class="customer-name"><%# Eval("CustomerName") %></div>
                            <div class="reservation-info">
                                <div class="table-info">
                                    <i class="fas fa-border-all"></i>
                                    <span><%# Eval("TableNumber") %></span>
                                </div>
                                <div class="people-info">
                                    <i class="fas fa-user-friends"></i>
                                    <span><%# Eval("People") %></span>
                                </div>
                            </div>
                            <div class="contact-info">
                                <i class="fas fa-phone-alt"></i>
                                <span><%# Eval("ContactNumber") %></span>
                            </div>
                            <div class="payment-status <%# GetPaymentStatusClass(Eval("PaymentStatus").ToString()) %>">
                                <i class="<%# GetPaymentIcon(Eval("PaymentStatus").ToString()) %>"></i>
                                <span><%# Eval("PaymentStatus") %></span>
                            </div>
                        </div>
                    </div>
                </ItemTemplate>
            </asp:Repeater>
            
            <!-- Add New Reservation Button -->
            <asp:LinkButton ID="btnAddReservation" runat="server" CssClass="add-reservation-btn" OnClick="btnAddReservation_Click">
                <i class="fas fa-plus"></i>
                <span>Add New Reservation</span>
            </asp:LinkButton>
        </div>
        
        <!-- Tables Layout -->
        <div class="tables-layout">
            <!-- Area Tabs -->
            <div class="area-tabs">
                <asp:LinkButton ID="btnMainDining" runat="server" CssClass="area-tab active" OnClick="AreaTab_Click">Main Dining</asp:LinkButton>
                <asp:LinkButton ID="btnTerrace" runat="server" CssClass="area-tab" OnClick="AreaTab_Click">Terrace</asp:LinkButton>
                <asp:LinkButton ID="btnOutdoor" runat="server" CssClass="area-tab" OnClick="AreaTab_Click">Outdoor</asp:LinkButton>
            </div>
            
            <!-- Status Legend -->
            <div class="status-legend">
                <div class="legend-item">
                    <span class="status-dot available"></span>
                    <span>Available</span>
                </div>
                <div class="legend-item">
                    <span class="status-dot reserved"></span>
                    <span>Reserved</span>
                </div>
                <div class="legend-item">
                    <span class="status-dot ondine"></span>
                    <span>On Dine</span>
                </div>
            </div>
            
            <!-- Table Grid -->
            <div class="table-grid">
                <asp:Repeater ID="rptTables" runat="server" OnItemCommand="rptTables_ItemCommand">
                    <ItemTemplate>
                        <div class="table-item <%# GetTableStatusClass(Eval("Status").ToString()) %>" 
                             data-table-id='<%# Eval("TableId") %>'>
                            <div class="table-chairs top">
                                <%# GetChairIcons(Convert.ToInt32(Eval("TopChairs")), Eval("Status").ToString()) %>
                            </div>
                            <div class="table-box">
                                <div class="table-number">Table #<%# Eval("TableNumber") %></div>
                                <div class="table-capacity">
                                    <i class="fas fa-user-friends"></i>
                                    <span><%# Eval("Capacity") %></span>
                                </div>
                            </div>
                            <div class="table-chairs bottom">
                                <%# GetChairIcons(Convert.ToInt32(Eval("BottomChairs")), Eval("Status").ToString()) %>
                            </div>
                            <div class="table-chairs left">
                                <%# GetChairIcons(Convert.ToInt32(Eval("LeftChairs")), Eval("Status").ToString()) %>
                            </div>
                            <div class="table-chairs right">
                                <%# GetChairIcons(Convert.ToInt32(Eval("RightChairs")), Eval("Status").ToString()) %>
                            </div>
                        </div>
                    </ItemTemplate>
                </asp:Repeater>
            </div>
        </div>
    </div>
</div>

<!-- Add Reservation Modal -->
<div id="addReservationModal" class="modal">
    <div class="modal-content">
        <div class="modal-header">
            <h2>Add New Reservation</h2>
            <button type="button" class="close-btn" onclick="closeModal()">&times;</button>
        </div>
        <div class="modal-body">
            <div class="form-group">
                <label for="txtCustomerName">Customer Name</label>
                <asp:TextBox ID="txtCustomerName" runat="server" CssClass="form-control" placeholder="Enter customer name"></asp:TextBox>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label for="ddlTable">Table</label>
                    <asp:DropDownList ID="ddlTable" runat="server" CssClass="form-control"></asp:DropDownList>
                </div>
                <div class="form-group">
                    <label for="txtPeople">Number of People</label>
                    <asp:TextBox ID="txtPeople" runat="server" CssClass="form-control" TextMode="Number" min="1" placeholder="People"></asp:TextBox>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label for="txtDate">Date</label>
                    <asp:TextBox ID="txtDate" runat="server" CssClass="form-control" TextMode="Date"></asp:TextBox>
                </div>
                <div class="form-group">
                    <label for="txtTime">Time</label>
                    <asp:TextBox ID="txtTime" runat="server" CssClass="form-control" TextMode="Time"></asp:TextBox>
                </div>
            </div>
            <div class="form-group">
                <label for="txtContactNumber">Contact Number</label>
                <asp:TextBox ID="txtContactNumber" runat="server" CssClass="form-control" placeholder="Enter contact number"></asp:TextBox>
            </div>
            <div class="form-group">
                <label for="ddlStatus">Status</label>
                <asp:DropDownList ID="ddlStatus" runat="server" CssClass="form-control">
                    <asp:ListItem Text="Reserved" Value="Reserved"></asp:ListItem>
                    <asp:ListItem Text="On Dine" Value="OnDine"></asp:ListItem>
                    <asp:ListItem Text="Available" Value="Available"></asp:ListItem>
                </asp:DropDownList>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-secondary" onclick="closeModal()">Cancel</button>
            <asp:Button ID="btnSaveReservation" runat="server" Text="Save Reservation" CssClass="btn btn-primary" OnClick="btnSaveReservation_Click" />
        </div>
    </div>
</div>

<script type="text/javascript">
    function openModal() {
        document.getElementById('addReservationModal').style.display = 'block';
    }

    function closeModal() {
        document.getElementById('addReservationModal').style.display = 'none';
    }

    // Show modal when Add Reservation button is clicked
    document.addEventListener('DOMContentLoaded', function () {
        var addReservationBtn = document.querySelector('.add-reservation-btn');
        if (addReservationBtn) {
            addReservationBtn.addEventListener('click', function (e) {
                openModal();
            });
        }

        // Table item click handler
        var tableItems = document.querySelectorAll('.table-item');
        tableItems.forEach(function (item) {
            item.addEventListener('click', function () {
                var tableId = this.getAttribute('data-table-id');
                showTableDetails(tableId);
            });
        });
    });

    function showTableDetails(tableId) {
        // Here you would show table details or open edit modal
        console.log('Show details for table: ' + tableId);
    }
</script>
</asp:Content>
