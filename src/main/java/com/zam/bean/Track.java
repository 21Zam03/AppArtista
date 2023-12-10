/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.bean;

import java.util.Date;
import lombok.Data;

@Data
public class Track {
    
    private int idTrack;
    private String nombre;
    private String genero;
    private Date fecha_lanzamiento;
    private String bpm;
    private String duracion;
    private String escala;
    private String discografia;
    private String imagen;

    public Track(int idTrack, String nombre, String genero, Date fecha_lanzamiento, String bpm, String duracion, String escala, String discografia,
            String imagen) {
        this.idTrack = idTrack;
        this.nombre = nombre;
        this.genero = genero;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.bpm = bpm;
        this.duracion = duracion;
        this.escala = escala;
        this.discografia = discografia;
        this.imagen = imagen;
    }

    public Track(String nombre, String genero, Date fecha_lanzamiento, String bpm, String duracion, String escala, String discografia, String imagen) {
        this.nombre = nombre;
        this.genero = genero;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.bpm = bpm;
        this.duracion = duracion;
        this.escala = escala;
        this.discografia = discografia;
        this.imagen = imagen;
    }

}
