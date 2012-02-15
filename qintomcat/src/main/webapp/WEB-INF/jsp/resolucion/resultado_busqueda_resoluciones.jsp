<%@ page import="com.qin.entity.Usuario" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>


<display:table name="grupos" id="row" class="sinbordes">
  <display:column property="resolucion.trabajoPractico.titulo" title="Tp"/>
  <display:column property="autores" title="Autores"/>
  <display:column title="Editar/Evaluar">
  	<% if (!((Usuario)session.getAttribute("usuarioEnSession")).isEvaluador()){ %>
	<a href="alta_resolucion.html?id=${row.resolucion.id}" /><img alt="Editar" title="Editar" src="images/edit-icon.gif" height="15"/></a>&nbsp;
	<% } %>
	<% if (((Usuario)session.getAttribute("usuarioEnSession")).isEvaluador()){ %>
	<a href="evaluar_resolucion.html?id=${row.resolucion.id}" />Evaluar</a>
	<% } %>
  </display:column>
</display:table>
