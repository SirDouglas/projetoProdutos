<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<%@ taglib   uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Tarefa</title>
  <script type="text/javascript"  src="<c:url value="/js/jquery-3.1.1.js"/>"> </script>
  <script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script>
<link type="text/css" href="<c:url value="/css/jquery-ui.css"/>" rel="stylesheet" />
<link type="text/css"  href="<c:url value="/css/jquery-ui.theme.css"/>" rel="stylesheet" />
</head>
<body>
<form action="<c:url value="/produto/altera"/>">

Nome: <input name="produto.nome" value="${produto.nome}"/> <br>
Preço: <input name="produto.preco" value="${produto.preco}" /> <br>
Data de início da venda: 
<fmt:formatDate  var="data" value="${produto.dataInicioVenda.time}" pattern="dd/MM/yyyy"/>
<caelum:campoData id="dataInicioVenda" name="produto.dataInicioVenda" value="${data}"/>
<br />
<input type="hidden" name="produto.id" value="${produto.id}"/> <br>
<input class="ui-button ui-corner-all ui-widget" id="button" type="submit" value="Alterar" />  
</form>
</body>
</html>