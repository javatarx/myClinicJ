<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@page import="org.joedayz.acweb.domain.*"%>
<%
	BNUsuario usuario = (BNUsuario) request.getSession().getAttribute("usuario");
	SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM ',' yyyy hh:mm:ss a", new Locale("es"));
%>

<div id="footer_main">
	<div class="izq">
		&copy; Copyright, Todos los Derechos Reservados 2018 <a href="#">Javatar</a>
	</div>
	<div class="der">
		Hora de inicio de sesion:
		<%=formateador.format(usuario.getFechaSesion())%></div>
</div>
</body>
</html>