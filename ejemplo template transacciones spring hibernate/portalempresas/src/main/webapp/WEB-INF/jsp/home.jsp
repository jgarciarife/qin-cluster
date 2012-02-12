<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page import="ar.com.ospim.entities.Usuario" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<html>
<body>

Home!
<display:table name="usuarioEnSession" id="row" class="sinbordes">
  <display:column property="username" title="Usuario"/>
  <display:column property="nombre" title="Nombre"/>
  <display:column property="apellido" title="Apellido"/>
</display:table>

</body>
</html>
