<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>


<display:table name="resoluciones" id="row" class="conbordes">
  <display:column property="id" title="Id"/>
  <display:column title="Editar/Evaluar">
	<a href="alta_resolucion.html?id=${row.id}" /><img alt="Editar" title="Editar" src="images/edit-icon.gif" height="20"/></a>&nbsp;
	<a href="evaluar_resolucion.html?id=${row.id}" /><img alt="Evaluar"  title="Evaluar" src="images/search.gif" height="20"/></a>
  </display:column>
</display:table>
