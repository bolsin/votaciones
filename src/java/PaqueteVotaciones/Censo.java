/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteVotaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public class Censo {
    
    private String nif;
    private String password;
    private String votado;
    
    
    
    public Censo(){
        
    }
    public Censo(String dni, String pass, String votad){
        nif=dni;
        password=pass;
        votado=votad;
    }
    
    public boolean buscarVotante(String nif, String password, Connection con){
        
        
        
             /* Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/votaciones?zeroDateTimeBehavior=convertToNull", "root", "hola_20");
              Statement sta = con.createStatement();
              ResultSet rs = sta.executeQuery("SELECT * from censo where nif='"+nif+"' and password='"+password+"' and votado='no'");
              if(rs.next())
                {
                    rs.close();
                    conectado= true;
                }
                else
                {
                    conectado= false;
                }
              
              
            } catch (SQLException ex) {
                Logger.getLogger(valida.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexCenso.class.getName()).log(Level.SEVERE, null, ex);
            }
        return conectado;*/
            try
            {
                    
                    Statement s = con.createStatement();
                    String sql="SELECT * from censo where nif='"+nif+"' and password='"+password+"' and votado='no'";
                    ResultSet rs= s.executeQuery(sql);
                    
                    if(rs.next())
                    {
                        s.close();
                        rs.close();
                    return true;
                    }
                    else
                    {
                    return false;
                    }              

 
            }
            catch(Exception e)
            {
                   System.out.println(e.getMessage());
            }
 
            return false;
    }
    
    public int votarCenso(String dni,Connection con) throws SQLException{
        int filasAfectadas2=0;
        try
            {
                Statement s = con.createStatement();
                String sql2="update censo set votado='si' where nif='"+dni+"'";
                filasAfectadas2= s.executeUpdate(sql2);  
                           
            }
        catch(SQLException SQL)//mejor sqlexception
            {
                   System.out.println(SQL.getMessage());
            }
        if (filasAfectadas2==0)
        {
            throw new SQLException();    
        }
        
        return filasAfectadas2;
    }
    public ArrayList gente(Connection con) throws SQLException{
        ArrayList gente=new ArrayList();
        
        Statement s = con.createStatement();
        String sql="SELECT nif, password, votado from censo";
        ResultSet rs= s.executeQuery(sql);
        
        while(rs.next())
        {
            gente.add(new Censo(rs.getString("nif"), rs.getString("password"),rs.getString("votado") ));
        }
        return gente;
    }

    /**
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * @param nif the nif to set
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the votado
     */
    public String getVotado() {
        return votado;
    }

    /**
     * @param votado the votado to set
     */
    public void setVotado(String votado) {
        this.votado = votado;
    }
    
    
}
