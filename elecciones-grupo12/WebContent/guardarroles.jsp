<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlRoles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
String nombreRoles = request.getParameter("nombreRol");
CtrlRoles ctrlRoles = new CtrlRoles();
boolean exito = ctrlRoles.guardar(nombreRoles);
String mensaje;
if (exito) {
	mensaje = "Se creó el Rol";
}else {
	mensaje = "El Rol ya existe";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guardar Roles</title>
</head>
<body>
<%= mensaje %>
</body>
</html>