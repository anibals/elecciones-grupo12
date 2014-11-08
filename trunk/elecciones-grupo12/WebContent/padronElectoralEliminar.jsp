<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlPadronElectoral"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    String dui = request.getParameter("dui");
   
    CtrlPadronElectoral ctrlpadron=new CtrlPadronElectoral();
    boolean exito=ctrlpadron.eliminar(dui);
    String mensaje;
    if(exito){
    	mensaje="Guardado con exito";
    }else{
    	mensaje="No existe dui en el padron";
    }
    
     %>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar Padron ELectoral</title>
</head>
<body>
<%=mensaje %>
</body>
</html>