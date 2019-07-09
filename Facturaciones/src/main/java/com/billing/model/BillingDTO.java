package com.billing.model;

import java.util.Date;


public class BillingDTO {

    private Integer idTransaction;
    private Integer idClient;
    private Date dateTransaction;
    private String valueTransaction;
    private Integer rode;

    public Integer getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getRode() {
        return rode;
    }

    public void setRode(Integer rode) {
        this.rode = rode;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getValueTransaction() {
        return valueTransaction;
    }

    public void setValueTransaction(String valueTransaction) {
        this.valueTransaction = valueTransaction;
    }

}
