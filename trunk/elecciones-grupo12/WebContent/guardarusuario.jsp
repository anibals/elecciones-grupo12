<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlSegUsuario"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlSegPersona"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.SegPersona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	String mensaje;
    Integer idPersona=0;
    String dui = request.getParameter("dui");
    String usuario = request.getParameter("usuario");
    String clave = request.getParameter("clave");    
    Integer idRol =Integer.parseInt(request.getParameter("idRol"));
	CtrlSegUsuario ctrlSegUsuario = new CtrlSegUsuario();
	CtrlSegPersona ctrlSegPersona = new CtrlSegPersona();
	SegPersona persona =ctrlSegPersona.daPersonaByDui(dui);
	int activo=1;
	if(persona!=null){
		idPersona=persona.getIdPersona();
		boolean exito = ctrlSegUsuario.guardar(idPersona, idRol, usuario, clave, activo);
		if (exito) {
			mensaje = "Se guardo el usuario";
		}else {
		mensaje = "El usuario ya existe";
		}
	}else {
		mensaje="No existe persona";
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guardar usuario</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
</head>
<body>
<div class="col-xs-4 col-xs-offset-4">
<%= mensaje %>
</div>
</body>
</html>