<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlJrv"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%
    String id=request.getParameter("idjrv");
    CtrlJrv jrv= new CtrlJrv();
    jrv.eliminarJrv(id);
     
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar JRV</title>
</head>
<body>

</body>
</html>