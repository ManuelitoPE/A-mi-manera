package com.restaurante.amm.amimaneradbmanager;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
    private static DBManager dbManager;

//    private String host = "http://prog3ta.cc11tjolntcn.us-east-1.rds.amazonaws.com";
//    private int puerto = 3306;
//    private String esquema = "Progra3AM";
//    private String usuario = "admin";
//    private String password = "progra320251italo";
    private String host;
    private int puerto ;
    private String esquema ;
    private String usuario ;
    private String password ;
    private DBManager() throws IOException {
        cargarProperties();
    }
    
    public synchronized static DBManager getInstance() throws IOException {
        if (dbManager == null) {
            createInstance();
        }
        return dbManager;
    }
    
    private static void createInstance() throws IOException {
        dbManager = new DBManager();
    }
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String cadenaConexion = cadenaConexion(host, puerto, esquema);
            return DriverManager.getConnection(cadenaConexion, usuario, password);
        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            throw e;
        }
    }
    
    private void cargarProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.err.println("No se pudo abrir el archivo db.properties");
                return;
            }
            
            properties.load(input);
            
            host = properties.getProperty("db.host");
            puerto = Integer.parseInt(properties.getProperty("db.puerto"));
            esquema = properties.getProperty("db.esquema");
            usuario = properties.getProperty("db.usuario");
            password = properties.getProperty("db.password");
//            host = "http://prog3ta.cc11tjolntcn.us-east-1.rds.amazonaws.com";
//            puerto = 3306;
//            esquema = "Progra3AM";
//            usuario = "admin";
//            password = properties.getProperty("db.password");
//            password = "progra320251italo";
        }
        catch (IOException e) {
            System.err.println("No se pudo cargar el archivo db.properties");
            throw e;
        }
    }
    
    private String cadenaConexion(String host, int puerto, String esquema) {
        return String.format("jdbc:mysql://%s:%d/%s?useSSL=false&allowPublicKeyRetrieval=true", host, puerto, esquema);
    }
}
