/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.zam.controller;

import com.zam.controller.Controlador;
import com.zam.bean.Artista;
import com.zam.bean.Track;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SVTrack", urlPatterns = {"/SVTrack"})
public class SVTrack extends HttpServlet {
    
    Controlador control = new Controlador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Registro de track!!
        Date fecha_lanzamiento = null;
        
        String nombre = request.getParameter("nombre");
        String genero_n = request.getParameter("genero");
        String fecha = request.getParameter("fecha");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fecha_lanzamiento = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        String bpm_t = request.getParameter("bpm");
        String duracion_t = request.getParameter("duracion");
        String escala_t = request.getParameter("escala");
        String discografia_n = request.getParameter("discografica");
        
        Track track = new Track(nombre, genero_n, fecha_lanzamiento, bpm_t, duracion_t, escala_t, discografia_n, "sfdfd");      
        boolean registro = control.registrarTrack(track);
        System.out.println("El registro es: "+registro);
        
        ////////////////////////////////////////////////////////////////////////////////////
        
        //Registro de Artista_Track!!
        Track track_f = control.obtenerTrack(nombre);
        String artista1_n = request.getParameter("artista1");
        String artista2_n = request.getParameter("artista2");
        String artista3_n = request.getParameter("artista3");
        
        String[] artistas = {artista1_n, artista2_n, artista3_n};
        
        for (int i=0; i<artistas.length; i++) {
            if (!artistas[i].equals("Nulo")) {
                Artista artista = control.obtenerArtista(artistas[i]);
                control.registrarArt_Track(artista, track_f);
            }
        }   
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
