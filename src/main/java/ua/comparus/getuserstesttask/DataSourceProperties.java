package ua.comparus.getuserstesttask;

import java.util.Map;

public class DataSourceProperties {

    private String name;

    private String strategy;

    private String url;

    private String table;

    private String user;

    private String password;

    private Map<String, String> mapping;

    public String getName() {
        return name;
    }

    public String getStrategy() {
        return strategy;
    }

    public String getUrl() {
        return url;
    }

    public String getTable() {
        return table;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }

}