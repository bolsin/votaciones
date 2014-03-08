<%-- 
    Document   : mostrarEscrutinio.jsp
    Created on : 20-ene-2014, 18:39:46
    Author     : carlos
--%>

<%@page import="PaqueteVotaciones.Partidos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><h1>VOTAR</h1></center>
    <%
            ArrayList myArrayList;
            myArrayList = (ArrayList)session.getAttribute("tablaEscrutinio");
            Partidos partido1=(Partidos)myArrayList.get(0);
            Partidos partido2=(Partidos)myArrayList.get(1);
            Partidos partido3=(Partidos)myArrayList.get(2);
        %>
        <form method="post" action="index.jsp">
<table width="200" border="1" align="center">
  <tr>
    <td><img src="apple.jpeg"/></td>
    <td><% out.print(partido1.getVotos()+" Votos"); %></td>
  </tr>
  <tr>
    <td><img src="win.png"/></td>
    <td><% out.print(partido2.getVotos()+" Votos"); %></td>
  </tr>
  <tr>
    <td><img src="tux.png"/></td>
    <td><% out.print(partido3.getVotos()+" Votos"); %></td>
  </tr>
</table>
<center><p>volver
  <input type="submit" name="volver" id="volver" value="VOLVER A INICIO" />
</p></center>
</form>
    </body>
</html>
