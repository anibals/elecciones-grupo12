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
</head>
<body>
<%= mensaje %>
</body>
</html>