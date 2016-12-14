
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.spi.protocol.RequestDispatcherRegistry;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NamedMethodGenerator;

import sun.awt.datatransfer.DataTransferer.ReencodingInputStream;

@WebServlet("/ProdutosSevlet")
public class ProdutosSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		if (acao.equals("AdicionarProduto")) {

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

			DaoProdutos dao = new DaoProdutos();
			dao.adiciona(produto);

			PrintWriter out = response.getWriter();

			out.println("<SCRIPT>" + "alert('GRAVADO COM SUCESSO');" + " window.location.href='CadastraProdutos.jsp' "
					+ "</SCRIPT> ");
		}

		if (acao.equals("ListarProdutos")) {
			DaoProdutos daoProdutos = new DaoProdutos();
			List<Produto> lista = daoProdutos.Listar();
			request.setAttribute("lista", lista);

			RequestDispatcher rd = request.getRequestDispatcher("/ListaProdutos.jsp");
			rd.forward(request, response);

		}
		
		if (acao.equals("ExcluirProdutos")){
			
		
			try {
				DaoProdutos daoProdutos = new DaoProdutos();
	daoProdutos.Excluir(daoProdutos.Getid(new Long(request.getParameter("id"))));	
			 
				
				RequestDispatcher requestDispatcher =	request.getRequestDispatcher("ProdutosSevlet?acao=ListarProdutos");
			   requestDispatcher.forward(request, response);
			} catch (Exception e) {
				
			}
			
		}
		
		if (acao.equals("PreencheProdutos")){
			DaoProdutos daoProdutos = new DaoProdutos();
			Produto produto = null;
		produto =	daoProdutos.Getid(new Long(request.getParameter("id")));
			request.setAttribute("produto", produto);
			
			
			RequestDispatcher rs = request.getRequestDispatcher("/AlteraProdutos.jsp");
			rs.forward(request, response);
				
				
			}

		
		if (acao.equals("AlteraProdutos")) {
			
			try {
				DaoProdutos daoProdutos = new DaoProdutos();
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

}
