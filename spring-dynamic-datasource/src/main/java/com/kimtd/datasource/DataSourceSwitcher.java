package com.kimtd.datasource;

public class DataSourceSwitcher {

    private static ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSource(String dataSource){
        contextHolder.set(dataSource);
    }

    public static String getDataSource(){
        return contextHolder.get();
    }

    public static void setMaster(){
        setDataSource("master");
    }

    public static void setSlave(){
        setDataSource("slave");
    }

    public static void cleanDataSource(){
        contextHolder.remove();
    }



}
