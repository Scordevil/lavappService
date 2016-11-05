/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ContabilidadPC
 */
public class ConexionSQL {

    static String clave = "yU7eywfXILoZjtaD";
    // static String clave = "root";
    static Statement st = null;
    static Connection cn = null;

    public ConexionSQL() {
        conexion();
    }    
    
    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        ConexionSQL.cn = cn;
    }  
    
    public static Statement conexion() {
        try {
            try {
                // CLASE USADA PARA EL DRIVER
                Class.forName("org.postgresql.Driver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // RUTA DE LA BASE DE DATOS
            //  149.56.93.6
//              String url = "jdbc:mysql://149.56.93.6:3306/smsrenta_actualizada";
//              String url = "jdbc:postgresql://localhost:5432/lavapp";
            
            String url = "jdbc:postgresql://192.168.100.251:5432/lavapp";
            // CONECCION A LA BASE DE DATOS
            cn = DriverManager.getConnection(url, "postgres", clave);
            // TRAE LOS DATOS
            //Statement st = cn.createStatement();
            st = cn.createStatement();
            System.out.print("-------------------consulta BD:" + st);
            
        } catch (ClassNotFoundException ex) {
            System.out.print("Error en el Driver");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return st;
    }
    
   
    public static Connection CerrarConexion() throws SQLException {
        cn.close();
        st.close();
        return cn;
    }
}
