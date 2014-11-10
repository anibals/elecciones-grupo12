<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.Votacion"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlVotacion"%>
<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    BigDecimal idVotacion = new BigDecimal(request.getParameter("idVotacion")) ;
CtrlVotacion ctrlVotacion= new CtrlVotacion();
Votacion votacion = ctrlVotacion.daVotacionById(idVotacion);
String mensaje;
if (votacion!= null) {
	mensaje = "ID: "+votacion.getIdVotacion()+"<br>";
	mensaje += "Urna: "+votacion.getUrna().getIdUrna()+"<br>";
	mensaje += "Partido Politico: "+votacion.getPartido().getIdPartidoPolitico()+"<br>";
	mensaje += "Cantidad de Votos Validos: "+votacion.getCantVotosValidos()+"<br>";
	
}else {
	mensaje = "No existe un partido político con ese código";
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Votacion</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page='menus/administrador.jsp' />
	<br>
	<br>
<div class="col-xs-4 col-xs-offset-4">
		<h1>Consultar Votacion</h1>
	<%= mensaje %>
	</div>
</body>
</html>