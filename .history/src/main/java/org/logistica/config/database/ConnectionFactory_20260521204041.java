package org.logistica.config.database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        Properties properties = new Pro
        try (InputStream input =
            ConnectionFactory.class.getClassLoader()
            .getResourceAsStream("application.properties")
        ){
            
        }
    } 
}
