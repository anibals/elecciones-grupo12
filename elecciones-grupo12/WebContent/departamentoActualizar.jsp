<%@page import="java.util.Date"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlDepartamento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    String idDepto = request.getParameter("idDepto");
    String nombDepto = request.getParameter("nombreDepto");
    String zonaGeografica = request.getParameter("zonaGeo");
    String modifico="usuarioModifica";
    Date fechaActual= new Date();
    //Date fechaCreo = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual.toString());
    //Date fechaModifico = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual.toString());
   // Date fechaCreo = fechaActual;
    Date fechaModifico =fechaActual;
    CtrlDepartamento ctrlDepartamento= new CtrlDepartamento();
    boolean exito = ctrlDepartamento.actualizar(idDepto, nombDepto, zonaGeografica, modifico, fechaModifico);
String mensaje;
if (exito) {
	mensaje = "Se actualiz� el Departamento";
}else {
	mensaje = "No existe un Departamento con ese c�digo";
}
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Departamento</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
</head>
<body>
 <div id="container">
          
<!-- Inicio de texto a copiar -->
	<jsp:include page='menus/administrador.jsp' />
	<br>
	<br>
<!-- Fin de texto a copiar -->


<div class="col-xs-4 col-xs-offset-4">
		<h1>Actualizar Departamento</h1>
	<%= mensaje %>
	</div>
	</div>
</body>
</html>