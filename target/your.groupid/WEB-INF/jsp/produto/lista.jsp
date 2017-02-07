<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Produtos</h1>
<table>
<c:forEach var="produto" items="{produtoList}">
<tr>
<td>${nome}</td>
<td>${preco}</td>
<td>${descricao}</td>
<td> 
<fmt:formatDate pattern="dd/MM/yyyy" value="${dataInicioVenda.time}"/>

</td>
</tr>
</c:forEach>
</table>
</body>
</html>