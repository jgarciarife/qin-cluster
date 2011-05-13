<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<form:form action="guardar_resolucion.html"  commandName="resolucion">
	<table class="sinbordes">
		<tr>
			<td>
			<h2>Trabajo Practico</h2>
			</td>
		</tr>
		<tr>
			<td><b>Titulo</b></td>
		</tr>
		<tr>
		</tr>
		<tr>
			<td><b>Contenido</b></td>
		</tr>
		<c:forEach items="${trabajoPractico.consignas}" var="consigna">
		<tr>
			<td>
				<b><c:out value="${consigna.orden}"/>-&nbsp;<c:out value="${consigna.consigna}"/></b>
			</td>  
		</tr>
		<tr>
			<td>
				Aca iria un input
			</td>  
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>  
		</tr>
		</c:forEach>
	</table>
</form:form>