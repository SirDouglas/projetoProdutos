<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Login no Controle de Produtos </h2>
<form action="<c:url value="/login/autentica"/>"> 
Login: <input type="text" name="usuario.login" /> <br>
Senha: <input type="password"  name="usuario.senha"/>
<input type="submit"  value="Autenticar" />
</form>
</body>
</html>