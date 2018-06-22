<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="org.joedayz.acweb.domain.*"%>
<%@page import="org.joedayz.acweb.util.*"%>
<% String url = getServletContext().getContextPath(); %>
<%BNUsuario usuario = (BNUsuario) request.getSession().getAttribute("usuario");%>

<ul>
    <li><a href="<%=url%>/ServletCita?list=lista">Mis Citas</a></li>
        <% if (usuario.getDeRol().equalsIgnoreCase(Constantes.ADMIN)) {%>            
    <li><a href="<%=url%>/ServletUsuario?list=lista">Administraci&oacute;n</a></li>
    <li>
        <a href="<%=url%>/Especialidad?list=lista"">Especialidades</a>
    </li>
    <li>
        <a href="<%=url%>/Medico?list=lista"">Medicos</a>
    </li>
        <% }%>
    
</ul>