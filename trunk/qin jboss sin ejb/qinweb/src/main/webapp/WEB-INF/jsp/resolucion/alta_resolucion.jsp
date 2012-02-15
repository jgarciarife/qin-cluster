<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<script type="text/javascript">
	function sincronizar(resolId, inputId){
	    var textoAsinc = document.getElementById(inputId).value;
		$.getJSON("sincronizar.html", { id:  resolId, texto: textoAsinc }, function(rta) {
	            document.getElementById(inputId).value = rta.texto;
            });
}


</script>


<b>Codigo para resolución compartida:&nbsp;${codigo}</b>

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
			<form:hidden path="codigoResolucionCompartida" />
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
				<script type="text/javascript">
					setInterval( function(){sincronizar("${consigna.id}", "respuestas${consigna.orden}.respuesta")}, 5000) ;
				</script>
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

