<%-- 
    Document   : index
    Created on : 14-ene-2014, 20:23:13
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
        
<center><table width="245" border="1">
  <tr>
    <td width="235" height="215">
        <form id="form1" name="form1" method="post" action="valida">
      <p>
        <label for="nif">nif</label>
        <input type="text" name="nif" id="nif" />
      </p>
      <p>
        <label for="password">password</label>
        <input type="text" name="password" id="password" />
      </p>
 <p>votar
        <input type="submit" name="comprobar" id="comprobar" value="Enviar" />
      </p>    </form>
        
      <form id="form2" name="form2" method="post" action="consultaCenso">
        consultar
        <input type="submit" name="consultar" id="consultar" value="Enviar" />
      </form>
        
      <form id="form3" name="form3" method="post" action="ServletEscrutinio">
        escrutinio
        <input type="submit" name="escrutinio" id="escrutinio" value="Enviar" />
      </form>
      <p>&nbsp;</p></td>
  </tr>
</table></center>
    
    </body>
</html>
