/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteVotaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author carlos coronado
 */
public class singleconexion {
    private Connection conexion;
    private static singleconexion con=null;
   
    private singleconexion()throws ClassNotFoundException,SQLException{//es privado para asegurar que 
            Class.forName("com.mysql.jdbc.Driver");                    //no se puede crear el objeto nada mas que dentro de la propia clase
        
            /* Cadena de conexión para conectar con MySQL en localhost, 
            seleccionar la base de datos llamada “ejercicio”*/
            String connectionUrl = "jdbc:mysql://mysql-votaciones.jelastic.lunacloud.com/votaciones";
            // Obtener la conexión con usuario y contraseña del servidor de MySQL: root y root
            conexion=DriverManager.getConnection(connectionUrl,"root","sTwl0sFpru");
    }
    public synchronized static singleconexion crearcon()throws ClassNotFoundException,SQLException{
        if(con==null)
        {
            con=new singleconexion();
        }
        
        return con;
    }
    
    public Connection getcon(){
        
        return conexion;
    }
    public void destroy()throws SQLException{
        conexion.close();
    }
}
