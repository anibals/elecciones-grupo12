<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlMunicipio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    String nombremuni = request.getParameter("nombremuni");
    CtrlMunicipio ctrlmunicipio= new CtrlMunicipio();
    
    boolean exito=ctrlmunicipio.eliminarMunicipio(nombremuni);
    String Mensaje;
    if(exito){
    	Mensaje="Municipio ELiminado Correctamente";
     }else{
    	 Mensaje="Municipio no existe";
     }
    
    
    
    %>
    
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar Municipio</title>
</head>
<body>
<%=Mensaje %>



</body>
</html>