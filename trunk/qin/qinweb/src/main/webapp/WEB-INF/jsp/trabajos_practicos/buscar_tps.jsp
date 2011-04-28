<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h1>Busqueda de Trabajos Practicos</h1>
<form action="buscar.html">
	<table>
		<tr>
			<td>Materia:&nbsp;
			<select name="materiaId">
				<c:forEach var="materia" items="${materias}" varStatus="status">
					<option value="${materia.id}">${materia.nombre}</option>
				</c:forEach>
			</select>
			</td>
			<td><input type="submit" value="Buscar" /></td>
		</tr>
	</table>
</form>
