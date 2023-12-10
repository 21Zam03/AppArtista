<%-- 
    Document   : login
    Created on : 9 dic. 2023, 16:45:59
    Author     : DELL
--%>

<%@page import="com.zam.bean.Track"%>
<%@page import="com.zam.controller.Controlador"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Estilo unico para este archivo html-->
        <link rel="stylesheet" href="assets/Css/login-estilo.css"/>
        
        <!--Libreria bootstrap-->
        <link rel="stylesheet" href="assets/Css/Bootstrap/bootstrap.min.css"/>
        
        <!--Estilo para el navegador-->
        <link rel="stylesheet" href="assets/Css/navegador-estilo.css"/>
        
        <!--Libreria Jquery -->
        <script src="assets/Js/Jquery/jquery-3.6.4.min.js"></script>
        <%
            Controlador control = new Controlador();
            List<Track> lista1 = control.listarTrack_actual();
        %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="WEB-INF/fragments/menu.jspf"%>
        <main>
            <div class="container-fluid">
                <div class="row justify-content-center formulario">
                    <div class="col-4 login-columna1">
                        <img src="assets/Img/title.png">
                        <input type="text" id="usuario" placeholder="Ingrese su usuario" autocomplete="current-user">
                        <input type="password" id="contrasena" placeholder="Ingrese su contraseña" autocomplete="current-password">
                        <p id="mensaje">----------------------</p>
                        <div class="botones">
                            <button class="boton-create" onclick="crearCuenta();">Crearme una cuenta</button>
                            <button class="boton-login" onclick="validar();">Iniciar Sesión</button>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <script src="assets/Js/login-script.js"></script>
    </body>
</html>
