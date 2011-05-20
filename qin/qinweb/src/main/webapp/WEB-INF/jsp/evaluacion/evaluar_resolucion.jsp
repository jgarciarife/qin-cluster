<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

	<input type="hidden" name="resId" value="${resolucion.id}"/>
	<table class="sinbordes">
		<c:forEach items="${resolucion.respuestas}" var="rta">
		<tr>
			<td>
				<b><c:out value="${rta.respuesta}"/></b>
			</td>  
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>  
		</tr>
		</c:forEach>
	</table>
