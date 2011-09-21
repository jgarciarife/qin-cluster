<%@ page import="com.qin.entity.Usuario" %>
<span><a class="topnav" href="home.html">Home</a></span>&nbsp;&nbsp;&nbsp;
<span><a class="topnav" href="consultar.html">Consultar</a></span>&nbsp;&nbsp;&nbsp;
<% if (((Usuario)session.getAttribute("usuarioEnSession")).isEvaluador()){ %>
	<span><a class="topnav" href="alta_tp.html">Alta TP</a></span>&nbsp;&nbsp;&nbsp;
<%} %>
<span><a class="topnav" href="iniciar_busqueda.html">Buscar TPs</a></span>&nbsp;&nbsp;&nbsp;
<% if (((Usuario)session.getAttribute("usuarioEnSession")).isEvaluador()){ %>
	<span><a class="topnav" href="buscar_resoluciones.html">Buscar Todas las Resoluciones</a></span>&nbsp;&nbsp;&nbsp;
	<span><a class="topnav" href="estadistica_tp.html">Estadistica TP</a></span>&nbsp;&nbsp;&nbsp;
<%} %>
