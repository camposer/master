<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Vinos</title>
	<script>
		var clic = function() {
			var formulario = document.getElementById("formulario");
			var accion = document.getElementById("accion");
			var accionValor = accion.options[accion.selectedIndex].value;
			
			//formulario.setAttribute("action", accionValor);
			document.forms["formulario"].submit();
		}
	</script>
</head>
<body>
	<h1>Vinos</h1>
	<form id="formulario" name="formulario" action="agregar.do" method="get">
		<table>
			<tr>
				<td>Action:</td>
				<td>
					<select id="categorias" name="categorias" multiple="multiple">
						<option value="Tinto" selected>Tinto</option>
						<option value="Blanco" selected>Blanco</option>
						<option value="Rosado" selected>Rosado</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre"/></td>
			</tr>
			<tr>
				<td>Año:</td>
				<td><input type="text" name="anio"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="clic"/></td>
			</tr>
		</table>
	</form>
</body>
</html>