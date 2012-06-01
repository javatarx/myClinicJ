<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<%@page import="org.joedayz.acweb.domain.*"%>
<%@page import="org.joedayz.acweb.util.*"%>
<% String url=getServletContext().getContextPath(); %>
<%BNUsuario usuario=(BNUsuario)request.getSession().getAttribute("usuario"); %>
</head>
<body>
	<div id="menu">
    		<ul>
            <li><a href="<%=url%>/ServletCita?list=lista">Citas</a></li>
<% if(usuario.getDeRol().equalsIgnoreCase(Constantes.ADMIN)){ %>            
            <li><a href="<%=url%>/ServletUsuario?list=lista">Administraci&oacute;n</a></li>
<% }%>
            </ul>
   	</div>
</body>
</html>