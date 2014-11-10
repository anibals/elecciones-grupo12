<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.Departamento"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlDepartamento"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.Municipio"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlMunicipio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%
    String nombre= request.getParameter("idmunicipio");
    CtrlMunicipio ctrlmunicipio= new CtrlMunicipio();
    
    Municipio munic= ctrlmunicipio.daMunicipio(nombre);
    String iddepto=munic.getIdMunicipio().getIdDepartamento();
    CtrlDepartamento depart= new CtrlDepartamento();
    Departamento depto=depart.daDepartamentoById(iddepto);
    Municipio municipio= ctrlmunicipio.daMunicipio(nombre);
    String mensaje;
	if (municipio != null) {
		mensaje = "Nombre Municipio: "+municipio.getNomb_municipio()+"<br>";
		mensaje += "Departamento: "+depto.getNombDepto()+"<br>"; 
		mensaje += "ID municipio: "+municipio.getIdMunicipio()+"<br>";
	}else {
		mensaje = "No existe un municipio con ese ID";
	}
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Municipio Consultar</title>
</head>
<body>
<jsp:include page='menus/administrador.jsp' />
	<br>
	<br>

	<div class="col-xs-4 col-xs-offset-4">
		<h1>Consultar Municipio</h1>
		<%=mensaje%>
	</div>

</body>
</html>