<!DOCTYPE html>
<html lang="es">
<head>
<meta charset=utf-8" />
<title>myClinic | Men&uacute; Principal</title>
<link rel="stylesheet" type="text/css" href="css/tuempresa.css" />
<link rel="stylesheet" type="text/css" href="css/menu.css" />
<link rel="stylesheet" type="text/css" href="css/redmond/jquery-ui-1.8.16.custom.css" />
<script src="js/jquery-1.6.3.min.js" type="text/javascript" language="javascript"></script>
<script src="js/jquery-ui-1.8.16.min.js" type="text/javascript" language="javascript"></script>
<script src="js/myClinic.js" type="text/javascript"></script>
<script src="js/tableMyClinic.js" type="text/javascript"></script>
<%@page import="org.joedayz.acweb.domain.*"%>
<%BNUsuario usuario=(BNUsuario)request.getSession().getAttribute("usuario"); %>
<% String url=getServletContext().getContextPath(); %>



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
        
      
    </div>
    <div id="footer_main">
     <jsp:include page="/footer.jsp" />
     </div>

</body>
</html>
