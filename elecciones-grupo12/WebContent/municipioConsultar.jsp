<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.Municipio"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlMunicipio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%
    String nombre= request.getParameter("idmunicipio");
    CtrlMunicipio ctrlmunicipio= new CtrlMunicipio();
    
    Municipio municipio= ctrlmunicipio.daMunicipio(nombre);
    String mensaje;
	if (municipio != null) {
		mensaje = "Nombre Municipio: "+municipio.getNomb_municipio()+"<br>";
		mensaje += "ID departamento: "+municipio.getIdMunicipio().getIdDepartamento()+"<br>"; 
		mensaje += "ID municipio: "+municipio.getIdMunicipio().getIdMunicipio()+"<br>";
	}else {
		mensaje = "No existe un partido político con ese nombre";
	}
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Municipio Consultar</title>
</head>
<body>


	<div class="col-xs-4 col-xs-offset-4">
		<h1>Consultar Municipio</h1>
		<%=mensaje%>
	</div>

</body>
</html>