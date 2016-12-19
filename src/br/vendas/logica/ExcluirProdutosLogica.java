package br.vendas.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vendas.controle.ConnectionFactory;
import br.vendas.modelo.DaoProdutos;

public class ExcluirProdutosLogica implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Connection connection = (Connection) request.getAttribute("conexao");		
			DaoProdutos daoProdutos = new DaoProdutos(connection);
daoProdutos.Excluir(daoProdutos.Getid(new Long(request.getParameter("id"))));	
		 
			
			RequestDispatcher requestDispatcher =	request.getRequestDispatcher("ProdutosSevlet?acao=ListarProdutos");
		   requestDispatcher.forward(request, response);
		} catch (Exception e) {
			
		}
		
	}

}
