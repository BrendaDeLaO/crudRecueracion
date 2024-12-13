/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Juan Condori
 */
public class Conexion {

    public static Connection connection = null;

    public static Connection Conexion() throws Exception {
        if (connection != null) {
            return connection;
        }
        try {
            String url = "jdbc:mysql://database1.cktrna1xsqwj.us-east-1.rds.amazonaws.com/CODESOLUTIONS";
            String user = "admin";
            String password = "recuperacion";
            String driver="com.mysql.cj.jdbc.Driver";
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error en la Conexion " + e.getMessage());
        }
        return connection;
    }

    public static void CerrarConexion() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
    
    public static void main(String[] args) throws Exception {
        Conexion();
        if (connection != null) {
            System.out.println("CONEXIÓN CON EXITO");
        } else {
            System.out.println("SIN CONEXIÓN, REVISA...!!!");
        }
    }

}
