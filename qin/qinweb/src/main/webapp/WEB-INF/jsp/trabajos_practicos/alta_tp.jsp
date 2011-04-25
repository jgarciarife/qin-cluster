<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form action="guardar_tp.html" commandName="trabajoPractico">
	<table>
		<tr>
			<td>
			<h2>Nuevo TP</h2>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>Materia:&nbsp;<form:select path="materia.id">
				<form:options items="${materias}" itemValue="id"
					itemLabel="nombre" />
			</form:select></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><b>Titulo</b></td>
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
			<td><form:textarea rows="15" cols="100" path="itemProductoAcademicos[0].enunciado" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><input type="submit" value="Guardar" /></td>
		</tr>
	</table>
</form:form>