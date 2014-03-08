<%-- 
    Document   : votar
    Created on : 15-ene-2014, 18:50:15
    Author     : carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><h1>VOTAR</h1></center>
        <form method="post" action="servletSeleccionPartido">
<table width="200" border="1" align="center">
  <tr>
    <td><img src="apple.jpeg"/></td>
    <td><label for="partido1">partido1</label>
      <input type="radio" name="radio" id="partido1" value="partido1" /></td>
  </tr>
  <tr>
    <td><img src="win.png"/></td>
    <td><label for="partido2">partido2</label>
      <input type="radio" name="radio" id="partido2" value="partido2" /></td>
  </tr>
  <tr>
    <td><img src="tux.png"/></td>
    <td><label for="partido3">partido3</label>
      <input type="radio" name="radio" id="partido3" value="partido3" /></td>
  </tr>
</table>
<center><p>votar
  <input type="submit" name="votar" id="votar" value="Enviar" />
</p></center>
</form>
    </body>
</html>
