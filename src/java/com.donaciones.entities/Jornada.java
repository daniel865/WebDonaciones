/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.entities;

import java.sql.Date;

/**
 *
 * @author daniel
 */
public class Jornada {
    
    private String codigo;
    private String descripcion;
    private Date fecha;
    private String departamento;
    private String municipio;
    private String direccion;
    private int cant_donantes;
    private int cant_sangre;
    private String estado;
    private String observaciones;

    public Jornada(String codigo, String descripcion, Date fecha, String departamento, String municipio, String direccion, int cant_donantes, int cant_sangre, String estado, String observaciones) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.departamento = departamento;
        this.municipio = municipio;
        this.direccion = direccion;
        this.cant_donantes = cant_donantes;
        this.cant_sangre = cant_sangre;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCant_donantes() {
        return cant_donantes;
    }

    public void setCant_donantes(int cant_donantes) {
        this.cant_donantes = cant_donantes;
    }

    public int getCant_sangre() {
        return cant_sangre;
    }

    public void setCant_sangre(int cant_sangre) {
        this.cant_sangre = cant_sangre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    
}
