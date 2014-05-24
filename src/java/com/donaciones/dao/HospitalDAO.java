/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donaciones.dao;

import com.donaciones.entities.Hospital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class HospitalDAO extends BaseDAO{

    /**
     *
     * @param connectionManager
     */
    public HospitalDAO(Conexion connectionManager) {
        super(connectionManager);
    }
    
    /**
     * METODO PARA CREAR HOSPITAL
     * @param hospital
     * @throws Exception
     */
    public void crearHospital(Hospital hospital)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("INSERT INTO HOSPITAL(nit_hos=?,tipo_hos=?,razon_social_hos=?,nivel_hos=?,departamento_hos=?,"
                    + "municipio_hos=?,direccion_hos=?,telefono_hos=?,nombre_rep_hos=?,tel_rep_hos=?,correo_rep_hos=?,estado_hos=?) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, hospital.getNit());
            ps.setString(2, hospital.getTipo());
            ps.setString(3, hospital.getRazon_social());
            ps.setString(4, hospital.getNivel());
            ps.setString(5, hospital.getDepartamento());
            ps.setString(6, hospital.getMunicipio());
            ps.setString(7, hospital.getDireccion());
            ps.setLong(8, hospital.getTelefono());
            ps.setString(9, hospital.getNombre_representante());
            ps.setLong(10, hospital.getTelefono_representante());
            ps.setString(11, hospital.getCorreo_representante());
            ps.setString(12, hospital.getEstado_representante());
        } catch (Exception e) {
            Logger.getLogger(HospitalDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al crear hospital",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HospitalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    
    /**
     * METODO PARA BUSCAR HOSPITAL
     * @param identificacion
     * @return
     * @throws Exception
     */
    public Hospital buscarHospital(String codigo)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("SELECT * FROM HOSPITAL WHERE nit_hos=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Hospital(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getLong(8), rs.getString(9), rs.getLong(10), rs.getString(11), rs.getString(12));  
            }
        } catch (Exception e) {
            Logger.getLogger(HospitalDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al buscar hospital",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HospitalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
        return null;
    }
    
    /**
     * METODO PARA MODIFICAR HOSPITAL
     * @param hospital
     * @throws Exception
     */
    public void modificarHospital(Hospital hospital)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("UPDATE HOSPITAL SET tipo_hos=?,razon_social_hos=?,nivel_hos=?,departamento_hos=?,municipio_hos=?,direccion_hos=?,"
                    + "telefono_hos=?,nombre_rep_hos=?,tel_rep_hos=?,correo_rep_hos=?,estado_hos=? WHERE nit_hos=?");
            ps.setString(1, hospital.getTipo());
            ps.setString(2, hospital.getRazon_social());
            ps.setString(3, hospital.getNivel());
            ps.setString(4, hospital.getDepartamento());
            ps.setString(5, hospital.getMunicipio());
            ps.setString(6, hospital.getDireccion());
            ps.setLong(7, hospital.getTelefono());
            ps.setString(8, hospital.getNombre_representante());
            ps.setLong(9, hospital.getTelefono_representante());
            ps.setString(10, hospital.getCorreo_representante());
            ps.setString(11, hospital.getEstado_representante());
            ps.setString(12, hospital.getNit());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(HospitalDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al buscar hospital",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HospitalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    

    
    
}
