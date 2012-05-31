<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="es">
<head>
	<meta charset="utf-8">
</head>
<body>
<div id="conteiner">
	<!--cabecera-->
    <div id="top">
    	
    	<jsp:include page="/cabecera.jsp" />
    	</div>   
 	</div>
    <!--middle-->
  <div id="middle">
  
	<div id="menu">
    		<jsp:include page="/menu.jsp" />
   	</div>
     
	<div  style="border-color:blue;border: 1px; width:800px;">
	<form id="formulario" action="ServletCita" method="post">
	Aqui el formulario
	</form>
	</div>
 </div>

    
    <div id="footer_main">
     <jsp:include page="/footer.jsp" />
     </div>
</body>
</html>