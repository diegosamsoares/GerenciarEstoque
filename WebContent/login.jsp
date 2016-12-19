<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bem Vindo</title>
</head>
<body>

<form method="Post"  action="ProdutosSevlet?acao=AutenticaUsuario">



Login:<input type="text"  name="login" value=""/>
Senha:<input type="password" name="senha" value=""/>


<input type="submit" value="Logar">
<p>${msgUsuario}</p>

</form>

</body>
</html>