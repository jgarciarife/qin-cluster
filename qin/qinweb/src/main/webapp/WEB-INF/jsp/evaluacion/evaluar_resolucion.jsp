<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<form:form action="guardar_evaluacion_resolucion.html"  name="dictamen2" commandName="dictamen" method="post">
	<c:if test="${not empty dictamen.id}">
			   <form:hidden path="id" />
	</c:if>
	
	<input type="hidden" id="resolucion.id" name="resolucion.id" value="${resolucion.id}"/>
	<input type="hidden" name="resId" value="${resolucion.id}"/>
	<table class="sinbordes">
		<tr>
			<td>
				<b><c:out value="${resolucion.trabajoPractico.titulo}"/></b>
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>  
		</tr>
		<c:forEach items="${resolucion.respuestas}" var="rta">
		<tr>
			<td>
				<b><c:out value="${rta.consigna.orden}"/>-&nbsp;<c:out value="${rta.consigna.consigna}"/>&nbsp;-&nbsp;
				Puntaje maximo:&nbsp;<c:out value="${rta.consigna.puntaje}"/></b>
			</td>  
		</tr>
		<tr>
			<td>
				<c:out value="${rta.respuesta}"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:input size="50" path="correccions[${rta.consigna.orden}].correccion"/>&nbsp;Puntaje:&nbsp;<form:input  size="3" path="correccions[${rta.consigna.orden}].puntaje"/>
				<form:hidden path="correccions[${rta.consigna.orden}].id"/>
				<input type="hidden" id="correccions${rta.consigna.orden}.respuesta.id" name="correccions[${rta.consigna.orden}].respuesta.id" value="${rta.id}"/>
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>  
		</tr>
		</c:forEach>
		<tr>
			<td>
				<form:textarea cols="60" rows="10" path="dictamen"/>
			</td>  
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>  
		</tr>
		<tr>
			<td><input type="submit" value="Guardar" /></td>
		</tr>
	</table>
</form:form>