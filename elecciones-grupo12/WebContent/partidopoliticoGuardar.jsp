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
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- Inicio de texto a copiar -->
	<jsp:include page='menus/administrador.jsp' />
	<br>
	<br>
<!-- Fin de texto a copiar -->

	<div class="col-xs-4 col-xs-offset-4">
		<h1>Guardar partido pol�tico</h1>
	<%= mensaje %>
	</div>
</body>
</html>