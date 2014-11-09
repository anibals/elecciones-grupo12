<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlSegPersona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String duiPer = request.getParameter("dui");
    String nombrePer = request.getParameter("nombrePer");
    String apellidoPer = request.getParameter("apellidoPer");    
    String telefonoPer = request.getParameter("telefonoPer");
    String emailPer = request.getParameter("emailPer");
	CtrlSegPersona ctrlSegPersona = new CtrlSegPersona();
	boolean exito = ctrlSegPersona.guardar(nombrePer, apellidoPer, telefonoPer, duiPer, emailPer);
	String mensaje;
	if (exito) {
		mensaje = "Se guardo los datos de la persona";
	}else {
	mensaje = "la persona ya existe";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guardar persona</title>
</head>
<body>
<%= mensaje %>
</body>
</html>