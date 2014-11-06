<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.Urna"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlUrna"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlPartidoPolitico"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.PartidoPolitico"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String idUrna = request.getParameter("idUrna");
CtrlUrna ctrlUrna = new CtrlUrna();
Urna urna = ctrlUrna.daUrnaById(Integer.parseInt(idUrna));
String mensaje;
if (urna != null) {
	mensaje = "Hola";
	
}else {
	mensaje = "No existe un partido político con ese código";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Urna</title>
</head>
<body>
	<%= mensaje %>
</body>
</html>