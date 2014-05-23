/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donaciones.dao;

import com.entities.Bolsa;
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
public class BolsaDAO extends BaseDAO{

    /**
     *
     * @param connectionManager
     */
    public BolsaDAO(Conexion connectionManager) {
        super(connectionManager);
    }
    
    /**
     * METODO PARA CREAR BOLSA
     * @param bolsa
     * @throws Exception
     */
    public void crearBolsa(Bolsa bolsa)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("INSERT INTO BOLSA(codigo_bol=?, grupo_sanguineo_bol=?, rh_bol=?, fecha_donacion_bol=?, "
                    + "fecha_venci_bol=?, cantidad_sangre_bol=?, observaciones_bol=?,jornada_don_bol=?,estado_bol=?) VALUES(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, bolsa.getCodigo());
            ps.setString(2, bolsa.getGrupo_sanguineo());
            ps.setString(3, bolsa.getRh());
            ps.setDate(4, bolsa.getFecha_donacion());
            ps.setDate(5, bolsa.getFecha_vencimiento());
            ps.setInt(6, bolsa.getCantidad_sangre());
            ps.setString(7, bolsa.getObservaciones());
            ps.setString(8, bolsa.getCodigo_jornada());
            ps.setString(9, bolsa.getEstado());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(BolsaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al crear bolsa",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BolsaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }        
    }
    
    /**
     * METODO PARA BUSCAR LA BOLSA
     * @param codigo
     * @return
     * @throws Exception
     */
    public Bolsa buscarBolsa(String codigo)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("SELECT * FROM BOLSA WHERE codigo_bol=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Bolsa(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception e) {
            Logger.getLogger(BolsaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al buscar bolsa",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BolsaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
        return null;
    }
    
    /**
     * METODO PARA MODIFICAR BOLSA
     * @param bolsa
     * @throws Exception
     */
    public void modificarBolsa(Bolsa bolsa)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("UPDATE BOLSA SET grupo_sanguineo_bol=?, rh_bol=?, fecha_donacion_bol=?, "
                    + "fecha_venci_bol=?, cantidad_sangre_bol=?, observaciones_bol=?,jornada_don_bol=?, estado_bol=? WHERE codigo_bol=?");
            ps.setString(1, bolsa.getGrupo_sanguineo());
            ps.setString(2, bolsa.getRh());
            ps.setDate(3, bolsa.getFecha_donacion());
            ps.setDate(4, bolsa.getFecha_vencimiento());
            ps.setInt(5, bolsa.getCantidad_sangre());
            ps.setString(6, bolsa.getObservaciones());
            ps.setString(7, bolsa.getCodigo_jornada());
            ps.setString(8, bolsa.getEstado());
            ps.setString(9, bolsa.getCodigo());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(BolsaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al modificar bolsa",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BolsaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }

}
