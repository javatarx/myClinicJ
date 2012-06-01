<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>myClinic | Men&uacute; Principal</title>
<link rel="stylesheet" type="text/css" href="css/tuempresa.css" />
<link rel="stylesheet" type="text/css" href="css/menu.css" />
<link rel="stylesheet" type="text/css" href="css/redmond/jquery-ui-1.8.16.custom.css" />
<script src="js/jquery-1.6.3.min.js" type="text/javascript" language="javascript"></script>
<script src="js/jquery-ui-1.8.16.min.js" type="text/javascript" language="javascript"></script>
<script src="js/jquery.ui.datepicker-es.js" type="text/javascript" language="javascript"></script>
<script src="js/myClinic.js" type="text/javascript"></script>
<script src="js/tableMyClinic.js" type="text/javascript"></script>
<%@page import="org.joedayz.acweb.domain.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%BNUsuario usuario=(BNUsuario)request.getSession().getAttribute("usuario"); %>
<% String url=getServletContext().getContextPath(); %>
<% SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM ',' yyyy", new Locale("es_ES"));
	Date fecha = Calendar.getInstance().getTime();
%>

</head>
<body>
<a href="mainMenu.html" title="Regresar a la P&aacute;gina Principal"><div id="logoI"></div></a>
        <div id="logMid"><%=formateador.format(fecha)%> | <a href="<%=url%>/ServletLogin" >LogOut</a></div>
		<div id="logIn">
        <span class="titulo1">Bienvenido</span>	
        <div>User: <span class="contenido1"> <%=usuario.getNombres()+" "+usuario.getApellidos()%></span></div>
        <div>Rol: <span class="contenido1"><%=usuario.getDeRol() %></span></div>
  
</body>
</html>