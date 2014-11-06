<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlPartidoPolitico"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.PartidoPolitico"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String idPartidoPolitico = request.getParameter("idPartidoPolitico");

CtrlPartidoPolitico ctrlPartidoPolitico = new CtrlPartidoPolitico();
boolean exito = ctrlPartidoPolitico.eliminar( idPartidoPolitico);
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
<title>Eliminar partido político</title>
</head>
<body>
	<%= mensaje %>
</body>
</html>