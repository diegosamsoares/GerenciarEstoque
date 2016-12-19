package br.vendas.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vendas.controle.ConnectionFactory;
import br.vendas.modelo.DaoProdutos;
import br.vendas.modelo.Produto;

public class AlteraProdutosLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Connection connection = (Connection) request.getAttribute("conexao");		
			DaoProdutos daoProdutos = new DaoProdutos(connection);
			Produto produto = null;
			produto =	daoProdutos.Getid(new Long(request.getParameter("id")));
			String descricao = request.getParameter("descricao");
			
			String valorvenda = request.getParameter("valorvenda");
			valorvenda = valorvenda.replaceAll("\\,", ".");
			
			String valorcompra = request.getParameter("valorcompra");
			valorcompra = valorcompra.replaceAll("\\,", ".");
			
			String peso = request.getParameter("peso");
			peso=peso.replaceAll("\\,", ".");
			
			String saldo = request.getParameter("saldo");
			saldo = saldo.replaceAll("\\,", ".");
			
			
			produto.setDescricao(descricao);
			produto.setValorvenda(new Double(valorvenda));
			produto.setValorcompra(new Double(valorcompra));
			produto.setPeso(new Double(peso));
			produto.setSaldo(new Double(saldo));
			
			daoProdutos.altera(produto);
			RequestDispatcher rs = request.getRequestDispatcher("ProdutosSevlet?acao=ListarProdutos");
			rs.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
