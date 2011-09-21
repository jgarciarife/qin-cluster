<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="jquery/jquery.js"></script>  
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="center"
	width="100%" class="principal">
	 <tiles:insertAttribute name="header" />
	<tr>
		<td>
			<table border="1" cellpadding="2" cellspacing="2" align="center"
			width="90%" class="principal">
			<tr>
				<td width="100%" class="topnav"><tiles:insertAttribute name="menu" /></td>
			</tr>
			<tr height="350">
				<td width="100%" valign="top"><tiles:insertAttribute name="body" /></td>
			</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>