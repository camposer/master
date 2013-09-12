<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/common.css" rel="stylesheet" type="text/css">
<title>Tienda de artículos electrónicos</title>
</head>
<body>
	<h1>Tienda de artículos electrónicos</h1>
	<form action="ModificarCarrito" method="post">
		<table id="tablaCarrito" class="tabla">
			<tr class="impar">
				<th>Artículo</th>
				<th>Precio</th>
				<th>Cantidad</th>
				<th>Precio</th>
				<th>Eliminar</th>
			</tr>

			<c:set var="total" value="0"/>
			<c:forEach var="p" items="${productos}"> 
				<tr class="par">
					<input type="hidden" name="productoId" value="${p.id}"/>
					<td>${p.nombre}</td>
					<td>${p.precio} €</td>
					<td><input type="text" name="cantidad${p.id}" class="cantidad" value="${p.cantidad}"/></td>
					<td>${p.total}</td>
					<td><a href="EliminarCarrito?id=${p.id}">eliminar</a></td>
				</tr>
				<c:set var="total" value="${total + p.total}"/>			
			</c:forEach>

			<tr id="total">
				<td colspan="3">Total:</td>
				<td colspan="2">${total}</td>
			</tr>
			<tr class="par">
				<td colspan="5">
					<a href="Principal"><input type="button" name="atras" value="Atrás" /></a> 
					<input type="submit" name="modificar" value="Modificar" />
				</td>
			</tr>
		</table>
	</form>

</body>
</html>