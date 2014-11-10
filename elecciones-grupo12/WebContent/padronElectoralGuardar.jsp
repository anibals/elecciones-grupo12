<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlPadronElectoral"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    String dui = request.getParameter("dui");
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    Date fechanac = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fechanac"));
    String domicilio = request.getParameter("domicilio");
    String estado = request.getParameter("estado");
    int idurna = Integer.parseInt(request.getParameter("idurna"));
    
    CtrlPadronElectoral ctrlpadron= new CtrlPadronElectoral();
    boolean exito=ctrlpadron.guardar(dui, nombre, apellido, fechanac, domicilio, estado, idurna);
    String mensaje;
    if(exito){
    	mensaje="Guardado con exito";
    }else{
    	mensaje="ya existe";
    }
    
    
    %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Guardar Padron Electoral</title>
</head>
<body>

<jsp:include page='menus/administrador.jsp' />
	<br>
	<br>
<%=mensaje %>


</body>
</html>