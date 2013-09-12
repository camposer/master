<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head/>
<body onload='kfdsjkj'>
Hola (en request): <%= request.getAttribute("texto") %>
En sesión: <%= session.getAttribute("texto") %>
En sesión: <%= request.getSession().getAttribute("texto") %>
</body>
