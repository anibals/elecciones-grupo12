<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlVotacion"%>
<%@page import="java.util.Date"%>
<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
      <%
BigDecimal idVotacion = new BigDecimal(request.getParameter("idVotacion")) ;
int idUrna = Integer.parseInt(request.getParameter("idUrna"));
String idPartido = request.getParameter("idPartido");
BigDecimal cantVotos = new BigDecimal(request.getParameter("cantVotos")) ;
String creo="usuarioCrea", modifico="usuarioModifica";
Date fechaActual= new Date();
//Date fechaCreo = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual.toString());
//Date fechaModifico = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual.toString());
//Date fechaCreo = fechaActual;
Date fechaModifico =fechaActual;
CtrlVotacion ctrVotacion= new CtrlVotacion();
int resultado = ctrVotacion.actualizar(idVotacion, idUrna, idPartido, cantVotos, modifico, fechaModifico);

String mensaje="Error!";
switch(resultado){
case 0:  mensaje = "Ya existe votacion con esa ID";
         break;
case 1:  mensaje ="No existe Urna con esa ID";
         break;
case 2:  mensaje = "No existe Partido con esa ID";
         break;
case 3:  mensaje = "Se actualizo la Votacion correctamente";
         break;
}


%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votacion Actualizar</title>
</head>
<body>
<%= mensaje %>
</body>
</html>