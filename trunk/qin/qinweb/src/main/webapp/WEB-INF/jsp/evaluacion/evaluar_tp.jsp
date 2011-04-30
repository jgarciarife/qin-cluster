<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<form:form action="guardar_evaluacion_tp.html"
	commandName="trabajoPractico">
	<table class="sinbordes">
		<tr>
			<td>
			<h2>Trabajo Practico</h2>
			<form:hidden path="id" /></td>
		</tr>
		<tr>
			<td><b>Materia:</b>&nbsp;${trabajoPractico.materia.nombre}</td>
		</tr>
		<tr>
			<td><b>Titulo</b></td>
		</tr>
		<tr>
			<td>${trabajoPractico.titulo}</td>
		</tr>
		<tr>
			<td><b>Contenido</b></td>
		</tr>
		<tr>
			<td>${trabajoPractico.itemProductoAcademicos[0].enunciado}</td>
		</tr>
		<tr>
			<td><input type="submit" value="Guardar Evaluacion" /></td>
		</tr>
	</table>
</form:form>