<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="ModificarLineaPedido.aspx.cs" Inherits="AmiManeraWeb.ModificarLineaPedido" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">

    <!-- Botón Cancelar en la parte superior derecha -->
    <div class="d-flex justify-content-between mb-3">
        <h3>Modificar Pedido</h3>
        <asp:Button ID="btnCancelar" runat="server" Text="Cancelar Pedido" CssClass="btn btn-danger" OnClick="btnCancelar_Click" />
    </div>

    <!-- Panel de búsqueda -->
    <div class="form-inline mb-3">
        <asp:DropDownList ID="ddlCriterio" runat="server" CssClass="form-control mr-2">
            <asp:ListItem Text="Buscar por ID" Value="ID" />
            <asp:ListItem Text="Buscar por Nombre" Value="Nombre" />
        </asp:DropDownList>

        <asp:TextBox ID="txtBuscar" runat="server" CssClass="form-control mr-2" Placeholder="Ingrese ID o Nombre del producto" />
        <asp:Button ID="btnBuscar" runat="server" Text="Buscar" CssClass="btn btn-primary mr-2" OnClick="btnBuscar_Click" />
        <asp:Button ID="btnMostrarTodos" runat="server" Text="Mostrar Todos" CssClass="btn btn-secondary" OnClick="btnMostrarTodos_Click" />
    </div>

    <!-- GridView de productos para agregar -->
    <h5>Agregar Productos</h5>
    <asp:GridView ID="gvProductos" runat="server" AutoGenerateColumns="false" CssClass="table table-bordered">
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

    <!-- GridView de líneas ya añadidas -->
    <h5>Productos ya añadidos</h5>
    <asp:GridView ID="gvLineas" runat="server" AutoGenerateColumns="false" CssClass="table table-striped"
        OnRowCommand="gvLineas_RowCommand">
        <Columns>
            <asp:BoundField DataField="producto.nombre" HeaderText="Detalle del Pedido" />
            <asp:BoundField DataField="cantidadProducto" HeaderText="Cantidad" />
        
            <asp:TemplateField HeaderText="Acciones">
                <ItemTemplate>
                    <asp:Button ID="btnEliminar" runat="server" Text="Eliminar" CssClass="btn btn-danger btn-sm"
                        CommandName="Eliminar" CommandArgument='<%# Eval("idLineaPedido") %>' />
                </ItemTemplate>
            </asp:TemplateField>
        </Columns>
    </asp:GridView>

    <!-- Botón para guardar -->
    <asp:Button ID="btnGuardar" 
        runat="server" Text="Guardar Pedido" CssClass="btn btn-success mt-3" OnClick="btnGuardar_Click" />

</asp:Content>


