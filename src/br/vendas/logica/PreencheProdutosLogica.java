package br.vendas.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jndi.cosnaming.CNCtx;

import br.vendas.controle.ConnectionFactory;
import br.vendas.modelo.DaoProdutos;
import br.vendas.modelo.Produto;

public class PreencheProdutosLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection connection = (Connection) request.getAttribute("conexao");		
		DaoProdutos daoProdutos = new DaoProdutos(connection);
		Produto produto = null;
	produto =	daoProdutos.Getid(new Long(request.getParameter("id")));
		request.setAttribute("produto", produto);
		
		
		RequestDispatcher rs = request.getRequestDispatcher("/AlteraProdutos.jsp");
		rs.forward(request, response);
			
			
		}
		
	}

	

