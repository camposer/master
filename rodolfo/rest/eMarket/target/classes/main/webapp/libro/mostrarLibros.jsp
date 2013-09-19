<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<table border="1">
		<tr>
			<th>Id</th>
			<th>Título</th>
			<th>Autor</th>
			<th>Precio</th>
			<th>Librería</th>
			<th>Modificar</th>
			<th>Eliminar</th>
		</tr>
		<c:forEach var="libro" items="${libros}"> 
			<tr>
				<td><c:out value="${libro.id}" /></td>
				<td><c:out value="${libro.titulo}" /></td>
				<td><c:out value="${libro.autor}" /></td>
				<td><c:out value="${libro.precio}" /></td>
				<td><%--c:out value="${libro.ofreces.0.libreria.nombre} - ${libro.ofreces.0.libreria.cif}" / --%>
					<c:forEach var="ofrece" items="${libro.ofreces}"> 
						${ofrece.libreria.nombre} - ${ofrece.libreria.cif} 
						<br/>
					</c:forEach>
				</td>
				<td><a href="mostrar.em?id=<c:out value="${libro.id}" />">modificar</a></td>
				<td><a href="eliminar.em?id=<c:out value="${libro.id}" />">eliminar</a></td>
			</tr>
		</c:forEach>
	</table>	