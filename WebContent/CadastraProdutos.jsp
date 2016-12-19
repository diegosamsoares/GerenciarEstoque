<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/estilo.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Produtos</title>
</head>
<body>
  <nav id="menu" >
        
        
              <ul class="nav navbar-nav" >
                <li class="active"><a href="index.jsp">Inicio</a></li>
                <li><a href="CadastraProdutos.jsp">Cadastrar Produtos</a></li>
                <li><a href="#">Gerenciar Estoque</a></li>        
                 <li><a href="#">Relatórios</a></li>            
                <li><a href="#">Sobre</a></li>
                  <li><a href="ProdutosSevlet?acao=AutenticaUsuario">Sair</a></li>
              </ul>
       
        </nav>

		<h1>CADASTRO DE PRODUTOS</h1>
		<a class="listarprodutos" href="ProdutosSevlet?acao=ListarProdutos" >Produtos Cadastrados</a>
		
	
		
		<form action="ProdutosSevlet" method="post" >
		
		<input type="hidden"  name="acao" value="AdicionarProduto" />
		<table>
		<tr><td>Descriçao:</td><td><input type="text" maxlength="45" name="descricao" required="required" size="35"/></td></tr>
		<tr><td>Valor de Compra:</td><td><input type="number" min="0.01" step="0.01" size="4" required="required" name="valorcompra" /></td></tr>
		<tr><td>Valor de Venda:</td><td><input type="number" min="0.01" step="0.01" size="4" required="required" name="valorvenda" /></td></tr>
		<tr><td>Peso:</td><td><input type="number" min="0.01" step="0.01" name="peso" required="required" size="4" />KG</td></tr>
		<tr><td>Quantidade:</td><td><input type="number" min="0.01" step="0.01" name ="saldo" required="required" size="4"  /></td></tr>
	
	
		
		</table>
		
		<input type="submit" value="Gravar"/>
		
		
		
		</form>
		
		
		
</body>
</html>