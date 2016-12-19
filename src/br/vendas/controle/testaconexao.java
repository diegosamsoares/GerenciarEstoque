package br.vendas.controle;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.ConnectionEvent;

import br.vendas.modelo.DaoUsuario;
import br.vendas.modelo.DaoUsuario;
import br.vendas.modelo.Usuario;

public class testaconexao {

	public static void main(String[] args) throws SQLException {
	
		
Connection conexao = new ConnectionFactory().getConnection();
DaoUsuario DaoUsuario = new DaoUsuario(conexao);
String login = "diego";
String senha = "senha";

Usuario usuario=DaoUsuario.autentica(login, senha);

System.out.println( usuario.getLogin() + usuario.getSenha());
		
		
		
				
			}
		
		
		
		
		

	}


