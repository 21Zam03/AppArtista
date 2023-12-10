<%-- 
    Document   : registrar_musica
    Created on : 16 mar. 2023, 11:23:00
    Author     : DELL
--%>

<%@page import="com.zam.logica.Artista"%>
<%@page import="java.util.List"%>
<%@page import="com.zam.controladora.Controlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/header.css"/>
        <link rel="stylesheet" href="assets/reg-musica_estilo.css"/>
        <% 
            Controlador control = new Controlador();
            List<Artista> lista1 = control.listarArtista();
        %>
        <title>Alesso - Reg Musica</title>
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
                <h1>Registro de track</h1>
                <form action="SVTrack" method="POST">
                    <label for="nombre">Nombre: <input type="text" id="nombre" name="nombre"></label>
                    <label for="artista1">Artista 1: 
                        <select id="artista1" name="artista1">
                            <%
                                    for (int i=0; i<lista1.size(); i++) {
                                    %>
                                            <option value="<%=lista1.get(i).getNombre()%>"><%=lista1.get(i).getNombre()%></option>
                                    <%    }
                                            %> 
                        </select>
                    </label>
                    <label for="artista2">Artista 2: 
                        <select id="artista2" name="artista2">
                            <option value="Nulo">-------</option>
                            <%
                                    for (int i=0; i<lista1.size(); i++) {
                                    %>
                                            <option value="<%=lista1.get(i).getNombre()%>"><%=lista1.get(i).getNombre()%></option>
                                    <%    }
                                            %> 
                        </select>
                    </label>
                    <label for="artista3">Artista 3: 
                        <select id="artista3" name="artista3">
                            <option value="Nulo">-------</option>
                            <%
                                    for (int i=0; i<lista1.size(); i++) {
                                    %>
                                            <option value="<%=lista1.get(i).getNombre()%>"><%=lista1.get(i).getNombre()%></option>
                                    <%    }
                                            %> 
                        </select>
                    </label>
                    <label for="genero">Genero: <input type="text" id="genero" name="genero"></label>
                    <label for="fecha">Fecha lanzamiento: <input type="date" id="fecha" name="fecha"></label>
                    <label for="bpm">Bpm: <input type="text" id="bpm" name="bpm"></label>
                    <label for="duracion">Duracion: <input type="text" id="duracion" name="duracion"></label>
                    <label for="escala">Escala: <input type="text" id="escala" name="escala"></label>
                    <label for="discografica">Discografica: <input type="text" id="discografica" name="discografica"></label>
                    <button type="submit">Enviar</button>
                </form>
            </div>
        </main>
    </body>
</html>
