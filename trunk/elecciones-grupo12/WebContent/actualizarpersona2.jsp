<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlSegPersona"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.SegPersona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    Integer id;
    String dui = request.getParameter("dui");
    String nombrePer = request.getParameter("nombrePer");
    String apellidoPer = request.getParameter("apellidoPer");    
    String telefonoPer = request.getParameter("telefonoPer");
    String emailPer = request.getParameter("emailPer");
	CtrlSegPersona ctrlSegPersona = new CtrlSegPersona();
	SegPersona  persona = ctrlSegPersona.daPersonaByDui(dui);
	id=persona.getIdPersona();
	boolean exito = ctrlSegPersona.actualizar(id,nombrePer, apellidoPer, telefonoPer, dui, emailPer);
	String mensaje;
	if (exito) {
		mensaje = "Se actualizo los datos personales";
	}else {
	mensaje = "No se puede actualizar los datos personales";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar datos personales</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
</head>
<body>
<div class="col-xs-4 col-xs-offset-4">
<%= mensaje %><br><br>
</div>
</body>
</html>