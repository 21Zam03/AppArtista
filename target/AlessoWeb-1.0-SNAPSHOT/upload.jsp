<%-- 
    Document   : upload
    Created on : 16 mar. 2023, 08:46:23
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/header.css"/>
        <link rel="stylesheet" href="assets/upload_style.css"/>
        <title>Alesso - upload</title>
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
                <h1>Escoga una opcion</h1>
                <ul>
                    <a href="reg_artista.jsp">Registrar Artista</a>
                    <a href="reg_musica.jsp">Registrar Track</a>
                    <a href="">Registrar Video</a>
                    <a href="">Registrar Tour</a>
                    <a href="index.jsp" class="volver">Volver</a>
                </ul>
            </div>
        </main>
    </body>
</html>
