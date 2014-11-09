<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.Jrv"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlJrv"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
int idjrv = Integer.parseInt(request.getParameter("idjrv"));
CtrlJrv ctrljrv = new CtrlJrv();
Jrv jrv = ctrljrv.daJrvById(idjrv);
String mensaje;
if (jrv!= null) {
	mensaje = "Nombre Municipio: "+jrv.getMunicipio().getNomb_municipio()+"<br>";
	mensaje += "Nombre Departamento: "+jrv.getMunicipio().getIdMunicipio().getIdDepartamento()+"<br>";
	mensaje += "Zona de Geografia: "+jrv.getDui()+"<br>";
	
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
<%=mensaje %>
</body>
</html>