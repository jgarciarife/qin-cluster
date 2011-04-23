<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form action="guardar_tp.html" name="elaboracion_tp">
<table>
	<tr>
		<td><form:select path="materia">
			<form:option value="-" label="--Seleccione una Materia" />
			<form:options items="${materias}" itemValue="codigo"
				itemLabel="nombre" />
		</form:select></td>
	</tr>
	<tr>
		<td>
		<h2>Nuevo TP</h2>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td><b>Titulo</b></td>
	</tr>
	<tr>
		<td><input type="text" name="titulo" id="titulo" size="100"
			maxlength="100" /></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td><b>Contenido</b></td>
	</tr>
	<tr>
		<td><textarea rows="15" cols="100" name="contenido"
			id="contenido"></textarea></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td><input type="submit" value="Guardar" /></td>
	</tr>
</table>
</form>