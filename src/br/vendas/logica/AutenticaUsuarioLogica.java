package br.vendas.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.vendas.modelo.DaoUsuario;
import br.vendas.modelo.Usuario;
import sun.java2d.pipe.RenderQueue;

public class AutenticaUsuarioLogica implements Logica {

	

	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		
		Connection connection = (Connection) request.getAttribute("conexao");		
		DaoUsuario daoUsuario = new DaoUsuario(connection);
		Usuario usuarioautenticado= null;
		usuarioautenticado=daoUsuario.autentica(login, senha);
		
		
		if (usuarioautenticado!=null ) {
	
			RequestDispatcher rs = request.getRequestDispatcher("/index.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuarioautenticado);
			rs.forward(request, response);
			
		}else{
			request.setAttribute("usuarioLogado", null);
			RequestDispatcher rs = request.getRequestDispatcher("/login.jsp");
			System.out.println("nao encontrado");
			rs.forward(request, response);
		}
		
		
		
		
	}

}
