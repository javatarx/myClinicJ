<%@taglib prefix="acweb" uri="/WEB-INF/tag/myClinic.tld" %>
<%String fecha = request.getParameter("fecha"); %>
<%String horario = request.getParameter("horario")==null?"x":request.getParameter("horario"); %>
<%String idMedico = request.getParameter("idMedico"); %>
<acweb:ComboHorarios fecha="<%=fecha%>" horario="<%=horario%>" idMedico="<%=idMedico%>"/>