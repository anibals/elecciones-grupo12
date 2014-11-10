<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlMiembroJrv"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	String id = request.getParameter("id");
	    String nombres = request.getParameter("nombres");
	    String apellidoPaterno = request.getParameter("apellidoPaterno");
	    String apellidoMaterno = request.getParameter("apellidoMaterno");
	    String idJrv = request.getParameter("idJrv");
	    String idTipoMiembro = request.getParameter("idTipoMiembro");
	    
	    CtrlMiembroJrv ctrlMiembroJrv = new CtrlMiembroJrv();
	    boolean exito = ctrlMiembroJrv.actualizar(id, nombres, apellidoPaterno, apellidoMaterno, idJrv, idTipoMiembro);
	    String mensaje;
	    if (exito) {
	    	mensaje = "Se actualizó el miembro de Jrv";
	    }else {
	    	mensaje = "No hay un miembro de Jrv con ese código";
	    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar miembro de JRV</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page='menus/administrador.jsp' />
	<br>
	<br>
<div class="col-xs-4 col-xs-offset-4">
<h1>Actualizar miembro de JRV</h1>	
	<%= mensaje %>
</div>
</body>
</html>