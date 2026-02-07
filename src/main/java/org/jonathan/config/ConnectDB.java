package org.jonathan.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    private static String URL = "jdbc:mysql://localhost:3306/controle_financeiro?useSSL=false&serverTimezone=UTC";

    private static String USER = "root";

    private static String PASSWORD = "mysqlPW";
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
