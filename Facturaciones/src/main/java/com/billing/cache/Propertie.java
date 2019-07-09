/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billing.cache;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class Propertie {

    static Logger logger = Logger.getLogger(EntityCache.class);
    private EntityCache cache;

    public void getProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("properties/Facturacion.properties");
            properties.load(inputStream);
            cache = EntityCache.getEntidadCache();
            cache.setAddress(properties.getProperty("Facturacion.BD.Address").trim());
            cache.setDriverBaseDatos(properties.getProperty("Facturacion.BD.DriverConexion").trim());
            cache.setNameDataBase(properties.getProperty("Facturacion.BD.Name").trim());
            cache.setPasswordDataBase(properties.getProperty("Facturacion.BD.Password").trim());
            cache.setPort(properties.getProperty("Facturacion.BD.Port").trim());
            cache.setUserDataBase(properties.getProperty("Facturacion.BD.User").trim());
            cache.setUrlConnection(this.concatTheConnection());
            cache.setPathFile(properties.getProperty("Facturacion.Path.File").trim());
            cache.setSeparator(properties.getProperty("Facturacion.Path.Separator").trim());
            cache.setFormatDate(properties.getProperty("Facturacion.Format.Date").trim());
            logger.info("Se cargo correctamente el archivo properties");
        } catch (Exception e) {
            logger.error("Se han presentado problemas para configurar el archivos properties ", e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                logger.error("Se presentaron para cerrar el archivo de properties ", e);
            }
        }
    }

    private String concatTheConnection() {
        StringBuilder cadenaConexion = new StringBuilder();
        cadenaConexion.append("jdbc:oracle:thin:@");
        cadenaConexion.append(this.cache.getAddress());
        cadenaConexion.append(":");
        cadenaConexion.append(this.cache.getPort());
        cadenaConexion.append(":xe");
        return cadenaConexion.toString();
    }

}
