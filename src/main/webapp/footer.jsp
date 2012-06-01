<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@page import="org.joedayz.acweb.domain.*"%>
<%	BNUsuario usuario=(BNUsuario)request.getSession().getAttribute("usuario"); 
  	SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM ',' yyyy hh:mm:ss a", new Locale("es"));
%>    
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
</head>
<body>
<div class="izq">&copy; Copyright, Todos los Derechos Reservados 2012 <a href="http://www.joedayz.pe">JoeDayz E.I.R.L</a>
     </div>
        <div class="der">Hora de inicio de sesion: <%=formateador.format(usuario.getFechaSesion())%></div>
	
</body>
</html>