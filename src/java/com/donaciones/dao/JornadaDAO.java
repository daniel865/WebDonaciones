/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donaciones.dao;

import com.entities.Jornada;
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
public class JornadaDAO extends BaseDAO{

    /**
     *
     * @param connectionManager
     */
    public JornadaDAO(Conexion connectionManager) {
        super(connectionManager);
    }
    
    /**
     * METODO PARA CREAR LA JORNADA
     * @param jornada
     * @throws Exception
     */
    public void crearJornada(Jornada jornada)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("INSERT INTO JORNADA(codigo_jor=?, descripcion_jor=?, fecha_jor=?, departamento_jor=?,"
                    + "municipio_jor=?, direccion_jor=?, cantidad_donantes_jor=?, cantidad_sangre_jor=?, estado_jor=?, observaciones_jor=?"
                    + ") VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, jornada.getCodigo());
            ps.setString(2, jornada.getDescripcion());
            ps.setDate(3, jornada.getFecha());
            ps.setString(4, jornada.getDepartamento());
            ps.setString(5, jornada.getMunicipio());
            ps.setString(6, jornada.getDireccion());
            ps.setInt(7, jornada.getCant_donantes());
            ps.setInt(8, jornada.getCant_sangre());
            ps.setString(9, jornada.getEstado());
            ps.setString(10, jornada.getObservaciones());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(JornadaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al crear jornada",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JornadaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    
    /**
     * METODO PARA BUSCAR JORNADA
     * @param codigo
     * @return
     * @throws Exception
     */
    public Jornada buscarJornada(String codigo)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            connection = connectionManager.conectar();
            ps =connection.prepareStatement("SELECT * FROM JORNADA WHERE codigo_jor=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Jornada(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10));
            }
        } catch (Exception e) {
            Logger.getLogger(JornadaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al buscar jornada",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JornadaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
        return null;
    }
    
    /**
     * METODO MODIFICAR JORNADA
     * @param jornada
     * @throws Exception
     */
    public void modificarJornada(Jornada jornada)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("UPDATE JORNADA SET descripcion_jor=?, fecha_jor=?, departamento_jor=?,municipio_jor=?, "
                    + "direccion_jor=?, cantidad_donantes_jor=?, cantidad_sangre_jor=?, estado_jor=?, observaciones_jor=? WHERE codigo_jor=?");
            ps.setString(1, jornada.getDescripcion());
            ps.setDate(2, jornada.getFecha());
            ps.setString(3, jornada.getDepartamento());
            ps.setString(4, jornada.getMunicipio());
            ps.setString(5, jornada.getDireccion());
            ps.setInt(6, jornada.getCant_donantes());
            ps.setInt(7, jornada.getCant_sangre());
            ps.setString(8, jornada.getEstado());
            ps.setString(9, jornada.getObservaciones());
            ps.setString(10, jornada.getCodigo());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(JornadaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al modificar jornada",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JornadaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }

    
    
    
}
