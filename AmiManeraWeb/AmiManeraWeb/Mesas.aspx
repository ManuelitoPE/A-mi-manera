<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Mesas.aspx.cs" Inherits="AmiManeraWeb.Mesas" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <asp:ScriptManager ID="ScriptManager1" runat="server" />
    <div class="manage-tables-container">
        <h1 class="page-title">Manage Tables</h1>

        <!-- Filter Controls -->
        <div class="filter-controls">
            <div class="tab-filters">
                <asp:LinkButton ID="btnAll" runat="server" CssClass="tab-filter active" OnClick="TabFilter_Click">
                <span>Pedidos</span>
                <span class="count">12</span>
                </asp:LinkButton>
                <!--        <asp:LinkButton ID="btnReservation" runat="server" CssClass="tab-filter" OnClick="TabFilter_Click">
                <span>Reservation</span>
                <span class="count">4</span>
            </asp:LinkButton>
            <asp:LinkButton ID="btnOnDine" runat="server" CssClass="tab-filter" OnClick="TabFilter_Click">
                <span>On Dine</span>
                <span class="count">3</span>
            </asp:LinkButton> -->
            </div>

            <!-- Date Navigation 
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
        </div> -->

            <!-- Search Box -->
            <div class="customer-search">
                <i class="fas fa-search"></i>
                <input type="text" class="search-input" placeholder="Buscar pedidos" />
                <!-- <asp:TextBox ID="txtSearchCustomers" runat="server" placeholder="Buscar Mesa" CssClass="search-input filter-btn"></asp:TextBox>
            <button type="button" class="filter-btn"><i class="fas"></i>
            </button> -->
            </div>
        </div>
        <div class="main-content-tables">
            <div class="tables-content">


                <!-- Tables Layout -->
                <div class="tables-layout">
                    <!-- Area Tabs -->
                    <div class="area-tabs">
                        <asp:LinkButton ID="btnMainDining" runat="server" CssClass="area-tab active" OnClick="AreaTab_Click">Todos</asp:LinkButton>
                        <asp:LinkButton ID="btnTerrace" runat="server" CssClass="area-tab" OnClick="AreaTab_Click">Libre</asp:LinkButton>
                        <asp:LinkButton ID="btnOutdoor" runat="server" CssClass="area-tab" OnClick="AreaTab_Click">Ocupada</asp:LinkButton>
                        <asp:LinkButton ID="LinkButton1" runat="server" CssClass="area-tab" OnClick="AreaTab_Click">Reservada</asp:LinkButton>
                    </div>

                    <!-- Status Legend -->
                    <div class="status-legend">
                        <div class="legend-item">
                            <span class="status-dot available"></span>
                            <span>Libre</span>
                        </div>
                        <div class="legend-item">
                            <span class="status-dot reserved"></span>
                            <span>Reservada</span>
                        </div>
                        <div class="legend-item">
                            <span class="status-dot ondine"></span>
                            <span>Ocupada</span>
                        </div>
                    </div>

                    <!-- Table Grid -->
                    <div class="table-grid">
                        <asp:Repeater ID="rptTables" runat="server" OnItemCommand="rptTables_ItemCommand">
                            <ItemTemplate>
                                <div class="table-item <%# GetTableStatusClass(Eval("estado").ToString()) %>"
                                    data-table-id='<%# Eval("idMesa") %>'>
                                    <!--<div class="table-chairs top">
                                <%# GetChairIcons(Convert.ToInt32(Eval("cantidadAsientos")), Eval("estado").ToString()) %>
                            </div> -->
                                    <div class="table-box">
                                        <div class="table-number">Mesa #<%# Eval("idMesa") %></div>
                                        <div class="table-capacity">
                                            <i class="fas fa-user-friends"></i>
                                            <span><%# Eval("cantidadAsientos") %></span>
                                        </div>
                                    </div>
                                    <!--
                            <div class="table-chairs bottom">
                                <%# GetChairIcons(Convert.ToInt32(Eval("cantidadAsientos")), Eval("estado").ToString()) %>
                            </div>
                            <div class="table-chairs left">
                                <%# GetChairIcons(Convert.ToInt32(Eval("cantidadAsientos")), Eval("estado").ToString()) %>
                            </div>
                            <div class="table-chairs right">
                                <%# GetChairIcons(Convert.ToInt32(Eval("cantidadAsientos")), Eval("estado").ToString()) %>
                            </div> -->
                                </div>
                            </ItemTemplate>
                        </asp:Repeater>
                    </div>
                </div>
                <!-- Pedidos List -->
                <div class="reservations-list">
                    <asp:Repeater ID="rptReservations" runat="server" OnItemCommand="rptReservations_ItemCommand">
                        <ItemTemplate>
                            <div class="reservation-card <%# GetStatusClass(Eval("estadoPedido").ToString()) %>">
                                <div class="reservation-status">
                                    <div class="time">
                                        <div class="hour"><%# Eval("fecha") %></div>
                                        <div class="period">PM</div>
                                    </div>
                                    <div class="status-label"><%# GetStatusLabel(Eval("estadoPedido").ToString()) %></div>
                                </div>
                                <div class="reservation-details">
                                    <div class="customer-name"><%#GetMeseroName(Eval("mesero"))%></div>
                                    <div class="reservation-info">
                                        <div class="table-info">
                                            <i class="fas fa-border-all"></i>
                                            <span><%# Eval("mesa.idMesa") %></span>
                                        </div>
                                        <div class="people-info">
                                            <i class="fas fa-user-friends"></i>
                                            <span><%# Eval("mesa.cantidadAsientos")  %></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </ItemTemplate>
                    </asp:Repeater>

                    <!-- Add New Reservation Button 
            <asp:LinkButton ID="btnAddReservation" runat="server" CssClass="add-reservation-btn" OnClick="btnAddReservation_Click">
                <i class="fas fa-plus"></i>
                <span>Add New Reservation</span>
            </asp:LinkButton> -->
                </div>
            </div>
        </div>
    </div>


    <!-- Add Reservation Modal -->
    <div id="addReservationModal" class="modal">
        <div class="modal-content">
            <div class="modal-header">
                <h2>Agregar Pedido</h2>
                <button type="button" class="close-btn" onclick="closeModal()">&times;</button>
            </div>
            <div class="modal-body">
                <h3>Pedido</h3>
                <div class="grid-container">
                    <asp:UpdatePanel ID="UpdatePanel2" runat="server">
                        <ContentTemplate>
                            <asp:GridView ID="gvLineaPedido" runat="server"
                                CssClass="table table-striped table-hover" PageSize="5"
                                AutoGenerateColumns="false"
                                EmptyDataText="No reservations found"
                                OnRowDataBound="dgvProductos_RowDataBound" AllowPaging="true"
                                OnPageIndexChanging="dgvProductos_PageIndexChanging">
                                <Columns>
                                    <asp:BoundField HeaderText="Nro" />
                                    <asp:BoundField HeaderText="Nombre" />
                                    <asp:BoundField HeaderText="Precio Unitario" />
                                    <asp:BoundField HeaderText="Tipo" />
                                    <asp:TemplateField>
                                        <ItemTemplate>
                                            <asp:Button ID="btnSaveReservation" runat="server"
                                                Text="<i class='fa-solid fa-edit'></i> Guardar"
                                                CommandName="EditReservation"
                                                OnClick="btnSaveReservation_Click" />
                                        </ItemTemplate>
                                    </asp:TemplateField>
                                </Columns>
                            </asp:GridView>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
                <h3>Productos</h3>
                <div class="grid-container">
                    <asp:UpdatePanel ID="UpdatePanel1" runat="server">
                        <ContentTemplate>
                            <asp:GridView ID="gvProductos" runat="server"
                                CssClass="table table-striped table-hover" PageSize="5"
                                AutoGenerateColumns="false"
                                EmptyDataText="No reservations found"
                                OnRowDataBound="dgvProductos_RowDataBound" AllowPaging="true"
                                OnPageIndexChanging="dgvProductos_PageIndexChanging">
                                <Columns>
                                    <asp:BoundField HeaderText="Nro" />
                                    <asp:BoundField HeaderText="Nombre" />
                                    <asp:BoundField HeaderText="Precio Unitario" />
                                    <asp:BoundField HeaderText="Tipo" />
                                    <asp:TemplateField>
                                        <ItemTemplate>
                                            <asp:TextBox ID="txtCantidad" 
                                                runat="server" CssClass="form-control" 
                                                type="number" 
                                                placeholder="Cantidad" />
                                            <asp:LinkButton runat="server" 
                                                Text="<i class='fa-solid fa-floppy-disk'></i> Agregar"
                                                CssClass="btn btn-warning"
                                                OnClick="btnSaveReservation_Click"/>
                                        </ItemTemplate>
                                    </asp:TemplateField>
                                </Columns>
                            </asp:GridView>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" onclick="closeModal()">Cancel</button>
                <asp:Button ID="btnSaveReservation" runat="server" Text="Agregar Pedido" CssClass="btn btn-primary" OnClick="btnSaveReservation_Click" />
            </div>
        </div>
    </div>
</asp:Content>
