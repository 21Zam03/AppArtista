/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.controller;

import com.zam.conexion.Conexion;
import com.zam.bean.Artista;
import com.zam.bean.Track;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
    
    public boolean registrarArtista(Artista artista) {
        boolean registro = false;
        PreparedStatement ps = null;
        String codSQL = "insert into artista (nombre, info) values (?,?)";
        try {
            ps = Conexion.getConexion().prepareStatement(codSQL);
            ps.setString(1, artista.getNombre());
            ps.setString(2, artista.getInfo());
            int valor = ps.executeUpdate();
            if (valor != 0) {
                registro = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
        return registro;
    }
    
    public boolean registrarTrack(Track track) {
        boolean registro = false;
        PreparedStatement ps = null;
        String codSQL = "insert into track (nombre, genero, fecha_lanzamiento, bpm, duracion, escala, discografia, imagen) values (?,?,?,?,?,?,?,?)";
        try {
            ps = Conexion.getConexion().prepareStatement(codSQL);
            java.sql.Date fecha = new java.sql.Date(track.getFecha_lanzamiento().getTime());
            ps.setString(1, track.getNombre());
            ps.setString(2, track.getGenero());
            ps.setDate(3, fecha);
            ps.setString(4, track.getBpm());
            ps.setString(5, track.getDuracion());
            ps.setString(6, track.getEscala());
            ps.setString(7, track.getDiscografia());
            ps.setString(8, track.getImagen());
            int valor = ps.executeUpdate();
            if (valor != 0) {
                registro = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
        return registro;
    }
    
    public boolean registrarArt_Track(Artista artista, Track track) {
        boolean registro = false;
        PreparedStatement ps = null;
        String codSQL = "insert into artista_track (idArtista, idTrack) values (?,?)";
        try {
            ps = Conexion.getConexion().prepareStatement(codSQL);
            ps.setInt(1, artista.getIdArtista());
            ps.setInt(2, track.getIdTrack());
            int valor = ps.executeUpdate();
            if (valor != 0) {
                registro = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
        return registro;
    }
    
    public List<Artista> listarArtista() {
        List<Artista> lista = new ArrayList<>();
        Artista artista;
        ResultSet rs = null;
        PreparedStatement ps;
        String codSQL = "select * from artista";
        try {
            ps = Conexion.getConexion().prepareStatement(codSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                artista = new Artista(rs.getInt(1), rs.getString(2), rs.getString(3));
                lista.add(artista);
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if ( rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
        return lista;
    }
    
    public List<Track> listarTrack_actual() {
        List<Track> lista = new ArrayList<>();
        Track track;
        ResultSet rs = null;
        PreparedStatement ps;
        String codSQL = "SELECT * FROM track ORDER BY fecha_lanzamiento DESC;";
        try {
            ps = Conexion.getConexion().prepareStatement(codSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                track = new Track(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),
                rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
                rs.getString(9));
                lista.add(track);
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if ( rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
        return lista;
    }
    
    public Track obtenerTrack(String nombre) {
        Track track = null;
        ResultSet rs = null;
        PreparedStatement ps;
        String codSQL = "select * from track where nombre = ?";
        try {
            ps = Conexion.getConexion().prepareStatement(codSQL);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                track = new Track(rs.getInt(1), rs.getString(2), rs.getString(3),
                rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7),
                rs.getString(8), rs.getString(9));
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if ( rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
        return track;
    }
    
    public Artista obtenerArtista(String nombre) {
        Artista artista = null;
        ResultSet rs = null;
        PreparedStatement ps;
        String codSQL = "select * from artista where nombre = ?";
        try {
            ps = Conexion.getConexion().prepareStatement(codSQL);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                artista = new Artista(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if ( rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
        return artista;
    }
    
    
    
}   
