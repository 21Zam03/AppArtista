/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.zam.controller;

import com.zam.bean.Usuario;
import com.zam.service.UsuarioService;
import com.zam.service.impl.UsuarioServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        
        UsuarioService usuarioService = new UsuarioServiceImpl();
        Usuario user = usuarioService.obtenerUsuario(usuario, contrasena);
        
        if (user.getIdUsuario() != null) {
            HttpSession session = request.getSession();
            session.setAttribute("nombre", user.getNombre_usuario());
            session.setAttribute("contrasena", user.getContrasena());
            session.setAttribute("tipo", user.getTipo());
            // Crear una respuesta JSON indicando el éxito
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("success", true);
            
            // Enviar la respuesta JSON al cliente
            response.getWriter().write(jsonResponse.toString());          
        } else {
            // Crear una respuesta JSON indicando el error
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("success", false);
            jsonResponse.put("message", "Usuario o contraseña incorrecta");
            
            // Enviar la respuesta JSON al cliente
            response.getWriter().write(jsonResponse.toString());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
