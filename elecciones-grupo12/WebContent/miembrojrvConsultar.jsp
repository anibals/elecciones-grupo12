<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.MiembroJRV"%>
<%@page import="java.util.List"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlMiembroJrv"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlPartidoPolitico"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.PartidoPolitico"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String idJrv = request.getParameter("idJrv");
CtrlMiembroJrv ctrlMiembroJrv = new CtrlMiembroJrv();
List<MiembroJRV> miembros = ctrlMiembroJrv.daMiembrosByJRV(idJrv);
String mensaje = "";
if (miembros != null) {
	for(MiembroJRV miembro : miembros)
	{
		mensaje += "ID Miembro JRV: "+miembro.getIdMiembroJrv()+"<br>";
		mensaje += "Nombres: "+miembro.getNombres()+"<br>";
		mensaje += "Apellido paterno: "+miembro.getApellidoPaterno()+"<br>";
		mensaje += "Apellido materno: "+miembro.getApellidoMaterno()+"<br>";
		mensaje += "ID JRV: "+miembro.getJrv().getId()+"<br>";
		mensaje += "ID Tipo Miembro: "+miembro.getTipoMiembro().getIdTipoMiembro()+"<br>";
		mensaje += "<br><br>";
	}
}else {
	mensaje = "No existe ninguna JRV con ese código o no hay miembros en él";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar miembros de JRV</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page='menus/administrador.jsp' />
	<br>
	<br>
<div class="col-xs-4 col-xs-offset-4">
<h1>Consultar miembros de JRV</h1>	
	<%= mensaje %>
</div>
</body>
</html>