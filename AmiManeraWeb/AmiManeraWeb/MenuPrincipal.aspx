<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="MenuPrincipal.aspx.cs" Inherits="AmiManeraWeb.MenuPrincipal" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style>
        .welcome-container {
            margin-top: 60px;
            text-align: center;
            color: #333;
        }

        .welcome-container h1 {
            font-size: 2.5rem;
            color: #2c3e50;
        }

        .welcome-container p {
            font-size: 1.2rem;
            color: #555;
            margin-top: 15px;
        }

        .emoji {
            font-size: 2rem;
            margin-left: 10px;
        }
    </style>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <div class="welcome-container">
        <h1>¡Bienvenido, <asp:Label ID="lblNombreUsuario" runat="server" Text=""></asp:Label>! <span class="emoji">👋</span></h1>
        <p>Seleccione una opción del menú lateral para comenzar a trabajar en el sistema.</p>
    </div>
</asp:Content>