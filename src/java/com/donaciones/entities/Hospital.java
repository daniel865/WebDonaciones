package com.donaciones.entities;

/**
 * Clase encargada de crear la entidad Hospital
 * @author Daniel Rúa Madrid
 * @version 1.0
 * @since 20/05/2014
 * 
 */
public class Hospital {
    
    private String nit;
    private String tipo;
    private String razon_social;
    private String nivel;
    private String departamento;
    private String municipio;
    private String direccion;
    private long telefono;
    private String nombre_representante;
    private long telefono_representante;
    private String correo_representante;
    private String estado_representante;

    public Hospital(String nit, String tipo, String razon_social, String nivel, String departamento, String municipio, String direccion, long telefono, String nombre_representante, long telefono_representante, String correo_representante, String estado_representante) {
        this.nit = nit;
        this.tipo = tipo;
        this.razon_social = razon_social;
        this.nivel = nivel;
        this.departamento = departamento;
        this.municipio = municipio;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre_representante = nombre_representante;
        this.telefono_representante = telefono_representante;
        this.correo_representante = correo_representante;
        this.estado_representante = estado_representante;
    }

    public String getEstado_representante() {
        return estado_representante;
    }

    public void setEstado_representante(String estado_representante) {
        this.estado_representante = estado_representante;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
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

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getNombre_representante() {
        return nombre_representante;
    }

    public void setNombre_representante(String nombre_representante) {
        this.nombre_representante = nombre_representante;
    }

    public long getTelefono_representante() {
        return telefono_representante;
    }

    public void setTelefono_representante(long telefono_representante) {
        this.telefono_representante = telefono_representante;
    }

    public String getCorreo_representante() {
        return correo_representante;
    }

    public void setCorreo_representante(String correo_representante) {
        this.correo_representante = correo_representante;
    }

    
    
}
