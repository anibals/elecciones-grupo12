<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.Departamento"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlDepartamento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
<%
String idDepto = request.getParameter("idDepto");
CtrlDepartamento ctrlDepartamento = new CtrlDepartamento();
Departamento departamento = ctrlDepartamento.daDepartamentoById(idDepto);
String mensaje;
if (departamento!= null) {
	mensaje = "ID: "+departamento.getIdDepto()+"<br>";
	mensaje += "Nombre: "+departamento.getNombDepto()+"<br>";
	mensaje += "Zona de Geografia: "+departamento.getZonaGeografica()+"<br>";
	
}else {
	mensaje = "No existe un partido político con ese código";
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Departamento</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- Inicio de texto a copiar -->
	<jsp:include page='menus/administrador.jsp' />
	<br>
	<br>
<!-- Fin de texto a copiar -->

<div class="col-xs-4 col-xs-offset-4">
		<h1>Consultar Departament</h1>
	<%= mensaje %>
	</div>
</body>
</html>