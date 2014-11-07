<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.Urna"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlUrna"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
	String idUrna = request.getParameter("idUrna");
	CtrlUrna ctrlUrna = new CtrlUrna();
	Urna urna =  ctrlUrna.daUrnaById(Integer.parseInt(idUrna));
	String mensaje;
	if(urna!= null)
	{
		mensaje = "ID de urna: " + urna.getIdUrna() + "<br>";
		mensaje += "ID de municipio: " + urna.getMunicipio().getIdMunicipio().getIdMunicipio() + "<br>";
		mensaje += "ID de departamento: " + urna.getMunicipio().getIdMunicipio().getIdDepartamento() + "<br>";
		mensaje += "Número de junta: " + urna.getNumeroDeJunta() + "<br>";
		mensaje += "Presidente: " + urna.getPresidente() + "<br>";
		mensaje += "Secretario: " + urna.getSecretario() + "<br>";
		mensaje += "Cantidad de votos nulos: " + urna.getCantidadVotosNulos() + "<br>";
		mensaje += "cantidad de votos no válidos: " + urna.getCantidadVotosNoValidos() + "<br>";
	}
	else{
		mensaje = "No existe urna con ese código";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar urna</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="col-xs-4 col-xs-offset-4">
		<h1>Consultar urna</h1>
	<%= mensaje %>
	</div>
</body>
</html>