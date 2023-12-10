/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.bean;

import lombok.Data;

@Data
public class Artista {
    
    private int idArtista;
    private String nombre;
    private String info;

    public Artista(int idArtista, String nombre, String info) {
        this.idArtista = idArtista;
        this.nombre = nombre;
        this.info = info;
    }

    public Artista(String nombre, String info) {
        this.nombre = nombre;
        this.info = info;
    }
    
}
