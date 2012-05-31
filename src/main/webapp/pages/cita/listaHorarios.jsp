<%@taglib prefix="acweb" uri="/WEB-INF/tag/myClinic.tld" %>
<%String fecha = request.getParameter("fecha"); %>
<acweb:ComboHorarios fecha="<%=fecha%>"/>