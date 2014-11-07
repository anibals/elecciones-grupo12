<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.TipoMiembro"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlTipoMiembro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        
    <%
String idTipoMiembro = request.getParameter("idMiembro");
CtrlTipoMiembro ctrlMiembro=new CtrlTipoMiembro();
boolean exito = ctrlMiembro.eliminar(idTipoMiembro);
String mensaje;
if (exito) {
	mensaje = "Se realizó la eliminación";
}else {
	mensaje = "No se realizó la eliminación";
}
%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar Tipo Miembro</title>
</head>
<body>
<%= mensaje %>
</body>
</html>