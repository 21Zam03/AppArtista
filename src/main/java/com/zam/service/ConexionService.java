/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface ConexionService {
    
    public ConexionService getInstance();
    public Connection getConexion();
    public void cerrarconexion(Connection cn);
    public void cerrarResultSet(ResultSet rs);
    public void cerrarPreparedStatement(PreparedStatement ps);
    
}
