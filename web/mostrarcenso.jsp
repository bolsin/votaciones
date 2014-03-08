<%-- 
    Document   : mostrarcenso
    Created on : 19-ene-2014, 23:22:38
    Author     : carlos
--%>

<%@page import="PaqueteVotaciones.Censo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList myArrayList;
            myArrayList = (ArrayList)session.getAttribute("tablacenso");
        %>
            <table border='1' align='center'><tr><td>NIF</td><td>VOTADO</td>
        <%
            for(int i=0;i<myArrayList.size();i++)
            {
                Censo objcenso=(Censo)myArrayList.get(i);
        %>
                <tr><td><% out.print(objcenso.getNif()); %></td><td><% out.print(objcenso.getVotado()); %></td></tr>             

            <%}%> 
            </table>

        
    </body>
</html>
