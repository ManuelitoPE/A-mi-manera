<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Pedidos.aspx.cs" Inherits="AmiManeraWeb.Pedidos" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <style>
        .grid-container {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
            gap: 16px;
            padding: 20px 0;
        }

        .pedido-card {
            border: 1px solid #ddd;
            border-radius: 12px;
            padding: 16px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0,0,0,0.05);
            transition: transform 0.2s ease;
        }

        .pedido-card:hover {
            transform: scale(1.02);
        }

        .pedido-card h5 {
            margin: 0 0 12px;
            font-size: 1.1rem;
            color: #333;
        }

        .pedido-info {
            margin-bottom: 8px;
            font-size: 0.95rem;
            color: #444;
        }

        .pedido-info i {
            margin-right: 8px;
            color: #555;
        }

        .alert-warning {
            padding: 10px 15px;
            background-color: #fff3cd;
            border: 1px solid #ffeeba;
            border-radius: 6px;
            color: #856404;
            margin-top: 15px;
        }
    </style>

    <!-- Dropdowns y botÃ³n -->
    <div>
        <asp:DropDownList ID="ddlMesa" runat="server" />
        <asp:DropDownList ID="ddlEstado" runat="server" />
        <asp:Button ID="btnFiltrar" runat="server" Text="Filtrar" OnClick="btnFiltrar_Click" />
    </div>

    <!-- Mensaje si no hay resultados -->
    <asp:Label ID="lblMensaje" runat="server" CssClass="alert-warning" Visible="false" />

    <!-- Repeater con grilla personalizada -->
    <div class="grid-container">
        <asp:Repeater ID="rptPedidos" runat="server">
            <ItemTemplate>
                <div class="pedido-card">
                    <h5><i class="fas fa-receipt"></i> Pedido #<%# Eval("idPedido") %></h5>
                    <div class="pedido-info"><i class="fas fa-chair"></i> Mesa: <%# Eval("mesa.idMesa") %></div>
                    <div class="pedido-info"><i class="fas fa-info-circle"></i> Estado: <%# AmiManeraWeb.Pedidos.GetEstadoLabel(Eval("estadoPedido").ToString()) %></div>
                    <div class="pedido-info"><i class="fas fa-clock"></i> Hora: <%# AmiManeraWeb.Pedidos.GetHoraFormateada((DateTime)Eval("fecha")) %></div>
                    <div class="pedido-info"><i class="fas fa-money-bill-wave"></i> Monto: S/ <%# Eval("montoTotal", "{0:N2}") %></div>
                </div>
            </ItemTemplate>
        </asp:Repeater>
    </div>
</asp:Content>
