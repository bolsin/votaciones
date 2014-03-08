/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteVotaciones;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author carlos
 */
@WebServlet(name = "consultaCenso", urlPatterns = {"/consultaCenso"})
public class consultaCenso extends HttpServlet {

    
    private Connection Conexion;
    private ArrayList PersonasEnElCenso;
public void init(ServletConfig config) throws ServletException {
super.init(config);
        try {
            // Cargar el driver de mysql, Java puede entenderse con MySQL.
            //Class.forName("com.mysql.jdbc.Driver");
        
            /* Cadena de conexión para conectar con MySQL en localhost, 
            seleccionar la base de datos llamada “ejercicio”*/
            //String connectionUrl = "jdbc:mysql://localhost:3306/votaciones?zeroDateTimeBehavior=convertToNull";
            // Obtener la conexión con usuario y contraseña del servidor de MySQL: root y root
            //Conexion=DriverManager.getConnection(connectionUrl,"root","hola_20");
            singleconexion Con= singleconexion.crearcon(); //creamos el objeto con de la clase singleton. Observar que no hay new por que no se puede instanciar
            Conexion=Con.getcon(); //usamos el metodo que devuelve el objeto de tipo Connection
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(valida.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(valida.class.getName()).log(Level.SEVERE, null, ex);
        }

}
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();        
        
        Censo objcenso= new Censo();
        
        
        try {
            
            PersonasEnElCenso = objcenso.gente(Conexion);
            HttpSession session = request.getSession(true);
            request.getSession().setAttribute("tablacenso", PersonasEnElCenso);
            
            response.sendRedirect("mostrarcenso.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(consultaCenso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
