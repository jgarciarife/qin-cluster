<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>


<form:form action="unirse_resolucion_codigo.html"  method="post">
	<table class="sinbordes">
		<tr>
			<td>Inregese código:</td>
			<td><input type="text" name="codigo"/></td>
			<td><input type="submit" value="Guardar" /></td>
		</tr>
	</table>
	<input type="hidden" id="tpId" name="tpId" value="${tpId}"/>
</form:form>

