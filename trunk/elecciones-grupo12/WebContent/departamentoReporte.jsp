<%@page import="java.io.File"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="application/pdf" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="net.sf.jasperreports.engine.export.*" %>
<%
Connection conn = null;
try { 
	Class.forName("com.mysql.jdbc.Driver"); //se carga el driver
	conn = DriverManager.getConnection(
			"jdbc:mysql://www.db4free.net:3306/elecciones2014",
			"g12igf2014", "g12igf2014*");
} catch (Exception ex) {
	ex.printStackTrace();
	//out.print("Excepcion");
}
JasperPrint print = JasperFillManager.fillReport(application.getRealPath("reportes/departamento.jasper"), null, conn);
JasperExportManager.exportReportToPdfStream(print,response.getOutputStream());

%>