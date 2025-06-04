<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="AmiManeraWeb.Login" %>

<!DOCTYPE html>
<html lang="es">
<head runat="server">
    <meta charset="utf-8" />
    <title>A Mi Manera – Inicio de sesión</title>

    <!-- ▸ TIPO DE LETRA & RESETEO RÁPIDO  -->
    <%--<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600;800&display=swap" rel="stylesheet" />--%>

    <style>
        /* ——— Layout de pantalla dividida ——— */
        html,body{height:100%;margin:0;font-family:'Inter',sans-serif;}
        .login-wrapper{display:flex;height:100%;}
        .login-left{
            flex:1;display:flex;flex-direction:column;justify-content:center;
            padding:100px;max-width:460px;margin:auto;
        }
        .login-right{
            flex:1;background:url('/Content/Images/login-background.png') center;
            position:relative;
        }
        /* ——— Elementos del formulario ——— */
        .logo{width:120px;margin-bottom:32px;}
        .title{font-size:40px;font-weight:600;color:#ff5b1c;margin:0 0 10px;}
        .subtitle{font-size:16px;color:#555;margin:0 0 30px;}
        .input{width:100%;padding:12px 18px;font-size:16px;border:2px solid #cfcfcf;
               border-radius:28px;margin-bottom:20px;outline:none;}
        .btn-login{
            width:100%;padding:12px 18px;font-size:18px;font-weight:500;color:#fff;
            background:#ff5b1c;border:none;border-radius:30px;cursor:pointer;
            transition:opacity .2s;
        }
        .btn-login:hover{opacity:.9;}
        .msg-error{color:#e53e3e;margin-top:10px;font-size:14px;}
        /* ——— Logo sobre la imagen ——— */
        .login-right .brand{
            position:absolute;top:40px;right:40px;text-align:right;color:#fff;
        }
        .brand img{width:300px;display:block;margin:0 auto 4px;}
        /* ——— Responsive ——— */
        @media(max-width:800px){.login-right{display:none;}}
    </style>
</head>

<body>
    <form id="form1" runat="server" class="login-wrapper">

        <!-- ◂ Zona Izquierda — Formulario -->
        <div class="login-left">
            <img src="/Content/Images/logo.png" alt="Logo A Mi Manera" class="logo" />
            <h1 class="title">¡Bienvenido!</h1>
            <p class="subtitle">Inicie sesión con su cuenta:</p>

            <asp:Label ID="lblMensaje" runat="server" CssClass="msg-error" Visible="false" />

            <asp:TextBox ID="txtUsuario" runat="server"
                CssClass="input" placeholder="Nombre de usuario" />

            <asp:TextBox ID="txtPassword" runat="server"
                CssClass="input" TextMode="Password" placeholder="Contraseña" />

            <asp:Button ID="btnLogin" runat="server"
                Text="Iniciar Sesión" CssClass="btn-login" OnClick="btnLogin_Click" />
        </div>

        <!-- ◂ Zona Derecha — Imagen de fondo y logotipo -->
        <div class="login-right">
            <div class="brand">
                <img src="/Content/Images/logo.png" alt="Logo blanco"/>
            </div>
        </div>

    </form>
</body>
</html>