<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<form action="ver_estadistica.html">
	<table>
		<tr>
			<td><h2>Ver Estadistica de TP segun materia</h2></td>
		</tr>
		<tr>
			<td>Materia:&nbsp;
			<select name="materiaId">
				<option value="-1">Todas las materias</option>
				<c:forEach var="materia" items="${materias}" varStatus="status">
					<option value="${materia.id}">${materia.nombre}</option>
				</c:forEach>
			</select>
			</td>
			<td><input type="submit" value="Buscar" /></td>
		</tr>
	</table>
</form>
	