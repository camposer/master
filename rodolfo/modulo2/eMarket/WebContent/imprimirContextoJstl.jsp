<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.emarket.to.Producto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Imprimiendo contexto</title>
</head>
<body>
	Sin JSTL: <%= request.getAttribute("texto") %><br/>
	Con JSTL: <c:out value="${texto}"/><br/>
	Con JSTL: <c:out value="${requestScope.texto}"/><br/>
	Con JSTL: <c:out value="${sessionScope.texto}"/><br/>
	Con JSTL: <c:out value="${applicationScope.texto}"/><br/><br/>
	
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
		</tr>
		<%
			Object oproductos = request.getAttribute("productos");
			if (oproductos != null && oproductos instanceof List) {
				List<Producto> productos = (List<Producto>) oproductos;
				for (Producto p : productos) {
		%>
				<tr>
					<td><%= p.getId() %></td>
					<td><%= p.getNombre() %></td>
					<td><%= p.getPrecio() %></td>
				</tr>
		<%
				}
			}
		%>
	</table>

<br/>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
		</tr>
		<c:forEach var="p" items="${productos}">
			<c:if test="${p.precio > 250}">
				<tr>
					<td><c:out value="${p.id}"/></td>
					<td>${p.nombre}</td>
					<td>${p.precio}</td>
					
					
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<br/><br/>
	<c:set var="total_1" value="200" scope="request"/>
	<c:set var="clave" value="total_1"/>
	
	<%-- Este código permite acceder al valor de una propiedad cuyo nombre puede cambiar (es dinámico) --%>
	<%-- http://stackoverflow.com/questions/6162264/jstl-how-to-get-a-value-of-value --%>
	Clave: ${requestScope[clave]} 
</body>
</html>