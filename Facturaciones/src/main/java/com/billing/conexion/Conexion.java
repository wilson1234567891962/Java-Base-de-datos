package com.billing.conexion;

import com.billing.cache.EntityCache;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class Conexion {

    static Logger logger = Logger.getLogger(Conexion.class);

    public Connection conectar() throws ClassNotFoundException, SQLException {
        EntityCache cache = EntityCache.getEntidadCache();
        Class.forName(cache.getDriverBaseDatos());  
        Connection conexion = DriverManager.getConnection(cache.getUrlConnection(),cache.getUserDataBase(),cache.getPasswordDataBase());
        logger.info("Conectado exitosamente");
        return conexion;
    }

    public void desconectar(Connection conexion) {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            logger.error("Error inexperado 0xC02643 CT" + e.getMessage(), e);
        }
    }
}
