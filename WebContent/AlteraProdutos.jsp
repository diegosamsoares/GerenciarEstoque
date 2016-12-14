<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/estilo.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Produtos</title>
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
        
		<h1>ALTERAÇAO DE PRODUTOS</h1>
		<a class="listarprodutos" href="ProdutosSevlet?acao=ListarProdutos" >Produtos Cadastrados</a>
		
	
		<form action="ProdutosSevlet"  method="Post"  >
		<input type="hidden"  name="acao" value="AlteraProdutos" />
		<input type="hidden" name="id" value="${produto.id }"/>
			<table>
			<tr><td>Descrição:</td><td><input type="text" name="descricao" size="35" value="${produto.descricao }"/></td></tr>
			<tr><td>Valor de Compra:</td><td><input type="text" name="valorcompra"  size="4"value="${produto.valorcompra }"/></td></tr>
			<tr><td>Valor de Venda:</td><td><input type="text" name="valorvenda"  size="4"value="${produto.valorvenda }"/></td></tr>
			<tr><td>Peso:</td><td><input type="text" name="peso"  size="4"value="${produto.peso }"/></td></tr>
			<tr><td>Quantidade:</td><td><input type="text" name ="saldo"  size="4"  value="${produto.saldo }"/></td></tr>
			
		</table>
			
		<input type="submit" value="Gravar"/>
		
		</form>
		
		
		
</body>
</html>