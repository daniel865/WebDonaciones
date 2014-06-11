/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donaciones.entities;

/**
 *
 * @author daniel
 */
public class Municipio {
    
    private String id;
    private String id_dep;
    private String nombre;

    public Municipio(String id, String id_dep, String nombre) {
        this.id = id;
        this.id_dep = id_dep;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_dep() {
        return id_dep;
    }

    public void setId_dep(String id_dep) {
        this.id_dep = id_dep;
    }

    @Override
    public String toString() {
        return "Municipio{" + "id=" + id + ", id_dep=" + id_dep + ", nombre=" + nombre + '}';
    }
    
    
    
}
