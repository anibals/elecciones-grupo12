<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.PadronElectoral"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlPadronElectoral"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
String dui= request.getParameter("dui");
CtrlPadronElectoral ctrlpadron=new CtrlPadronElectoral();

PadronElectoral padron = ctrlpadron.daPadron(dui);


String mensaje;
if (padron!= null) {
	mensaje = "DUI: "+padron.getDui()+"<br>";
	mensaje += "Nombre: "+padron.getNombre()+"<br>";
	mensaje += "Apellido: "+padron.getApellidos()+"<br>";
	mensaje += "Fecha Nacimiento: "+padron.getFecha_nac()+"<br>";
	mensaje += "Domicilio: "+padron.getDomicilio()+"<br>";
	mensaje += "Estado votacion: "+padron.getEstadoVotacion()+"<br>";
	mensaje += "Cantidad de Votos Validos: "+padron.getIdUrna().getIdUrna()+"<br>";
	
}else {
	mensaje = "No existe";
}
%>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <%=mensaje %>
</body>
<jsp:include page='menus/administrador.jsp' />
	<br>
	<br>
</html>