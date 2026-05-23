package org.logistica.config.database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        try (InputStream input =
            ConnectionFactory.class.getClassLoader()
            .getResourceAsStream("application.properties")
        ){
            properties.load(input);
        }
        catch {}
    } 
}
