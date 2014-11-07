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
	    boolean exito = ctrlUrna.guardar(Integer.parseInt(idUrna), idMunicipio, idDepartamento, numJunta, presidente, secretario, votosNulos, votosNoValidos);
	    if(exito)
	    {
	    	mensaje = "Se guardó la urna";
	    }
	    else{
	    	mensaje = "Ya existe esa urna";
	    }
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guardar urna</title>
</head>
<body>
	<%= mensaje %>
</body>
</html>