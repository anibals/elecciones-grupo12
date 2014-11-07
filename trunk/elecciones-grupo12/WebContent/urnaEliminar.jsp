<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlUrna"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String idUrna = request.getParameter("idUrna");
	String mensaje;
	CtrlUrna ctrlUrna = new CtrlUrna();
	boolean exito = ctrlUrna.eliminar(Integer.parseInt(idUrna));
	if(exito)
	{
		mensaje = "Se eliminó la urna";
	}
	else
	{
		mensaje = "No existe la urna o no se puede eliminar";
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar urna</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="col-xs-4 col-xs-offset-4">
		<h1>Eliminar urna</h1>
	<%= mensaje %>
	</div>
</body>
</html>