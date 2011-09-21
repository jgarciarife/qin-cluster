<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<form:form action="guardar_tp.html"  name="trabajoPractico2" commandName="trabajoPractico">
<table id="table_alta_tp" class="sinbordes">
		<tr>
			<td>
			<h1>Trabajo Practico</h1>
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
			<td><b>Titulo</b>&nbsp;<form:input path="titulo" /></td>
		</tr>
		<tr>
		</tr>
		<tr>
			<td><b>Contenido</b>&nbsp;
				<a href="#" id="add">Agregar Consigna</a> &nbsp;
	   			<a href="#" id="remove">Borrar Consigna</a>
	   		</td>  
		</tr>
		<c:forEach items="${trabajoPractico.consignas}" var="consigna">
		<tr>
			<td>
				<c:out value="${consigna.orden}"/>-&nbsp;
				<form:input size="50" path="consignas[${consigna.orden}].consigna"/>
				&nbsp;Puntaje:&nbsp;
				<form:input size="3" path="consignas[${consigna.orden}].puntaje"/>
				<form:hidden path="consignas[${consigna.orden}].orden"/>
				<form:hidden path="consignas[${consigna.orden}].id"/>
			</td>  
		</tr>
		</c:forEach>
</table>
<table>
	<tr>
		<td>
			<c:if test="${empty trabajoPractico.id}">
				<td><input type="submit" value="Guardar" /></td>
			</c:if>
			<c:if test="${not empty trabajoPractico.id}">
			    <td><input type="submit" value="Actualizar" /></td>
			</c:if>
			</td>
	</tr>
</table>
</form:form>

<script type="text/javascript">  
$(function() { // when document has loaded  
       var i = ${fn:length(trabajoPractico.consignas)};  
       $('a#add').click(function() {   
    	   var index = i;
           $('<tr id="tr_'+index+'"><td><b>'+ index +'- </b><input size="50" type="text" '
        		   +'id=\"consignas'+index+'.consigna\" name=\"consignas['+index+'].consigna\" value=\"\" />'
        		   +'<input id=\"consignas'+index+'.orden\" name=\"consignas['+index+'].orden\" type="hidden" value="'+index+'"/>'
        		   +'&nbsp;Puntaje:&nbsp;<input size="3" type="text" id=\"consignas'+index+'.puntaje\" name=\"consignas['+index+'].puntaje\" value=\"\"/></td></tr>'
        		   ).appendTo('table#table_alta_tp');
           $('#consignas'+index+'.consigna').focus();
           i++;   
       });
       
       $('a#remove').click(function() {   
	       if(i > 0) { 
	           i--;   
	           $('#tr_'+i).remove();   
	       }  
       });
       
});
</script>  
  