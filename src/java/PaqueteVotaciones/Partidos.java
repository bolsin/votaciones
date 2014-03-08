/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteVotaciones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class Partidos {
    private String partido;
    private int votos;
    
    public Partidos(){
        
    }
    public Partidos(String parti, int voto){
        partido=parti;
        votos=voto;
    }
    
    public boolean votarPartido(String partido,Connection con) throws SQLException{
        
        int filasAfectadas=0;
        try
            {
                    
                    Statement s = con.createStatement();
                    String sql="update partidos set votos=(votos+1) where partido='"+partido+"'";
                    filasAfectadas= s.executeUpdate(sql);
                    
                    System.out.println(filasAfectadas);
                    
                    if(filasAfectadas==1)
                    {
                        s.close();                        
                        return true;
                    }
            }
            catch(SQLException SQL)//mejor sqlexception
            {
                   System.out.println(SQL.getMessage());
            }
        if (filasAfectadas==0)
        {
            throw new SQLException();    
        }
        return false;
    }

    
    public ArrayList escrutinio(Connection con) throws SQLException{
        ArrayList escrutinio=new ArrayList();
        
        Statement s = con.createStatement();
        String sql="SELECT partido, votos from partidos";
        ResultSet rs= s.executeQuery(sql);
        
        while(rs.next())
        {
            escrutinio.add(new Partidos(rs.getString("partido"), rs.getInt("votos") ));
        }
        return escrutinio;
    }
    
    
    /**
     * @return the partido
     */
    public String getPartido() {
        return partido;
    }

    /**
     * @param partido the partido to set
     */
    public void setPartido(String partido) {
        this.partido = partido;
    }

    /**
     * @return the votos
     */
    public int getVotos() {
        return votos;
    }

    /**
     * @param votos the votos to set
     */
    public void setVotos(int votos) {
        this.votos = votos;
    }
}
