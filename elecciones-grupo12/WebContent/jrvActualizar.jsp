<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlJrv"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
       <%
    CtrlJrv jrv= new CtrlJrv();
    String idjrv=request.getParameter("idjrv");
    String depto=request.getParameter("iddepto");
    String municipio=request.getParameter("idmunicipio");
    String dui=request.getParameter("dui");
    boolean exito=jrv.actualizar(idjrv,depto, municipio, dui);
    String mensaje;
    if(exito){
    	mensaje="se actualizo correctamente";
    }else{
    	mensaje="No existe ID de JRV";
    }
    
    %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar JRV</title>
</head>
<body>
<%=mensaje %>
</body>
</html>