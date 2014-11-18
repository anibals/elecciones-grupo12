<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlSegPersona"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlSegUsuario"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.SegUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String mensaje;
    Integer id =Integer.parseInt(request.getParameter("idPersona").trim());
    CtrlSegPersona ctrlSegPersona = new CtrlSegPersona();
    CtrlSegUsuario ctrlUsuario = new CtrlSegUsuario();
	SegUsuario usuario = ctrlUsuario.daUsuarioByPersona(id);
	if(usuario==null){
		boolean exito = ctrlSegPersona.eliminar(id);
		if (exito) {
		mensaje = "Se eliminaron los datos personales";
		}else {
		mensaje = "no se pudo eliminar los datos personales";
		}
	}else{
		mensaje = "no se puede eliminar los datos personales por que tiene un usuario asociado.";
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar datos personales</title>
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