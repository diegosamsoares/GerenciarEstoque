package br.vendas.filtros;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.vendas.controle.ConnectionFactory;

@WebFilter(filterName="FiltroConexao",urlPatterns="/ProdutosSevlet")
public class FiltroConexao implements Filter {

    public FiltroConexao() {
    }
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	  Connection conexao = new ConnectionFactory().getConnection();
	  request.setAttribute("conexao", conexao);
		
		
		chain.doFilter(request, response);
		try {
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException("erro ao fecha conexao");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
