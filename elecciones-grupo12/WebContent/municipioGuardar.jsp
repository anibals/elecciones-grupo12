<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.Departamento"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlMunicipio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
    <%
	String iddepto = request.getParameter("iddepto");
    String idmunicipio = request.getParameter("idmunicipio");
    String nombremuni = request.getParameter("nombremuni");
    
    CtrlMunicipio ctrlmunicipio=new CtrlMunicipio();
    
    boolean exito=ctrlmunicipio.guardarMunicipio(iddepto, idmunicipio, nombremuni);
    String Mensaje;
    if(exito){
    	Mensaje="Se creo el municipio correctamente";
    }else{
    	Mensaje="El municipio ya existe";
    }
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guardar Municipio</title>
</head>
<body>
<jsp:include page='menus/administrador.jsp' />
	<br>
	<br>
<%=Mensaje %>

</body>
</html>