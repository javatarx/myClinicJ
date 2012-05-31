<%@taglib prefix="acweb" uri="/WEB-INF/tag/myClinic.tld" %>
<%String idEspecialidad = request.getParameter("idEspecialidad"); %>
<acweb:ComboMedicos idEspecialidad="<%=idEspecialidad%>"/>