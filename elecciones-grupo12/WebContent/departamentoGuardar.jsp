<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlDepartamento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
String idDepto = request.getParameter("idDepto");
String nombDepto = request.getParameter("nombreDepto");
String zonaGeografica = request.getParameter("zonaGeo");
String creo="usuarioCrea", modifico="usuarioModifica";
Date fechaActual= new Date();
//Date fechaCreo = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual.toString());
//Date fechaModifico = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual.toString());
Date fechaCreo = fechaActual;
Date fechaModifico =fechaActual;
CtrlDepartamento ctrlDepartamento= new CtrlDepartamento();
boolean exito = ctrlDepartamento.guardar(idDepto, nombDepto, zonaGeografica, creo, fechaCreo, modifico, fechaModifico);

String mensaje;
if (exito) {
	mensaje = "Se almaceno el nuevo Departamento correctamente";
}else {
	mensaje = "Ya hay un Departamento con ese código";
}
%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guardar Nuevo Departamento</title>
</head>
<body>
<%= mensaje %>
</body>
</html>