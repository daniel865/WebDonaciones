/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donaciones.dao;

import com.donaciones.entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class UsuarioDAO extends BaseDAO{

    /**
     *
     * @param connectionManager
     */
    public UsuarioDAO(Conexion connectionManager) {
        super(connectionManager);
    }
    
    /**
     * METODO PARA CREAR UN USUSARIO
     * @param usuario
     * @throws Exception
     */
    public void crearUsuario(Usuario usuario)throws Exception{
        Connection  connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("INSERT INTO USUARIO(nroidentificacion_usu, nombres_usu, apellido1_usu, apellido2_usu, usuario_usu, "
                    + "correo_usu, contrasenia_usu, perfil_usu, estado_usu) VALUES(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, usuario.getNro_Identificacion());
            ps.setString(2, usuario.getNombres());
            ps.setString(3, usuario.getApellido1());
            ps.setString(4, usuario.getApellido2());
            ps.setString(5, usuario.getUsuario());
            ps.setString(6, usuario.getCorreo());
            ps.setString(7, usuario.getPassword());
            ps.setString(8, usuario.getPerfil());
            ps.setString(9, usuario.getEstado());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al crear usuario",e);
        }finally{
            try {
                if (ps!=null && !ps.isClosed()){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    
    /**
     * METODO PARA BUSCAR USUARIO
     * @param identificacion
     * @return
     * @throws Exception
     */
    public Usuario buscarUsuario(String identificacion)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("SELECT * FROM USUARIO WHERE nroidentificacion_usu=?");
            ps.setString(1, identificacion);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al buscar usuario",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
        return null;
    }
    
    /**
     * METODO PARA MODIFICAR USUARIO
     * @param usuario
     * @throws Exception
     */
    public void modificarUsuario(Usuario usuario)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("UPDATE USUARIO SET nombres_usu=?, apellido1_usu=?, apellido2_usu=?, "
                    + "usuario_usu=?, correo_usu=?, contrasenia_usu=?, perfil_usu=?, estado_usu=? WHERE nroidentificacion_usu=?");
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellido1());
            ps.setString(3, usuario.getApellido2());
            ps.setString(4, usuario.getUsuario());
            ps.setString(5, usuario.getCorreo());
            ps.setString(6, usuario.getPassword());
            ps.setString(7, usuario.getPerfil());
            ps.setString(8, usuario.getEstado());
            ps.setString(9, usuario.getNro_Identificacion());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al modificar usuario",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    
    public void eliminarUsuario(String identificacion)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("DELETE FROM USUARIO WHERE nroidentificacion_usu=?");
            ps.setString(1, identificacion);
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al eliminar usuario",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    
    public Usuario autenticar(String usuario,String password)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("SELECT * FROM USUARIO WHERE usuario_usu=? and contrasenia_usu=?");
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al autenticar usuario",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
        return null;
    }

    
    
}
