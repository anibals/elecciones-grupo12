<%@page import="java.util.Date"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlPartidoPolitico"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String idPartidoPolitico = request.getParameter("idPartidoPolitico");
String nombrePartido = request.getParameter("nombrePartido");
String fechaFundacion = request.getParameter("fechaFundacion");
String secretarioGeneral = request.getParameter("secretarioGeneral");


CtrlPartidoPolitico ctrlPartidoPolitico = new CtrlPartidoPolitico();
boolean exito = ctrlPartidoPolitico.guardar(idPartidoPolitico, nombrePartido, fechaFundacion, secretarioGeneral);
String mensaje;
if (exito) {
	mensaje = "Se cre� el partido pol�tico";
}else {
	mensaje = "Ya hay un partido pol�tico con ese c�digo";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guardar partido pol�tico</title>
</head>
<body>
	<%= mensaje %>
</body>
</html>