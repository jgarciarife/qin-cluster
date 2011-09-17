<%@ page import="com.qin.entity.Usuario" %>
<span><a href="home.html">Home</a></span>
<span><a href="consultar.html">Consultar</a></span>
<% if (((Usuario)session.getAttribute("usuarioEnSession")).isEvaluador()){ %>
	<span><a href="alta_tp.html">Alta TP</a></span>
<%} %>
<span><a href="iniciar_busqueda.html">Buscar TPs</a></span>
<% if (((Usuario)session.getAttribute("usuarioEnSession")).isEvaluador()){ %>
	<span><a href="buscar_resoluciones.html">Buscar Todas las Resoluciones</a></span>
	<span><a href="estadistica_tp.html">Estadistica TP</a></span>
<%} %>


