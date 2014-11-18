<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlSegPersona"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.SegPersona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String dui =request.getParameter("dui").trim();
    CtrlSegPersona ctrlSegPersona = new CtrlSegPersona();
    SegPersona  persona = ctrlSegPersona.daPersonaByDui(dui);
	String mensaje;
	String nombre="";
	String telefono="";
	String email="";
	if (persona==null) {
	mensaje = "No existen datos de esta persona ";
	}else {
	mensaje = "Los datos son los siguientes:";
	nombre=persona.getNombre()+" "+persona.getApellido();
	telefono=persona.getTelefono();
	email=persona.getEmail();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Persona</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
</head>
<body>
<div class="col-xs-4 col-xs-offset-4">
<%= mensaje %><br><br>
Nombre:<%= nombre %><br><br>
Telefono:<%= telefono%><br><br>
Correo:<%= email %><br><br>
</div>
</body>
</html>