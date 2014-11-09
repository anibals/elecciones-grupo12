<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlRoles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    Integer idRol =Integer.parseInt(request.getParameter("idRol").trim());
	String nombreRoles = request.getParameter("nombreRol");
	CtrlRoles ctrlRoles = new CtrlRoles();
	boolean exito = ctrlRoles.actualizar(idRol, nombreRoles);
	String mensaje;
	if (exito) {
	mensaje = "Se modifico el Rol";
	}else {
	mensaje = "no se pudo modificar el rol";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%= mensaje %>
</body>
</html>