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
	mensaje = "No existe un partido pol�tico con ese c�digo";
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Departamento</title>
</head>
<body>
<%= mensaje %>
</body>
</html>