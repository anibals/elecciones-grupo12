<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.Jrv"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlJrv"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
int id= Integer.parseInt(request.getParameter("idjrv"));
CtrlJrv ctrljrv = new CtrlJrv();
Jrv jrv = ctrljrv.daJrvById(id);
String mensaje;
if (jrv!= null) {
	mensaje = "ID JRV: "+jrv.getId()+"<br>";
	mensaje += "ID de municipio: " + jrv.getMunicipio().getIdMunicipio().getIdMunicipio() + "<br>";
	mensaje += "ID de departamento: " + jrv.getMunicipio().getIdMunicipio().getIdDepartamento() + "<br>";
	mensaje += "DUI: "+jrv.getDui().getDui()+"<br>";
	
}else {
	mensaje = "No existe un partido político con ese código";
}
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar JRV</title>
</head>
<body>
<jsp:include page='menus/administrador.jsp' />
	<br>
	<br>
<%=mensaje %>
</body>
</html>