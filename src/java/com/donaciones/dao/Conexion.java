/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donaciones.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author Daniel
 */
public class Conexion {
    
    String user;
    String password;
    String url;

    public Conexion(String user, String password, String url) {
        this.user = user;
        this.password = password;
        this.url = url;
    }
    
    public Connection conectar()throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new Exception("No se pudo establecer la conexión",e);
        }
    }
    
    public void cerrar(Connection connection)throws Exception{
        try {
            if ( connection!=null && !connection.isClosed() ){
                connection.close();
            }
        } catch (Exception e) {
            System.out.println("No es posible cerrar la conexión");
        }
    }
    
}
