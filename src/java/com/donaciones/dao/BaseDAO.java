/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donaciones.dao;

/**
 *
 * @author Daniel
 */
public class BaseDAO {
    
    protected Conexion connectionManager;

    public BaseDAO(Conexion connectionManager) {
        this.connectionManager = connectionManager;
    }
    
}
