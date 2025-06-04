<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Productos.aspx.cs" Inherits="AmiManeraWeb.Productos" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <h2 class="form-title">Gestión de Productos</h2>

    <asp:Panel ID="pnlFormulario" runat="server" CssClass="form-container">
        <asp:Label ID="lblNombre" runat="server" Text="Nombre:" class="form-label"></asp:Label>
        <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control" />

        <asp:Label ID="lblDescripcion" runat="server" Text="Descripción:" class="form-label"></asp:Label>
        <asp:TextBox ID="txtDescripcion" runat="server" CssClass="form-control" TextMode="MultiLine" Rows="3" />

        <asp:Label ID="lblPrecio" runat="server" Text="Precio Unitario:" class="form-label"></asp:Label>
        <asp:TextBox ID="txtPrecio" runat="server" CssClass="form-control" TextMode="Number" />

        <asp:Label ID="lblTipo" runat="server" Text="Tipo de Producto:" class="form-label"></asp:Label>
        <asp:DropDownList ID="ddlTipoProducto" runat="server" CssClass="form-control" />

        <asp:HiddenField ID="hfIdProducto" runat="server" />

        <asp:Button ID="btnGuardar" runat="server" Text="Guardar" CssClass="btn btn-primary mt-3" OnClick="btnGuardar_Click" />
        <asp:Button ID="btnLimpiar" runat="server" Text="Limpiar" CssClass="btn btn-secondary mt-3 ml-2" OnClick="btnLimpiar_Click" />
    </asp:Panel>

    <hr />

    <asp:GridView ID="gvProductos" runat="server" AutoGenerateColumns="False" CssClass="table table-bordered mt-4"
        OnRowCommand="gvProductos_RowCommand">
        <Columns>
            <asp:BoundField DataField="Nombre" HeaderText="Nombre" />
            <asp:BoundField DataField="Descripcion" HeaderText="Descripción" />
            <asp:BoundField DataField="PrecioUnitario" HeaderText="Precio Unitario" DataFormatString="{0:C}" />
            <asp:BoundField DataField="TipoProducto.Descripcion" HeaderText="Tipo" />

            <asp:ButtonField CommandName="Editar" Text="Editar" ButtonType="Button" />
            <asp:ButtonField CommandName="Eliminar" Text="Eliminar" ButtonType="Button" />
        </Columns>
    </asp:GridView>
</asp:Content>
