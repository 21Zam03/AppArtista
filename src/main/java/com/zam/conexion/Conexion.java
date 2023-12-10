/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public static Connection getConexion() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/alesso_bd", "root", "josesamuel");
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println("Error: "+e);
        } finally {
            if (cn == null) {
                System.out.println("La conexion es nula");
            }
        }
        return cn;
    }
    
    public static void main(String[] args) {
        Conexion.getConexion();
    }
    
}
