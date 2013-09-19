<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Libros</title>
</head>
<body>
	<h1>Libros</h1>
	<form method="post" action="modificar.em">
		<input type="hidden" name="id" value="<c:out value="${libro.id}"/>" />
		<table>
			<tr>
				<td>Título</td>
				<td><input type="text" name="titulo" value="<c:out value="${libro.titulo}"/>"/></td>
			</tr>		
			<tr>
				<td>Autor</td>
				<td><input type="text" name="autor" value="<c:out value="${libro.autor}"/>"/></td>
			</tr>		
			<tr>
				<td>Precio</td>
				<td><input type="text" name="precio" value="<c:out value="${libro.precio}"/>"/></td>
			</tr>		
			<tr>
				<td>Librería</td>
				<td>
					<select name="libreriaId" multiple>
						<c:forEach var="libr" items="${librerias}">
							<%--c:choose>
								<c:when test="${libro.libreria.id} eq ${libr.id}">
									<option value="<c:out value="${libr.id}" />" selected="selected"><c:out value="${libr.nombre}"/></option>
								</c:when>
								<c:otherwise>
									<option value="<c:out value="${libr.id}" />"><c:out value="${libr.nombre}"/></option>								
								</c:otherwise>
							</c:choose --%>														
									<option value="<c:out value="${libr.id}" />"><c:out value="${libr.nombre}"/></option>								
						</c:forEach>
					</select>
				</td>
			</tr>		
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Modificar"/></td>
			</tr>				
		</table>
	</form>

	<br/>
	<% 
		out.flush();
		application.getRequestDispatcher("/libro/listar.em").include(request, response);
	%>
</body>
</html>





