<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlDepartamento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%
   String idDepto = request.getParameter("idDepto");
   CtrlDepartamento ctrlDepartamento = new CtrlDepartamento();
boolean exito = ctrlDepartamento.eliminar(idDepto);
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
<title>Eliminar Departamento</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- Inicio de texto a copiar -->
	<jsp:include page='menus/administrador.jsp' />
	<br>
	<br>
<!-- Fin de texto a copiar -->

<div class="col-xs-4 col-xs-offset-4">
		<h1>Eliminar Departamento</h1>
	<%= mensaje %>
	</div>
</body>
</html>