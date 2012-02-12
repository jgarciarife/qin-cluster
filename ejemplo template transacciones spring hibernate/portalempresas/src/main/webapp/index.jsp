<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Portal Empresas</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="center"
	width="100%" class="sinbordes">
	<tr>
		<td height="30" colspan="2"><span style="font: 1.8em/1.8em Arial, Helvetica, sans-serif"><b>Portal Empresas</b></span></td>
	</tr>
	<tr>
		<td width="100%">
		
		
	<form name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
			<label for="j_username">Usuario:</label>
			<input type="text" name="j_username" id="j_username"/>
			<br/>
			<label for="j_password">Passwords:</label>
			<input type="password" name="j_password" id="j_password"/>
			<br/>
			<input type="submit" value="Login"/>
		</form>

		</td>
	</tr>
</table>
</body>
</html>




