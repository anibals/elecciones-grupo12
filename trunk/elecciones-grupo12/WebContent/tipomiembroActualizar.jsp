<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlTipoMiembro"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
        <%
String idMiembro = request.getParameter("idMiembro");
String descripcion = request.getParameter("descripcion");

String creo="usuarioCrea", modifico="usuarioModifica";
Date fechaActual= new Date();
//Date fechaCreo = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual.toString());
//Date fechaModifico = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual.toString());
//Date fechaCreo = fechaActual;
Date fechaModifico =fechaActual;
CtrlTipoMiembro ctrlTipoMiembro= new CtrlTipoMiembro();
boolean exito = ctrlTipoMiembro.actualizar(idMiembro, descripcion, modifico, fechaModifico);

String mensaje;
if (exito) {
	mensaje = "Se actualizo el Tipo de Miembro correctamente";
}else {
	mensaje = "No existe un Tipo de Miembro con ese código";
}
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Tipo Miembro</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page='menus/administrador.jsp' />
	<br>
	<br>
<div class="col-xs-4 col-xs-offset-4">
		<h1>Actualizar Tipo Miembro</h1>
	<%= mensaje %>
	</div>
</body>
</html>