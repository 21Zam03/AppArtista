<%-- 
    Document   : reg_artista
    Created on : 16 mar. 2023, 21:57:35
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/header.css"/>
        <link rel="stylesheet" href="assets/reg-artista-style.css"/>
        <title>Alesso - artista</title>
    </head>
    <body>
        <header>
            <img class="alesso_title" src="Img/title.png">
            <nav>
                <ul class="iconos">
                    <li><a href="#"><img src="assets/icons/instagram.svg" class="icono-image"></a></li>
                    <li><a href="#"><img src="assets/icons/twitter.svg" class="icono-image"></a></li>
                    <li><a href="#"><img src="assets/icons/youtube.svg" class="icono-image"></a></li>
                    <li><a href="#"><img src="assets/icons/spotify.svg" class="icono-image"></a></li>
                    <li><a href="#"><img src="assets/icons/facebook.svg" class="icono-image"></a></li>
                    <li><a href="#"><img src="assets/icons/tiktok.svg" class="icono-image"></a></li>
                </ul>
                <ul>                 
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="#">Music</a></li>
                    <li><a href="#">Videos</a></li>
                    <li><a href="#">Tour</a></li>
                    <li><a href="upload.jsp">Upload</a></li>
                </ul>
            </nav>
        </header>
        <main>
            <div class="contenedor-opciones">
                <h1>Registro de artista</h1>
                <form action="SVArtista" method="POST">
                    <label for="nombre">Nombre: <input type="text" id="nombre" name="nombre"></label>
                    <label for="info" class="text-area">Informacion: <textarea id="info" name="info"></textarea></label>
                    <button type="submit">Enviar</button>
                </form>
            </div>
        </main>
    </body>
</html>
