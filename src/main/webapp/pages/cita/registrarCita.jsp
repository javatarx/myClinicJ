<%@page import="org.joedayz.acweb.domain.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/myClinic.tld" prefix="acweb" %>
<!doctype html>
<%BNUsuario usuario=(BNUsuario)request.getSession().getAttribute("usuario"); %>
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
	
	<table width="90%" border="0"  style="margin:0 auto">
	<tr>
	<th colspan="2"><h2 class="titleForm">Formulario de Registro de Cita</h2>
	</th>
	</tr>
	<tr>
	<td><label class="labels">Paciente</label></td>
	<td><%=usuario.getNombres()+" "+usuario.getApellidos()%></td>
	</tr>
	<tr>
	<td width="30%"><label class="labels">Especialidad</label></td>
	<td><acweb:ComboEspecialidades/></td>
	</tr>
	<tr>
	<td><label class="labels">M&eacute;dico</label></td>
	<td>
		<div id="medico"></div>
	</td>
	</tr>
	<tr>
	<td><label class="labels">Fecha</label></td>
	<td><input type="date" id="fecha" name="fecha" size="60" required></td>
	</tr>
	<tr>
	<td><label class="labels">Horario</label></td>
	<td>
		<div id="horario">
		</div>
	</td>
	</tr>
	<tr>
	<td><label class="labels">Comentario</label></td>
	<td>
		<textarea rows="2" cols="25" name="comentario" id="comentario"></textarea>
	</td>
	</tr>
	<tr>
	<td colspan="2" align="center">
		<input type="submit" value="Guardar" >
	</td>
	</tr>
	</table>
	
	</form>
	</div>
 </div>
 
 
	<script type="text/javascript">
	$(function() {
		$( "#fecha" ).datepicker({
				dateFormat:"yy-mm-dd",
				regional:"es",
				showOn: "button",
				buttonImage: "images/iconos/calendar.gif",
				buttonImageOnly: true
// 				changeMonth: true,
// 				changeYear: true
			});
		
		$("#fecha").change(function(){
			datosHorario = "fecha="+$("#fecha").val();
			$.ajax({
				type	: "POST",
				url		: "listaHorarios.jsp",
				data	: datosHorario,
				success	: function(data){
					$("#horario").html(data);
				},
				error	: function(){
					$("#horario").html("No se encontraron horarios disponibles");
				}
			});
		});
		
		$("#idEspecialidad").change(function(){
			$.ajax({
				type	: "POST",
				url		: "listaMedicos.jsp",
				data	: "idEspecialidad="+$("#idEspecialidad option:selected").val(),
				success	: function(data){
					$("#medico").html(data);
				},
				error	: function(){
					$("#medico").html("No se encontraron medicos de esta especialidad");
				}
			});
		});
		
		$("#idEspecialidad").ready(function(){
			$.ajax({
				type	: "POST",
				url		: "listaMedicos.jsp",
				data	: "idEspecialidad="+$("#idEspecialidad option:selected").val(),
				success	: function(data){
					$("#medico").html(data);
				},
				error	: function(){
					$("#medico").html("No se encontraron medicos de esta especialidad");
				}
			});
		});
		
	});
	
	</script>

    
    <div id="footer_main">
     <jsp:include page="/footer.jsp" />
     </div>
</body>
</html>