package br.vendas.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vendas.controle.ConnectionFactory;
import br.vendas.modelo.DaoProdutos;
import br.vendas.modelo.Produto;

public class PesquisarProdutosLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome=request.getParameter("nome");
		Connection connection = (Connection) request.getAttribute("conexao");		
		DaoProdutos daoProdutos = new DaoProdutos(connection);
		List<Produto> lista = daoProdutos.Pesquisar(nome);
		request.setAttribute("lista", lista);

		RequestDispatcher rd = request.getRequestDispatcher("/ListaProdutos.jsp");
		rd.forward(request, response);
	}

}
