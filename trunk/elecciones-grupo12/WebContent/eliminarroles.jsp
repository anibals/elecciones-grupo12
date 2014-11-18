<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlRoles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    Integer idRol =Integer.parseInt(request.getParameter("idRol").trim());
	CtrlRoles ctrlRoles = new CtrlRoles();
	boolean exito = ctrlRoles.eliminar(idRol);
	String mensaje;
	if (exito) {
	mensaje = "Se elimino el Rol";
	}else {
	mensaje = "no se pudo eliminar el rol";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar rol</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
</head>
<body>
<div class="col-xs-4 col-xs-offset-4">
<%= mensaje %>
</div>
</body>
</html>