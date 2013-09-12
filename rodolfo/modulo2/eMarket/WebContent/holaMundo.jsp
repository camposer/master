<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hola mundo!</title>
</head>
<body>
	<%! 
		public void imprimir(JspWriter jw, String mensaje) {
			try { jw.println(mensaje); } catch (Exception e) {}
		}
	%>
	<% String mensaje = request.getParameter("mensaje"); %>
	<% Date fecha = new Date(); %>
	<%= mensaje %><br/>
	<% out.println(mensaje); %><br/>
	<%= "Hola mundo!" %><br/>
	<%= (mensaje != null)?mensaje:"" %><br/>
	Hola mundo!<br/>
	<% imprimir(out, mensaje); %>
	<% if (mensaje != null) { %>
		Hola mundo!<br/>
	<% } else { %>
		Nada que decir
		de verdad que no</br>
	<% } %>
	<%= fecha %>
	<%--Cualquier cosa que no quiero que salga en el HTML --%>	
</body>
</html>