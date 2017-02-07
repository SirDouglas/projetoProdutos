<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Produtos</title>
  <script type="text/javascript"  src="<c:url value="/js/jquery-3.1.1.js"/>"> </script>
  <script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script>
<link type="text/css" href="<c:url value="/css/jquery-ui.css"/>" rel="stylesheet" />
<link type="text/css"  href="<c:url value="/css/jquery-ui.theme.css"/>" rel="stylesheet" />
</head>
<body>
<script type="text/javascript">
function removeProduto(id) {
$('#mensagem')
.load('<c:url value="/produto/remove"/>' +
'?produto.id=' + id);
$('#produto' + id).remove(); 
		}
</script>
<h1>Produtos</h1>
<div id="mensagem"> </div>
<table>
<tr>
<td>Nome do Produto </td>
<td>Preço </td>
<td>Data de Inicio Venda</td>
<td>Remover </td>
</tr>
<c:forEach var="produto" items="${produtoList}">
<tr id="produto${produto.id}">
<td>${produto.nome}</td>
<td>${produto.preco}</td>
<td> <fmt:formatDate pattern="dd/MM/yyyy" value="${produto.dataInicioVenda.time}"/> </td>
<td> <a href=# onclick="return removeProduto(${produto.id})">Remover</a> </td>
<td> <a href="<c:url value="/produto/mostra"/>?produto.id=${produto.id}">Alterar</a> </td>
</tr>
</c:forEach>
</table>
</body>
</html>