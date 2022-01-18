package com.example.configservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tenant_configuration")
public class Configuration {

    @Id
    private int id;
    private int tenantid;
    private String account;
    private String property;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTenantid() {
        return tenantid;
    }

    public void setTenantid(int tenantid) {
        this.tenantid = tenantid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Configuration( int id, int tenantid, String account, String property) {
        this.id = id;
        this.tenantid = tenantid;
        this.account = account;
        this.property = property;
    }
}
