/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.service.impl;

import com.zam.service.ConexionService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionServiceImpl implements ConexionService {
    
    private static final String usuario = "root";
    private static final String password = "josesamuel";
    private static final String bd = "alesso_bd";
    private static final String port = "3306";
    private static final String url = "jdbc:mysql://localhost:" + port + "/" + bd + "?serverTimezone=UTC";

    private static ConexionService conexionService;
    private static Connection cn;

    @Override
    public ConexionService getInstance() {
        if (conexionService == null) {
            conexionService = new ConexionServiceImpl();
            System.out.println("INGRESO A LA CRACION DE LA INSTANCIA");
        } else {
            System.out.println("LA INSTANCIA YA EXISTE");
        }
        return conexionService;
    }

    @Override
    public Connection getConexion() {
        if (cn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                cn = DriverManager.getConnection(url, usuario, password);
            } catch (Exception ex) {
                ex.printStackTrace();
                cn = null;
            }
            System.out.println("CREANDO CONEXION");
        } else {
            System.out.println("LA CONEXION YA EXISTE");
        }
        return cn;
    }

    @Override
    public void cerrarconexion(Connection cn) {
        try {
            cn.close();
            this.cn = null;
            System.out.println("CERRANDO CONEXION");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void cerrarResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("CERRANDO RESULSET");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void cerrarPreparedStatement(PreparedStatement ps) {
        try {
            ps.close();
            System.out.println("CERRANDO PREPARED STATEMENT");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
