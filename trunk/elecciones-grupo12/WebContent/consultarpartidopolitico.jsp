<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.context.*"%>
<%@page import="org.springframework.context.support.*"%>
<%@page import="org.springframework.web.context.support.*"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlPartidoPolitico"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.PartidoPolitico"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String idPartidoPolitico = request.getParameter("idPartidoPolitico");
CtrlPartidoPolitico ctrlPartidoPolitico = (CtrlPartidoPolitico) ac.getBean("ctrlPartidoPolitico");
PartidoPolitico partido = ctrlPartidoPolitico.daPartidoPoliticoById( idPartidoPolitico);
String mensaje;
if (partido != null) {
	mensaje = "ID: "+partido.getIdPartidoPolitico()+"<br>";
	mensaje += "Nombre: "+partido.getNombrePartido()+"<br>";
	mensaje += "Fecha de fundación: "+ new SimpleDateFormat("dd/MM/yyyy").format(partido.getFechaFundacion())+"<br>";
	mensaje += "Secretario general: "+partido.getNombreSecretarioGeneral()+"<br>";
}else {
	mensaje = "No existe un partido político con ese código";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar partido político</title>
</head>
<body>
	<%= mensaje %>
</body>
</html>