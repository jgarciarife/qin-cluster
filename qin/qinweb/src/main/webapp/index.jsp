<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="hello.html">Hola! (Stateless)</a><br/>
        <form id="login" name="login" action="login.html">
        	<input type="text" id="user" name="user"/>
        	<input type="submit" value="Login (Statefull)" /> 
        </form>
        <a href="consulta.html">Consultar nombre sin ingresar uno nuevo (Statefull)</a><br/>
        Tu sessionId:&nbsp;<%=request.getSession().getId() %><br/>
        
        Probar loguearse con un nombre de usuario cualquiera. verificar el nombre del usuario logueado y el sessionID<br/>
        Luego cerrar el browser/borrar la info de navegacion (para que cambie el sessionID) y consultar el nombre logueado<br/>
        Resultado: el session bean mantiene la info de usuario, a pesar de ser SessionIDs diferentes... buuuuuuuuuuuuuu
    </body>
</html>
