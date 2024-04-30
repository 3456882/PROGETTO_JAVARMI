/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

/**
 *
 * @author Utente
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static Connection connection;

    public static Connection getConnection() throws SQLException{
        if (connection == null || connection.isClosed()) {

            try {
                           // Caricamento del driver JDBC per MySQL
                           Class.forName("com.mysql.cj.jdbc.Driver");
                       } catch (ClassNotFoundException e) {
                           throw new SQLException("MySQL JDBC Driver not found", e);
                       }
            // Connessione al database MySQL
            String url = "jdbc:mysql://localhost:3308/biblioteca";
            String username = "root";
            String password = "";
           
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}

 

