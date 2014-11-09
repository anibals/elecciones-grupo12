<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlMunicipio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%
    	String iddepto = request.getParameter("iddepto");
	    String idmunicipio = request.getParameter("idmunicipio");
	    String nombremuni = request.getParameter("nombremuni");
	    String mensaje;
	    CtrlMunicipio ctrlmunicipio = new CtrlMunicipio();
	    boolean exito =ctrlmunicipio.actualizar(iddepto, idmunicipio, nombremuni);
	    if(exito)
	    {
	    	mensaje = "Se actualizo el municipio";
	    }
	    else{
	    	mensaje = "Ya existe el municipio";
	    }
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Municipio</title>
</head>
<body>
   <%=mensaje %>
</body>
</html>