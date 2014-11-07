<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.TipoMiembro"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlTipoMiembro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%
String idTipoMiembro = request.getParameter("idMiembro");
CtrlTipoMiembro ctrlMiembro=new CtrlTipoMiembro();
TipoMiembro miembro = ctrlMiembro.daTipoMiembroById(idTipoMiembro);
String mensaje;
if (miembro!= null) {
	mensaje = "ID: "+miembro.getIdTipoMiembro()+"<br>";
	mensaje += "Descripcion: "+miembro.getDescripcion()+"<br>";
	
	
}else {
	mensaje = "No existe un partido político con ese código";
}
%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Tipo Miembro</title>
</head>
<body>
<%= mensaje %>
</body>
</html>