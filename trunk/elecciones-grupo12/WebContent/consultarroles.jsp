<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlRoles"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.Roles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%
Integer idRol =Integer.parseInt(request.getParameter("idRol").trim());
CtrlRoles ctrlRoles = new CtrlRoles();
Roles roles= ctrlRoles.daRolesById(idRol);
String mensaje;
if (roles==null) {
	mensaje = "No existe el rol";
}else {
	mensaje = "El Rol es "+roles.getNombreRol();
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar rol</title>
</head>
<body>
<%= mensaje %>
</body>
</html>