package com.restaurante.amm.amimaneradbmanager;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
    private static DBManager dbManager;
    private String host;
    private int puerto;
    private String esquema;
    private String usuario;
    private String password;
    
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
    
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String cadenaConexion = String.format("jdbc:mysql://%s:%d/%s?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", 
                host, puerto, esquema);
            System.out.println("Intentando conectar a: " + cadenaConexion);
            return DriverManager.getConnection(cadenaConexion, usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            throw new SQLException("Error al conectar a la base de datos", e);
        }
    }
    
    private void cargarProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new IOException("No se pudo encontrar el archivo db.properties");
            }
            
            properties.load(input);
            
            host = properties.getProperty("db.host");
            puerto = Integer.parseInt(properties.getProperty("db.puerto"));
            esquema = properties.getProperty("db.esquema");
            usuario = properties.getProperty("db.usuario");
            password = properties.getProperty("db.password");
            
            if (host == null || esquema == null || usuario == null || password == null) {
                throw new IOException("Faltan propiedades requeridas en db.properties");
            }
        }
    }
}
