<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="PedidoMesa.aspx.cs" Inherits="AmiManeraWeb.PedidosMesa" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <style>
        body {
            background-color: #f0f2f5;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .contenedor-principal {
            max-width: 900px;
            margin: 30px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        .btn-primario, .btn-secundario {
            display: inline-block;
            padding: 10px 18px;
            margin: 10px 5px 20px 0;
            border: none;
            border-radius: 6px;
            font-size: 14px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn-primario {
            background-color: #3c1518;
            color: #fff;
        }

        .btn-primario:hover {
            background-color: #5a1a1d;
        }

        .btn-secundario {
            background-color: #555;
            color: #fff;
        }

        .btn-secundario:hover {
            background-color: #333;
        }

        .pedido-card {
            background-color: #fafafa;
            border: 1px solid #ddd;
            padding: 15px;
            border-radius: 8px;
            margin-bottom: 20px;
        }

        .pedido-card div {
            margin-bottom: 8px;
            color: #444;
        }

        /* Modal styles */
        .modal-overlay {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0,0,0,0.6);
            display: none;
            justify-content: center;
            align-items: center;
            z-index: 1000;
        }

        .modal {
            background: #fff;
            padding: 20px;
            width: 500px;
            max-width: 90%;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.3);
            position: relative;
        }

        .modal h4 {
            margin-top: 0;
            margin-bottom: 15px;
            color: #333;
        }

        .modal-close {
            position: absolute;
            top: 10px;
            right: 15px;
            background: none;
            border: none;
            font-size: 18px;
            cursor: pointer;
            color: #888;
        }

        .modal-close:hover {
            color: #000;
        }

        .modal ul {
            margin-left: 20px;
        }
    </style>

    <div class="contenedor-principal">
        <h2>Pedidos Registrados</h2>

        <asp:Button ID="Button1" runat="server" Text="Agregar Pedido"
            OnClick="btnAgregarPedido_Click" CssClass="btn-primario" />

        <!-- Lista de pedidos -->
        <asp:Repeater ID="rptPedidos" runat="server" OnItemCommand="rptPedidos_ItemCommand">
            <ItemTemplate>
                <div class="pedido-card">
                    <div><strong>Pedido:</strong> <%# Eval("idPedido") %></div>
                    <div><strong>Estado:</strong> <%# Eval("estadoPedido") %></div>
                    <div><strong>Monto Total:</strong> S/ <%# Eval("montoTotal") %></div>
                    <asp:Button ID="btnVerLineas" runat="server" Text="Ver Detalle" 
                        CommandName="VerDetalle" CommandArgument='<%# Eval("idPedido") %>' 
                        CssClass="btn-primario" />
                </div>
            </ItemTemplate>
        </asp:Repeater>

        <asp:Button ID="btnModificarPedido" runat="server" Text="Modificar Pedido"
            OnClick="btnModificarPedido_Click" CssClass="btn-secundario" />
    </div>

    <!-- Modal de detalle -->
    <div id="modalDetalle" class="modal-overlay">
        <div class="modal">
            <button class="modal-close" onclick="cerrarModal()">×</button>
            <h4>Detalles del Pedido</h4>
            <asp:Repeater ID="rptLineasPedido" runat="server">
                <HeaderTemplate><ul></HeaderTemplate>
                <ItemTemplate>
                    <li><%# Eval("producto.nombre") %> - Cantidad: <%# Eval("cantidadProducto") %></li>
                </ItemTemplate>
                <FooterTemplate></ul></FooterTemplate>
            </asp:Repeater>
        </div>
    </div>

    <script>
        function mostrarModal() {
            document.getElementById('modalDetalle').style.display = 'flex';
        }

        function cerrarModal() {
            document.getElementById('modalDetalle').style.display = 'none';
        }
    </script>
</asp:Content>
