<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.Votacion"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlVotacion"%>
    
     <%
    BigDecimal idVotacion = new BigDecimal(request.getParameter("idVotacion")) ;
CtrlVotacion ctrlVotacion= new CtrlVotacion();

boolean exito = ctrlVotacion.eliminar(idVotacion);
String mensaje;
if (exito) {
	mensaje = "Se realizó la eliminación";
}else {
	mensaje = "No se realizó la eliminación";
}
%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar Votacion</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="col-xs-4 col-xs-offset-4">
		<h1>Eliminar Votacion</h1>
	<%= mensaje %>
	</div>
</body>
</html>