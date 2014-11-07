<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlUrna"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	String idUrna = request.getParameter("idUrna");
	    String idMunicipio = request.getParameter("idMunicipio");
	    String idDepartamento = request.getParameter("idDepartamento");
	    String numJunta = request.getParameter("numJunta");
	    String presidente = request.getParameter("presidente");
	    String secretario = request.getParameter("secretario");
	    String votosNulos = request.getParameter("votosNulos");
	    String votosNoValidos = request.getParameter("votosNoValidos");
	    String mensaje;
	    CtrlUrna ctrlUrna = new CtrlUrna();
	    boolean exito = ctrlUrna.actualizar(Integer.parseInt(idUrna), idMunicipio, idDepartamento, numJunta, presidente, secretario, votosNulos, votosNoValidos);
	    if(exito)
	    {
	    	mensaje = "Se actualizó la urna";
	    }
	    else{
	    	mensaje = "No existe esa urna";
	    }
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar urna</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="col-xs-4 col-xs-offset-4">
		<h1>Actualizar urna</h1>
	<%= mensaje %>
	</div>
</body>
</html>