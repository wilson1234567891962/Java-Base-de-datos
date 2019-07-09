package com.billing.principal;

import com.billing.cache.Propertie;
import com.billing.conexion.Conexion;
import com.billing.model.BillingDTO;
import com.billing.procedure.Registry;
import com.billing.utilities.Files;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;

public class Billing {

    static Logger logger = Logger.getLogger(Billing.class);

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection connection = null;
        Registry registry = new Registry();
        try {
            new Propertie().getProperties();
            connection = conexion.conectar();
            List<BillingDTO> billingDTO = new Files().getObjetBilling();
            registry.insertInformation(connection, billingDTO);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            logger.error("Se presentaron problemas con el metodo principal ", e);
        } finally {
            try {
                if (registry.getCallableStatement() != null) {
                    registry.getCallableStatement().close();
                }
                conexion.desconectar(connection);
            } catch (Exception e) {
                logger.error("Se presentaron problemas para cerrar los recursos de conexion ", e);
            }
        }
    }
}
