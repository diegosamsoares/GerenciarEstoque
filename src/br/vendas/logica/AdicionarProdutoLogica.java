package br.vendas.logica;


import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vendas.controle.ConnectionFactory;
import br.vendas.modelo.DaoProdutos;
import br.vendas.modelo.Produto;

public class AdicionarProdutoLogica implements Logica {

public void executa(HttpServletRequest request ,HttpServletResponse response) throws Exception {
	
	String descricao = request.getParameter("descricao");
	String valorvenda = request.getParameter("valorvenda");
	valorvenda = valorvenda.replaceAll("\\,", ".");
	
	String valorcompra = request.getParameter("valorcompra");
	valorcompra = valorcompra.replaceAll("\\,", ".");
	
	String peso = request.getParameter("peso");
	peso=peso.replaceAll("\\,", ".");
	
	String saldo = request.getParameter("saldo");
	saldo = saldo.replaceAll("\\,", ".");
	
	Produto produto = new Produto();

	produto.setDescricao(descricao);
	produto.setValorvenda(new Double(valorvenda));
	produto.setValorcompra(new Double(valorcompra));
	produto.setPeso(new Double(peso));
	produto.setSaldo(new Double(saldo));
	
	Connection connection = (Connection) request.getAttribute("conexao");		
	DaoProdutos dao = new DaoProdutos(connection);
	dao.adiciona(produto);

	PrintWriter out = response.getWriter();

	out.println("<SCRIPT>" + "alert('GRAVADO COM SUCESSO');" + " window.location.href='CadastraProdutos.jsp' "
			+ "</SCRIPT> ");
}	

	
}
