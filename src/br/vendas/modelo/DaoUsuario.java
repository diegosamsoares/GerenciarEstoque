package br.vendas.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DaoUsuario {

	private Connection conexao;

	public DaoUsuario(Connection connection) {
		this.conexao = connection;
	}

	
	public Usuario autentica(String login, String senha) throws SQLException {
	String sql = "select * from usuario where login =? and senha = ?";
PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, senha);
			
			ResultSet rs = ps.executeQuery();
			Usuario usuario = null;;
				
			if (rs.next()){
				usuario= new Usuario();
				Long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String uLogin = rs.getString("login");
				String uSenha = rs.getString("senha");
				
				
				usuario.setId(id);
				usuario.setLogin(uLogin);
				usuario.setNome(nome);
				usuario.setSenha(uSenha);
				
			}
			rs.close();
			ps.close();
			return usuario;
		
			
			
	
		
	}
	
	
	
	}
	
		
	
