<%@ page import="com.qin.entity.Usuario" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>


<display:table name="trabajos" id="row" class="sinbordes">
  <display:column property="titulo" title="Titulo"/>
  <display:column title="Editar/Evaluar">
	<% if (((Usuario)session.getAttribute("usuarioEnSession")).isEvaluador()){ %>
		<a href="alta_tp.html?id=${row.id}" /><img alt="Editar" title="Editar" src="images/edit-icon.gif" height="15"/></a>&nbsp;
		<a href="buscar_resoluciones.html?tpId=${row.id}" /><img alt="Buscar Resoluciones"  title="Buscar Resoluciones" src="images/search.gif" height="15"/></a>&nbsp;
	<%} %>
	<% if (!((Usuario)session.getAttribute("usuarioEnSession")).isEvaluador()){ %>
		<a href="alta_resolucion.html?tpId=${row.id}" />Resolver</a>
		<a href="unirse_resolucion.html?tpId=${row.id}" />Unirse a resolucion</a>
	<%} %>
  </display:column>
</display:table>
