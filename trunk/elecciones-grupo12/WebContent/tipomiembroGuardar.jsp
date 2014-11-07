<%@page import="java.util.Date"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.TipoMiembro"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlTipoMiembro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%
String idMiembro = request.getParameter("idMiembro");
String descripcion = request.getParameter("descripcion");

String creo="usuarioCrea", modifico="usuarioModifica";
Date fechaActual= new Date();
//Date fechaCreo = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual.toString());
//Date fechaModifico = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual.toString());
Date fechaCreo = fechaActual;
Date fechaModifico =fechaActual;
CtrlTipoMiembro ctrlTipoMiembro= new CtrlTipoMiembro();
boolean exito = ctrlTipoMiembro.guardar(idMiembro, descripcion, creo, fechaCreo, modifico, fechaModifico);

String mensaje;
if (exito) {
	mensaje = "Se almaceno el nuevo Tipo de Miembro correctamente";
}else {
	mensaje = "Ya hay un Tipo de Miembro con ese código";
}
%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guardar Nuevo Tipo Miembro</title>
</head>
<body>
<%= mensaje %>
</body>
</html>