<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/eMarket/css/common.css" rel="stylesheet" type="text/css">
<title>Tienda de artículos electrónicos</title>
</head>
<body>
	<h1>Tienda de artículos electrónicos</h1>
	<form action="Modificar" method="post">
		<input type="hidden" name="productoId" value="${producto.id}"/>
		<table id="tablaPrincipal">
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" value="${producto.nombre}"/></td>
			</tr>
			<tr>
				<td>Precio:</td>
				<td><input type="text"" name="precio" value="${producto.precio}"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="Modificar" value="Modificar"/></td>
			</tr>
		</table>	
	</form>
	<!-- BEGIN: Mostrando la lista de productos -->
	<% out.flush(); application.getRequestDispatcher("/producto/Listar").include(request, response); %>
	
	<!-- END: Mostrando la lista de productos -->
</body>
</html>