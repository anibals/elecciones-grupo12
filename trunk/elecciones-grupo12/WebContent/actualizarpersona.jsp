<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.negocio.CtrlSegPersona"%>
<%@page import="sv.edu.ues.igf115.eleccionesgrupo12.dominio.SegPersona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String id;
    String dui =request.getParameter("dui").trim();
    CtrlSegPersona ctrlSegPersona = new CtrlSegPersona();
    SegPersona  persona = ctrlSegPersona.daPersonaByDui(dui);
	String mensaje;
	String nombre="No dato";
	String apellido="No dato";
	String telefono="No dato";
	String email="No dato";
	boolean activo;
	if (persona==null) {
	mensaje = "No existen datos de esta persona ";
	id="0";
	activo=true;
	}else {
	mensaje = "Los datos son los siguientes:";
	id=persona.getIdPersona().toString();
	nombre=persona.getNombre();
	apellido=persona.getApellido();
	telefono=persona.getTelefono();
	email=persona.getEmail();
	activo=false;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">

onload=function(){
if(<%= activo %>)
 activar();
else
 desactivar();
}

function activar(){
document.forms[0].actualizar.disabled=true;
}
function desactivar(){
document.forms[0].actualizar.disabled=false;
}
 
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar datos personales</title>
</head>
<body>
<%= mensaje %><br><br>

<form method="post" action="actualizarpersona2.jsp" >
	Id		  <%= id %><br><br>
    DUI:      <input type="text" value=<%= dui %> name="dui" ><br><br>
	Nombre:   <input type="text" value=<%= nombre %> name="nombrePer" ><br><br>
	Apellido: <input type="text" value=<%= apellido %> name="apellidoPer" ><br><br>
	Telefono: <input type="text" value=<%= telefono %> name="telefonoPer" ><br><br>
	email:    <input type="text" value=<%= email %> name="emailPer" ><br><br>
	<input name="actualizar" type="submit" value="Actualizar"><br><br>
	</form>
</body>
</html>