<%@page import="org.joedayz.acweb.domain.*" %>
<%@page import="org.joedayz.acweb.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>


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
   <form>      
   
    <div align="center">
     
   <div align="left"><input type="button" name="Agregar" value="Agregar"  style="width:100px; margin-left: 45px"  onclick="location.href='<c:url value="ServletCita?tipo=I"/>'"/></div>
<table id="Table1" class="full" align="center" width="70%">
  <tr>
       <th>Cita</th>
       <th>dia</th>
       <th>doctor</th>
        <th>especialidad</th>
        <th>Comentario</th>
        <th>Modificar</th>
        <th>Eliminar</th>
  </tr>
  
   <tr>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>4</td>
                    <td>5</td>
                    <td align="center">
                    <a href="#modificar" title="Modificar"><img src="images/iconos/modificar.png"/></a>
                    </td>
                    <td align="center">
                     <a href="#eliminar" title="Eliminar"><img src="images/iconos/eliminar.png"/></a></td>
   </tr>
                <tr>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>4</td>
                    <td>5</td>
                   <td align="center">
                    <a href="#modificar" title="Modificar"><img src="images/iconos/modificar.png"/></a>
                    </td>
                    <td align="center">
                     <a href="#eliminar" title="Eliminar"><img src="images/iconos/eliminar.png"/></a></td>
                </tr>
                
            </table>
    

    </div>    
    </form> 
    </div>

    
    <div id="footer_main">
     <jsp:include page="/footer.jsp" />
     </div>

</body>

</body>
</html>