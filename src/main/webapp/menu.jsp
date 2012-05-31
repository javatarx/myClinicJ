<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<% String url=getServletContext().getContextPath(); %>
</head>
<body>
	<div id="menu">
    		<ul>
            <li><a href="<%=url%>/ServletCita?list=lista">Citas</a></li>
            <li><a href="<%=url%>/ServletUsuario?list=lista">Administraci&oacute;n</a></li>
            </ul>
   	</div>
</body>
</html>