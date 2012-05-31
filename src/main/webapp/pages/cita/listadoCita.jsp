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
<table id="Table1" class="full" align="center" width="90%">
	<tr>
		<th>#</th>
		<th>Fecha</th>
		<th>Especialidad</th>
		<th>M&eacute;dico</th>
		<th>Paciente</th>
		<th>Comentario</th>
		<th>Modificar</th>
		<th>Eliminar</th>
	</tr>
<c:forEach items="${citas}" var="cita" varStatus="c">
<c:choose>
<c:when test="${not empty cita.usuario}">
	<tr>
		<td><c:out value="${c.count}"></c:out></td>
		<td><c:out value="${cita.fecha}"></c:out></td>
		<td><c:out value="${cita.especialidad.deEspecialidad}"></c:out></td>
		<td><c:out value="${cita.medico.deMedico}"></c:out></td>
		<td><c:out value="${cita.usuario.nombres} ${cita.usuario.apellidos}"></c:out></td>
		<td><c:out value="${cita.comentario}"></c:out></td>
		<td align="center"><a href="#modificar" title="Modificar"><img src="images/iconos/modificar.png"/></a></td>
	<td align="center"><a href="#eliminar" title="Eliminar"><img src="images/iconos/eliminar.png"/></a></td>
	</tr>
</c:when>
<c:otherwise>
	<tr >
	<td colspan="6">No hay datos</td>
	</tr>
</c:otherwise>
</c:choose>
</c:forEach>
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