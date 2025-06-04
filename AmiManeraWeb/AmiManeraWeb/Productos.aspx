<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Productos.aspx.cs" Inherits="AmiManeraWeb.Productos" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <h2 class="mb-3">Gestión de Productos</h2>

    <asp:Label ID="lblMensaje" runat="server" CssClass="text-danger"></asp:Label>

    <div class="form-grid">
        <asp:HiddenField ID="hdnIdProducto" runat="server" />

        <asp:Label AssociatedControlID="txtNombre" runat="server" Text="Nombre:" />
        <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control" />

        <asp:Label AssociatedControlID="txtDescripcion" runat="server" Text="Descripción:" />
        <asp:TextBox ID="txtDescripcion" runat="server" CssClass="form-control" />

        <asp:Label AssociatedControlID="txtPrecio" runat="server" Text="Precio Unitario:" />
        <asp:TextBox ID="txtPrecio" runat="server" CssClass="form-control" />

        <asp:Label AssociatedControlID="ddlTipoProducto" runat="server" Text="Tipo de Producto:" />
        <asp:DropDownList ID="ddlTipoProducto" runat="server" CssClass="form-control" DataTextField="descripcion" DataValueField="idTipoProducto" />

        <asp:Button ID="btnGuardar" runat="server" Text="Guardar" CssClass="btn btn-primary mt-2" OnClick="btnGuardar_Click" />
        <asp:Button ID="btnCancelar" runat="server" Text="Cancelar" CssClass="btn btn-secondary mt-2" OnClick="btnCancelar_Click" />
    </div>

    <hr />

    <asp:GridView ID="gvProductos" runat="server" AutoGenerateColumns="False" CssClass="table"
        DataKeyNames="idProducto" OnRowCommand="gvProductos_RowCommand">
        <Columns>
            <asp:BoundField DataField="Nombre" HeaderText="Nombre" />
            <asp:BoundField DataField="Descripcion" HeaderText="Descripción" />
            <asp:BoundField DataField="PrecioUnitario" HeaderText="Precio Unitario" DataFormatString="{0:C}" />
            <asp:BoundField DataField="TipoProducto.descripcion" HeaderText="Tipo de Producto" />

            <asp:TemplateField HeaderText="Acciones">
                <ItemTemplate>
                    <asp:LinkButton ID="lnkEditar" runat="server" CommandName="Editar" CommandArgument='<%# Eval("idProducto") %>' CssClass="btn btn-sm btn-info">Editar</asp:LinkButton>
                    <asp:LinkButton ID="lnkEliminar" runat="server" CommandName="Eliminar" CommandArgument='<%# Eval("idProducto") %>' CssClass="btn btn-sm btn-danger" OnClientClick="return confirm('¿Está seguro de eliminar este producto?');">Eliminar</asp:LinkButton>
                </ItemTemplate>
            </asp:TemplateField>
        </Columns>
    </asp:GridView>
</asp:Content>