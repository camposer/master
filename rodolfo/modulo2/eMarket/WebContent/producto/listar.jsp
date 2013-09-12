<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<table id="tablaPrincipal" class="tabla">
			<tr>
				<th>Id</th>
				<th>Artículo</th>
				<th>Precio</th>
				<th>Modificar</th>
				<th>Eliminar</th>
			</tr>

			<c:forEach var="p" items="${productos}"> 
				<tr>
					<td><input type="hidden" name="productoId" value="${p.id}"/>${p.id}</td>
					<td>${p.nombre}</td>
					<td>${p.precio} €</td>
					<td><a href="Mostrar?id=${p.id}">modificar</a></td>
					<td><a href="Eliminar?id=${p.id}">eliminar</a></td>
				</tr>
			</c:forEach>
		</table>
