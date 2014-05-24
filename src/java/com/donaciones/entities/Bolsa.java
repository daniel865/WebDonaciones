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
public class Bolsa {
    
    private String codigo;
    private String codigo_jornada;
    private String grupo_sanguineo;
    private String rh;
    private Date fecha_donacion;
    private Date fecha_vencimiento;
    private int cantidad_sangre;
    private String observaciones;
    private String estado;

    public Bolsa(String codigo, String codigo_jornada, String grupo_sanguineo, String rh, Date fecha_donacion, Date fecha_vencimiento, int cantidad_sangre, String observaciones, String estado) {
        this.codigo = codigo;
        this.codigo_jornada = codigo_jornada;
        this.grupo_sanguineo = grupo_sanguineo;
        this.rh = rh;
        this.fecha_donacion = fecha_donacion;
        this.fecha_vencimiento = fecha_vencimiento;
        this.cantidad_sangre = cantidad_sangre;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo_jornada() {
        return codigo_jornada;
    }

    public void setCodigo_jornada(String codigo_jornada) {
        this.codigo_jornada = codigo_jornada;
    }

    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }

    public void setGrupo_sanguineo(String grupo_sanguineo) {
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public Date getFecha_donacion() {
        return fecha_donacion;
    }

    public void setFecha_donacion(Date fecha_donacion) {
        this.fecha_donacion = fecha_donacion;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getCantidad_sangre() {
        return cantidad_sangre;
    }

    public void setCantidad_sangre(int cantidad_sangre) {
        this.cantidad_sangre = cantidad_sangre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Bolsa{" + "codigo=" + codigo + ", codigo_jornada=" + codigo_jornada + ", grupo_sanguineo=" + grupo_sanguineo + ", rh=" + rh + ", fecha_donacion=" + fecha_donacion + ", fecha_vencimiento=" + fecha_vencimiento + ", cantidad_sangre=" + cantidad_sangre + ", observaciones=" + observaciones + ", estado=" + estado + '}';
    }

    
    
}
