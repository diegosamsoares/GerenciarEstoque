<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de Produtos</title>
</head>
<body>
  <nav id="menu" >
        
        
              <ul class="nav navbar-nav" >
                <li class="active"><a href="index.jsp">Inicio</a></li>
                <li><a href="CadastraProdutos.jsp">Cadastrar Produtos</a></li>
                <li><a href="#">Gerenciar Estoque</a></li>     
                <li><a href="#">Relatórios</a></li>               
                <li><a href="#">Sobre</a></li>
              </ul>
       
        </nav>


<h1>Listagem de Produtos</h1>



<a class="listarprodutos" href="CadastraProdutos.jsp" >Cadastrar Produtos</a>

  <table border="1">
  <tr>
  <td>Id</td>
  <td>Descricao</td>
  <td>Valor de Compra</td>
  <td>Valor de Venda</td>
  <td>Peso</td>
  <td>Saldo</td>
  
  </tr>
	
<c:forEach  var="produto" items="${lista }" varStatus="id">
		
		<tr bgcolor="#${id.count %2 ==0 ? 'C0C0C0' : 'ffffff' }">
		<td>${produto.id} </td>
        <td><a href="ProdutosSevlet?acao=PreencheProdutos&id=${produto.id }" >${produto.descricao }</a> </td>
        <td>${produto.valorcompra }</td>
        <td>${produto.valorvenda }</td>
        <td>${produto.peso }	</td>
        <td>${produto.saldo }</td>
        <td><a  href="ProdutosSevlet?acao=ExcluirProdutos&id=${produto.id} ">Excluir</a></td>
      </tr>
</c:forEach>
      
       
        
  
        
        </table> 
     		
		



</body>
</html>