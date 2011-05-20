<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<form:form action="guardar_resolucion.html"  name="resolucion2" commandName="resolucion" method="post">
	<input type="hidden" name="tpId" value="${trabajoPractico.id}"/>
	<input type="hidden" id="trabajoPractico.id" name="trabajoPractico.id" value="${trabajoPractico.id}"/>
	<table class="sinbordes">
		<tr>
			<td>
			<b>Trabajo Practico -&nbsp;<c:out value="${trabajoPractico.titulo}"/></b>
			<c:if test="${not empty resolucion.id}">
			    <form:hidden path="id" />
			</c:if>
			</td>
		</tr>
		<tr>
			<td><b>Consignas</b></td>
		</tr>
		<c:forEach items="${trabajoPractico.consignas}" var="consigna">
		<tr>
			<td>
				<b><c:out value="${consigna.orden}"/>-&nbsp;<c:out value="${consigna.consigna}"/></b>
			</td>  
		</tr>
		<tr>
			<td>
				<form:textarea cols="60" rows="10" path="respuestas[${consigna.orden}].respuesta"/>
				<form:hidden path="respuestas[${consigna.orden}].id"/>
				<input type="hidden" id="respuestas${consigna.orden}.consigna.id" name="respuestas[${consigna.orden}].consigna.id" value="${consigna.id}"/>
			</td>  
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>  
		</tr>
		</c:forEach>
		<tr>
			<td><input type="submit" value="Guardar" /></td>
		</tr>
	</table>
</form:form>