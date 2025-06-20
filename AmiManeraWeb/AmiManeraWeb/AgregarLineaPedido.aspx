<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="AgregarLineaPedido.aspx.cs" Inherits="AmiManeraWeb.AgregarLineaPedido" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">

    <!-- Botón Cancelar Pedido alineado a la derecha -->
    <div class="d-flex justify-content-end mb-3">
        <asp:Button ID="btnCancelarPedido" runat="server" Text="Cancelar Pedido" 
                    CssClass="btn btn-danger" OnClick="btnCancelarPedido_Click" 
                    OnClientClick="return confirm('¿Está seguro de cancelar este pedido?');" />
    </div>

    <!-- Panel de búsqueda -->
    <div class="form-inline mb-3">
        <asp:DropDownList ID="ddlCriterio" runat="server" CssClass="form-control mr-2">
            <asp:ListItem Text="Buscar por ID" Value="ID" />
            <asp:ListItem Text="Buscar por Nombre" Value="Nombre" />
        </asp:DropDownList>

        <asp:TextBox ID="txtBuscar" runat="server" CssClass="form-control mr-2" 
                     Placeholder="Ingrese ID o Nombre del producto" />

        <asp:Button ID="btnBuscar" runat="server" Text="Buscar" 
                    CssClass="btn btn-primary mr-2" OnClick="btnBuscar_Click" />
        <asp:Button ID="btnMostrarTodos" runat="server" Text="Mostrar Todos" 
                    CssClass="btn btn-secondary" OnClick="btnMostrarTodos_Click" />
    </div>

    <!-- GridView de productos -->
    <asp:GridView ID="gvProductos" runat="server" AutoGenerateColumns="false" CssClass="table">
        <Columns>
            <asp:TemplateField HeaderText="Producto">
                <ItemTemplate>
                    <%# Eval("nombre") %>
                    <asp:HiddenField ID="hfIdProducto" runat="server" Value='<%# Eval("idProducto") %>' />
                </ItemTemplate>
            </asp:TemplateField>

            <asp:TemplateField HeaderText="Cantidad">
                <ItemTemplate>
                    <asp:TextBox ID="txtCantidad" runat="server" Text="0" Width="60px" CssClass="form-control" />
                </ItemTemplate>
            </asp:TemplateField>
        </Columns>
    </asp:GridView>

    <!-- Botón para guardar -->
    <asp:Button ID="btnGuardar" runat="server" Text="Guardar Pedido" 
                OnClick="btnGuardar_Click" CssClass="btn btn-success" />

</asp:Content>
