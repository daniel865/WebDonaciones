/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donaciones.entities;

import java.sql.Date;

/**
 *
 * @author daniel
 */
public class Donante {
    
    private String tipo_documento;
    private String nro_identificacion;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private long telefono;
    private String direccion;
    private String correo;
    private Date fec_naciminiento;
    private Date fec_donacion;
    private String enfermedades;
    private String habitos;
    private String nombre_rep;
    private long telefono_rep;
    private String genero;
    private String departamento;
    private String municipio;
    private String estado;

    public Donante(String tipo_documento, String nro_identificacion, String nombres, String apellido1, String apellido2, long telefono, String direccion, String correo, Date fec_naciminiento, Date fec_donacion, String enfermedades, String habitos, String nombre_rep, long telefono_rep, String genero, String departamento, String municipio, String estado) {
        this.tipo_documento = tipo_documento;
        this.nro_identificacion = nro_identificacion;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.fec_naciminiento = fec_naciminiento;
        this.fec_donacion = fec_donacion;
        this.enfermedades = enfermedades;
        this.habitos = habitos;
        this.nombre_rep = nombre_rep;
        this.telefono_rep = telefono_rep;
        this.genero = genero;
        this.departamento = departamento;
        this.municipio = municipio;
        this.estado = estado;
    }

    public Donante(String tipo_documento, String nro_identificacion, String nombres, String apellido1, long telefono, String direccion, String correo, Date fec_naciminiento, Date fec_donacion, String enfermedades, String habitos, String nombre_rep, long telefono_rep, String genero, String departamento, String municipio, String estado) {
        this.tipo_documento = tipo_documento;
        this.nro_identificacion = nro_identificacion;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.fec_naciminiento = fec_naciminiento;
        this.fec_donacion = fec_donacion;
        this.enfermedades = enfermedades;
        this.habitos = habitos;
        this.nombre_rep = nombre_rep;
        this.telefono_rep = telefono_rep;
        this.genero = genero;
        this.departamento = departamento;
        this.municipio = municipio;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNro_identificacion() {
        return nro_identificacion;
    }

    public void setNro_identificacion(String nro_identificacion) {
        this.nro_identificacion = nro_identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFec_naciminiento() {
        return fec_naciminiento;
    }

    public void setFec_naciminiento(Date fec_naciminiento) {
        this.fec_naciminiento = fec_naciminiento;
    }

    public Date getFec_donacion() {
        return fec_donacion;
    }

    public void setFec_donacion(Date fec_donacion) {
        this.fec_donacion = fec_donacion;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getHabitos() {
        return habitos;
    }

    public void setHabitos(String habitos) {
        this.habitos = habitos;
    }

    public String getNombre_rep() {
        return nombre_rep;
    }

    public void setNombre_rep(String nombre_rep) {
        this.nombre_rep = nombre_rep;
    }

    public long getTelefono_rep() {
        return telefono_rep;
    }

    public void setTelefono_rep(long telefono_rep) {
        this.telefono_rep = telefono_rep;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
    
    
    
}
