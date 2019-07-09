package com.billing.procedure;

import com.billing.model.BillingDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import oracle.jdbc.OracleTypes;
import org.apache.log4j.Logger;

public class Registry {

    static Logger logger = Logger.getLogger(Registry.class);
    private CallableStatement callableStatement;

    public void insertInformation(Connection connection, List<BillingDTO> billingDTO) throws SQLException {
        this.callableStatement = connection.prepareCall("{call PKG_FACTURACION.insertRegister(?,?,?,?,?,?)}");
        for (BillingDTO it : billingDTO) {
            this.callableStatement.setInt(1, it.getIdTransaction());
            this.callableStatement.setInt(2, it.getIdClient());
            this.callableStatement.setTimestamp(3, new Timestamp(it.getDateTransaction().getTime()));
            this.callableStatement.setString(4, it.getValueTransaction());
            this.callableStatement.setInt(5, it.getRode());
            this.callableStatement.registerOutParameter(6, OracleTypes.VARCHAR);
            this.callableStatement.execute();
            if (callableStatement.getString(6).equals("Exitoso")) {
                logger.info("Registro insertado exitosamente ");
            } else {
                logger.warn("Se presento problemas para insertar el registro, datos del registro");
                logger.warn("id Transaction " + it.getIdTransaction());
                logger.warn("id Client " + it.getIdClient());
            }
        }
    }

    public CallableStatement getCallableStatement() {
        return callableStatement;
    }

    public void setCallableStatement(CallableStatement callableStatement) {
        this.callableStatement = callableStatement;
    }

}
