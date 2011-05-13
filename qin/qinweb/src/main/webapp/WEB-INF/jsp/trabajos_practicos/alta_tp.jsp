<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<form:form action="guardar_tp.html"  name="trabajoPractico2" commandName="trabajoPractico">
	<table class="sinbordes">
		<tr>
			<td>
			<h2>Trabajo Practico</h2>
			<c:if test="${not empty trabajoPractico.id}">
			    <form:hidden path="id" />
			</c:if>
			</td>
		</tr>
		<tr>
			<td><b>Materia:</b>&nbsp;<form:select path="materia.id">
				<form:options items="${materias}" itemValue="id" itemLabel="nombre" />
			</form:select></td>
		</tr>
		<tr>
			<td><b>Titulo</b></td>
		</tr>
		<tr>
			<td><form:input path="titulo" /></td>
		</tr>
		<tr>
		</tr>
		<tr>
			<td><b>Contenido</b></td>
		</tr>
		<tr>
			<td><form:textarea path="consignas[0].consigna" /><form:hidden path="consignas[0].orden" value="1" /><form:hidden path="consignas[0].puntaje" value="1" /></td>
		</tr>
		<tr>
			<c:if test="${empty trabajoPractico.id}">
				<td><input type="submit" value="Guardar" /></td>
			</c:if>
			<c:if test="${not empty trabajoPractico.id}">
			    <td><input type="submit" value="Actualizar" /></td>
			</c:if>
		</tr>
	</table>
</form:form>