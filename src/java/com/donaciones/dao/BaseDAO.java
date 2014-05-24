package com.donaciones.dao;

/**
 * Clase encarda de administrar la conexión a la base de datos, por medio
 * de un connectionManager, hereda la conexión a todas las clases que
 * extienden de ella.
 * @author Daniel Rúa Madrid
 * @version 1.0, 23/05/2014
 */
public class BaseDAO {
    
    protected Conexion connectionManager;

    public BaseDAO(Conexion connectionManager) {
        this.connectionManager = connectionManager;
    }
    
}
