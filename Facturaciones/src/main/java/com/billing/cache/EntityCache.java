package com.billing.cache;

public class EntityCache {

    private static EntityCache entityCache;
    private String address;
    private String port;
    private String nameDataBase;
    private String userDataBase;
    private String passwordDataBase;
    private String driverBaseDatos;
    private String urlConnection;
    private String pathFile;
    private String separatorFile;
    private String formatDate;

    private EntityCache() {
    }

    public synchronized static EntityCache getEntidadCache() {
        if (entityCache == null) {
            entityCache = new EntityCache();
        }
        return entityCache;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getNameDataBase() {
        return nameDataBase;
    }

    public void setNameDataBase(String nameDataBase) {
        this.nameDataBase = nameDataBase;
    }

    public String getUserDataBase() {
        return userDataBase;
    }

    public void setUserDataBase(String userDataBase) {
        this.userDataBase = userDataBase;
    }

    public String getPasswordDataBase() {
        return passwordDataBase;
    }

    public void setPasswordDataBase(String passwordDataBase) {
        this.passwordDataBase = passwordDataBase;
    }

    public String getDriverBaseDatos() {
        return driverBaseDatos;
    }

    public void setDriverBaseDatos(String driverBaseDatos) {
        this.driverBaseDatos = driverBaseDatos;
    }

    public String getUrlConnection() {
        return urlConnection;
    }

    public void setUrlConnection(String urlConnection) {
        this.urlConnection = urlConnection;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getSeparator() {
        return separatorFile;
    }

    public void setSeparator(String separatorFile) {
        this.separatorFile = separatorFile;
    }

    public String getSeparatorFile() {
        return separatorFile;
    }

    public void setSeparatorFile(String separatorFile) {
        this.separatorFile = separatorFile;
    }

    public String getFormatDate() {
        return formatDate;
    }

    public void setFormatDate(String formatDate) {
        this.formatDate = formatDate;
    }

    
}
