/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.service.impl;

import com.zam.bean.Usuario;
import com.zam.service.ConexionService;
import com.zam.service.UsuarioService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioServiceImpl implements UsuarioService {

    @Override
    public void crearUsuario(Usuario usuario) {
        ConexionService conexionDao = new ConexionServiceImpl();
        Connection cn  = null;
        PreparedStatement ps = null;
        try {
            String sql ="insert into usuario (nombre_usuario, contrasena, tipo) values (?,?,?)";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre_usuario());
            ps.setString(2, usuario.getContrasena());
            ps.setString(3, usuario.getTipo());
            int registro = ps.executeUpdate();
            if (registro > 0) {
                System.out.println("Se registro Correctamente");
            } else {
                System.out.println("No se pudo registrar");
            }      
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
            ex.printStackTrace();
        } finally {    
            if (ps != null) {
                try {
                    conexionDao.cerrarPreparedStatement(ps);
                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            }           
            if (cn != null) {
                try {
                    conexionDao.cerrarconexion(cn);
                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            }
        }
    }

    @Override
    public Usuario ObtenerUsuario(int id) {
        Usuario usuario = new Usuario();
        ConexionService conexionDao = new ConexionServiceImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql ="select * from usuario where id_usuario = ?";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre_usuario(rs.getString(2));
                usuario.setContrasena(rs.getString(3));
                usuario.setTipo(rs.getString(4));;
            } else {
                System.out.println("No se pudo obtener al cliente");
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    conexionDao.cerrarResultSet(rs);
                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            }     
            if (ps != null) {
                try {
                    conexionDao.cerrarPreparedStatement(ps);
                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            }
        }
        return usuario;
    }

    @Override
    public void actualizarUsuario(int id, Usuario usuario) {
        try {
            ConexionService conexionDao = new ConexionServiceImpl();
            Connection cn = conexionDao.getConexion();
            String sql ="UPDATE usuario SET nombre_usuario = ?, contrasena = ?, tipo = ? WHERE id_usuario = ?;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre_usuario());
            ps.setString(2, usuario.getContrasena());
            ps.setString(3, usuario.getTipo());
            ps.setInt(4, id);
            int actualizacion = ps.executeUpdate();
            if (actualizacion > 0) {
                System.out.println("Se actualizaron los datos correctamente");
            } else {
                System.out.println("No se pudo actualizar los datos");
            }
            conexionDao.cerrarconexion(cn);
            conexionDao.cerrarPreparedStatement(ps);         
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminarUsuario(int id) {
       try {
            ConexionService conexionDao = new ConexionServiceImpl();
            Connection cn = conexionDao.getConexion();
            String sql ="DELETE usuario WHERE Id_usuario = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            int actualizacion = ps.executeUpdate();
            if (actualizacion > 0) {
                System.out.println("Se elimino los datos correctamente");
            } else {
                System.out.println("No se pudo eliminar los datos");
            }
            conexionDao.cerrarconexion(cn);
            conexionDao.cerrarPreparedStatement(ps);         
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public Usuario obtenerUsuario(String nombre_usuario, String contrasena) {
        Usuario usuario = new Usuario();
        ConexionService conexionDao = new ConexionServiceImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql ="select * from usuario where nombre_usuario = ? and contrasena = ?";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre_usuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre_usuario(rs.getString(2));
                usuario.setContrasena(rs.getString(3));
                usuario.setTipo(rs.getString(4));;
            } else {
                System.out.println("No se pudo obtener al cliente");
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    conexionDao.cerrarResultSet(rs);
                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            }     
            if (ps != null) {
                try {
                    conexionDao.cerrarPreparedStatement(ps);
                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            }           
            if (cn != null) {
                try {
                    conexionDao.cerrarconexion(cn);
                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            }
        }
        return usuario;
    }
     
}
