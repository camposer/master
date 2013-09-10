<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Libro</title>
</head>
<body>
	<center>
	<h1>Libros</h1>
	<form action="Agregar" method="post">
		<table>
			<tr>
				<td>Título</td>
				<td><input type="text" name="titulo"/></td>
			</tr>
			<tr>
				<td>Autor</td>
				<td><input type="text" name="autor"/></td>
			</tr>
			<tr>
				<td>Precio</td>
				<td><input type="text" name="precio"/></td>
			</tr>
			<tr>
				<td>Librería</td>
				<td>
					<select name="libreriaId"> 
						<c:forEach var="l" items="${librerias}">
							<option value="${l.id}">${l.nombre}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Agregar"/>
				</td>
			</tr>
		</table>
	</form>
	<br/>
	<%
		out.flush();
		application.getRequestDispatcher("/libro/Listar").include(request, response);
	%>
	</center>
</body>
</html>