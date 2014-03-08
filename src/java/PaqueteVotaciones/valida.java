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
@WebServlet(name = "valida", urlPatterns = {"/valida"})
public class valida extends HttpServlet {

    private Connection Conexion;
public void init(ServletConfig config) throws ServletException {
super.init(config);
        try {
            // Cargar el driver de mysql, Java puede entenderse con MySQL.
            Class.forName("com.mysql.jdbc.Driver");
        
            /* Cadena de conexión para conectar con MySQL en localhost, 
            seleccionar la base de datos llamada “ejercicio”*/
            String connectionUrl = "jdbc:mysql://mysql-votaciones.jelastic.lunacloud.com/votaciones";
            // Obtener la conexión con usuario y contraseña del servidor de MySQL: root y root
            Conexion=DriverManager.getConnection(connectionUrl,"root","sTwl0sFpru");
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
        try {
            String nif= request.getParameter("nif");
            String password = request.getParameter("password");
            
            HttpSession session = request.getSession(true);
            request.getSession().setAttribute("nif", nif);
            
            
            Censo objcenso= new Censo();
            
            boolean conectado=objcenso.buscarVotante(nif, password, Conexion);
            
            if(conectado)
            {
                response.sendRedirect("votar.jsp");
            }
            else
            {                
                out.println("<h1>Ya has votado o tus datos son incorrectos </h1><br />");
                out.println("<a href='index.jsp'>volver</a>");
                
            }
            
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
