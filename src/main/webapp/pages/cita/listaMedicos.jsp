<%@taglib prefix="acweb" uri="/WEB-INF/tag/myClinic.tld" %>
<%String idEspecialidad = request.getParameter("idEspecialidad"); %>
<%String idMedico = request.getParameter("idMedico")==null?"x":request.getParameter("idMedico"); %>
<acweb:ComboMedicos idEspecialidad="<%=idEspecialidad%>" idMedico="<%=idMedico%>"/>