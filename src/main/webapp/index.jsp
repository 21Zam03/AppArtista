<%-- 
    Document   : index
    Created on : 14 mar. 2023, 21:58:45
    Author     : DELL
--%>
<%@page import="com.zam.bean.Track"%>
<%@page import="com.zam.controller.Controlador"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
            Controlador control = new Controlador();
            List<Track> lista1 = control.listarTrack_actual();
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <!--Estilo unico para este archivo html-->
        <link rel="stylesheet" href="assets/Css/index-estilo.css"/>
        
        <!--Libreria bootstrap-->
        <link rel="stylesheet" href="assets/Css/Bootstrap/bootstrap.min.css"/>
        
        <!--Estilo para el navegador-->
        <link rel="stylesheet" href="assets/Css/navegador-estilo.css"/>
        
        <!--Libreria Jquery -->
        <script src="assets/Js/Jquery/jquery-3.6.4.min.js"></script>
        <title>Alesso</title>
    </head>
    <body>
        <%@include file="WEB-INF/fragments/menu.jspf"%>
        <main>
            <div class="container-alesso-image">
                <img class="alesso_image" src="Img/alesso.jpg">
            </div>         
            <div class="container-music">
                <img class="alesso_music_title" src="Img/Krewella_MUSIC.png">
                <div class="tracks">
                    <table>
                        <tr>
                            <td><img src="Img/Tracks/<%=lista1.get(0).getImagen()%>"></td>
                            <td>
                                <h2><%=lista1.get(0).getNombre()%></h2>
                                <p>Artistas: Alesso</p>
                                <p>Duracion: <%=lista1.get(0).getDuracion()%></p>
                                <p>Bpm: <%=lista1.get(0).getBpm()%></p>
                                <a href="#">Ir a escuchar -></a>
                            </td>
                        </tr>
                        <tr>
                            <td><img src="Img/Tracks/<%=lista1.get(1).getImagen()%>"></td>
                            <td>
                                <h2><%=lista1.get(1).getNombre()%></h2>
                                <p>Artistas: Alesso</p>
                                <p>Duracion: <%=lista1.get(1).getDuracion()%></p>
                                <p>Bpm: <%=lista1.get(1).getBpm()%></p>
                                <a href="#">Ir a escuchar -></a>
                            </td>
                        </tr>
                        <tr>
                            <td><img src="Img/Tracks/<%=lista1.get(2).getImagen()%>"></td>
                            <td>
                                <h2><%=lista1.get(2).getNombre()%></h2>
                                <p>Artistas: Alesso</p>
                                <p>Duracion: <%=lista1.get(2).getDuracion()%></p>
                                <p>Bpm: <%=lista1.get(2).getBpm()%></p>
                                <a href="#">Ir a escuchar -></a>
                            </td>
                        </tr>
                        <tr>
                            <td><img src="Img/Tracks/<%=lista1.get(3).getImagen()%>"></td>
                            <td>
                                <h2><%=lista1.get(3).getNombre()%></h2>
                                <p>Artistas: Alesso</p>
                                <p>Duracion: <%=lista1.get(3).getDuracion()%></p>
                                <p>Bpm: <%=lista1.get(3).getBpm()%></p>
                                <a href="#">Ir a escuchar -></a>
                            </td>
                        </tr>
                    </table>
                    <a class="ver-mas" href="#">Ver mas</a>
                </div>               
            </div>
            
            <div class="container-video">
                <img class="alesso_music_title" src="Img/Krewella_VIDEO.png">
                <a href="https://www.youtube.com/watch?v=k15Ps4hQmCI" target="_blank"><img class="alesso_video_image" src="Img/Video/alesso-video-image.jpg"></a>
            </div>
            
            <div class="container-tour">
                <img class="alesso_music_title" src="Img/tour.png">
            </div>
        </main>
        
        <footer>
            <img class="alesso_logo" src="Img/logo-alesso.png">
            <ul class="footer-iconos">
                <li><a href="#"><img src="assets/icons/instagram.svg" class="icono-image"></a></li>
                <li><a href="#"><img src="assets/icons/twitter.svg" class="icono-image"></a></li>
                <li><a href="#"><img src="assets/icons/youtube.svg" class="icono-image"></a></li>
                <li><a href="#"><img src="assets/icons/spotify.svg" class="icono-image"></a></li>
                <li><a href="#"><img src="assets/icons/facebook.svg" class="icono-image"></a></li>
                <li><a href="#"><img src="assets/icons/tiktok.svg" class="icono-image"></a></li>
            </ul>
            <p class="alesso_footer">ALESSO</p>    
            <p>
                ©2023 Alesso. All Rights Reserved. | Privacy Policy | Built by 21Zam03
            </p>
        </footer>
        <script src="assets/Js/login-script.js"></script>
    </body>
</html>