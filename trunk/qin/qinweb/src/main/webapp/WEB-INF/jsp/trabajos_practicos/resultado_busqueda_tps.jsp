<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>


<display:table name="trabajos" id="row" class="conbordes">
  <display:column property="titulo" title="Titulo"/>
  <display:column title="Editar/Evaluar">
	<a href="alta_tp.html?id=${row.id}" /><img alt="Editar" title="Editar" src="images/edit-icon.gif" height="20"/></a>&nbsp;
	<a href="evaluar_tp.html?id=${row.id}" /><img alt="Evaluar"  title="Evaluar" src="images/search.gif" height="20"/></a>
  </display:column>
</display:table>
