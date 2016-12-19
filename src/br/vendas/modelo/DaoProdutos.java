package br.vendas.modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.print.attribute.standard.PDLOverrideSupported;

import org.omg.PortableServer.POA;

import br.vendas.controle.ConnectionFactory;

public class DaoProdutos {

	private Connection conexao;

	public DaoProdutos(Connection connection) {
		conexao = new ConnectionFactory().getConnection();
	}

	public void adiciona(Produto produto) {

		try {
			String sql = ("insert into cad_produtos(descricao,peso,valorcompra,valorvenda,saldo)"
					+ "values(?,?,?,?,?)");

			java.sql.PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, produto.getDescricao());		
			
				
			
			ps.setDouble(2, produto.getPeso());
			ps.setDouble(3, produto.getValorcompra());
			ps.setDouble(4, produto.getValorvenda());
			ps.setDouble(5, produto.getSaldo());
			ps.execute();
			ps.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println("erro ao gravar");
		}

	}

	public List<Produto> Listar() {

		try {
			List<Produto> produtos = new ArrayList<Produto>();
			String sql = ("select * from cad_produtos");
			PreparedStatement pStatement = conexao.prepareStatement(sql);
			Produto produto = null;

			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				String descricao = resultSet.getString("descricao");
				double valorcompra = resultSet.getDouble("valorcompra");
				double valorvenda = resultSet.getDouble("valorvenda");
				double saldo = resultSet.getDouble("saldo");
				double peso = resultSet.getDouble("peso");
				Long id = resultSet.getLong("id");
				produto = new Produto();

				produto.setId(id);
				produto.setDescricao(descricao);
				produto.setValorcompra(valorcompra);
				produto.setValorvenda(valorvenda);
				produto.setSaldo(saldo);
				produto.setPeso(peso);

				produtos.add(produto);

			}

			resultSet.close();
			pStatement.close();
			return produtos;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	
	
	
	
	public List<Produto> Pesquisar(String nome) {

		try {
			List<Produto> produtos = new ArrayList<Produto>();
			String sql = ("select * from cad_produtos where descricao like '" + nome
				+ "%' ");
			
			PreparedStatement pStatement = conexao.prepareStatement(sql);
			
			Produto produto = null;
			
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				String descricao = resultSet.getString("descricao");
				double valorcompra = resultSet.getDouble("valorcompra");
				double valorvenda = resultSet.getDouble("valorvenda");
				double saldo = resultSet.getDouble("saldo");
				double peso = resultSet.getDouble("peso");
				Long id = resultSet.getLong("id");
				produto = new Produto();

				produto.setId(id);
				produto.setDescricao(descricao);
				produto.setValorcompra(valorcompra);
				produto.setValorvenda(valorvenda);
				produto.setSaldo(saldo);
				produto.setPeso(peso);

				produtos.add(produto);

			}

			resultSet.close();
			pStatement.close();
			return produtos;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	
	
	
	
	
	 public void  Excluir(Produto produto){
		 String sql = ("delete from cad_produtos where id=?");
		try {			
			PreparedStatement pStatement = conexao.prepareStatement(sql);
			pStatement.setLong(1, produto.getId());
			pStatement.execute();
			pStatement.close();	
			
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		}
		   
     }
	
	  
	public Produto altera(Produto produto){
		 
		 try {
			 String sql =("update cad_produtos set descricao=?,valorvenda=?,valorcompra=?,peso=?,saldo=? "
			 		+ "  where id=?");
			 PreparedStatement ps  = conexao.prepareStatement(sql);
			 ps.setString(1, produto.getDescricao());
			 ps.setDouble(2, produto.getValorvenda());
			 ps.setDouble(3, produto.getValorcompra());
			 ps.setDouble(4, produto.getPeso());
			 ps.setDouble(5, produto.getSaldo());
			 ps.setLong(6, produto.getId());
			 ps.execute();
			 ps.close();
			 
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		 return null;
	 }
	 
	 
	public Produto   Getid (long id) {
	    	 try {
	    		 String sql = ("select * from cad_produtos where id =?");
		    	  PreparedStatement ps = conexao.prepareStatement(sql);
		    	  ps.setLong(1, id);   	  
		    	  Produto produto = null;
		    	  ResultSet rSet = ps.executeQuery();
		    	  if(rSet.next()){
		    		  Long idprod = rSet.getLong("id");
			    	  String descricao = rSet.getString("descricao");
			    	  double valorcompra=rSet.getDouble("valorcompra");
			    	  double valorvenda=rSet.getDouble("valorvenda");
			    	  double peso=rSet.getDouble("peso");
			    	  double saldo=rSet.getDouble("saldo");
			    	 produto = new Produto();
			    	  produto.setDescricao(descricao);
			    	  produto.setId(idprod);
			    	  produto.setValorcompra(valorcompra);
			    	  produto.setValorvenda(valorvenda);
			    	  produto.setPeso(peso);
			    	  produto.setSaldo(saldo); 	  
		    	  }
		    	 
		    	 
		    	  rSet.close();
		    	  ps.close();
		    	
		    	  return produto;
				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	      }
	        
	       

}
