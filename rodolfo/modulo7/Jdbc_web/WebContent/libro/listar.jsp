<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
	<tr><th>Libro</th></tr>
	<c:forEach var="l" items="${libros}">
		<tr>
			<td>
				<!-- Esto es "posible", luego correcto? -->
				${l.titulo}<br/>
				Compras: 
				<c:forEach var="c" items="${l.compras}">
					${c.lector.nombre} - 
				</c:forEach>
				<br/>
				Ofreces: 
				<c:forEach var="o" items="${l.ofreces}">
					<c:forEach var="c1" items="${o.libreria.compras}">
					 	${c1.lector.nombre} -
					 </c:forEach> 
				</c:forEach>
			</td>
		</tr>
	</c:forEach>
</table>
