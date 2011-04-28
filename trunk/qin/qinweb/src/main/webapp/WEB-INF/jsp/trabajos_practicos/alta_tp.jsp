<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<form:form action="guardar_tp.html" commandName="trabajoPractico">
	<table>
		<tr>
			<td>
			<h2>Trabajo Practico</h2>
			<c:if test="${not empty trabajoPractico.id}">
			    <form:hidden path="id" />
			</c:if>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>Materia:&nbsp;<form:select path="materia.id">
				<form:options items="${materias}" itemValue="id" itemLabel="nombre" />
			</form:select></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
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
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><b>Contenido</b></td>
		</tr>
		<tr>
			<td><form:textarea rows="15" cols="100"
				path="itemProductoAcademicos[0].enunciado" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
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