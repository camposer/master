<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/common.css" rel="stylesheet" type="text/css">
<title>Artículos electrónicos</title>
</head>
<body>
	<h1>Tienda de artículos electrónicos</h1>	
	<form action="AgregarCarrito" method="post">
		<table id="tablaPrincipal" class="tabla">
			<tr>
				<th>Artículoss</th>
				<th>Precio</th>
				<th>Cantidad</th>
			</tr>

			<c:forEach var="p" items="${productos}"> 
				<tr>
					<input type="hidden" name="productoId" value="${p.id}"/>
					<td>${p.nombre}</td>
					<td>${p.precio} €</td>
					<td><input type="text" name="cantidad${p.id}" class="cantidad" value="0" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3"><input type="reset" name="restablecer"
					value="Borrar" /> <input type="submit" name="agregar"
					value="Agregar" /> <a href="MostrarCarrito"><input
						type="button" name="ver" value="Ver" /></a></td>
			</tr>
		</table>
	</form>
</body>
</html>