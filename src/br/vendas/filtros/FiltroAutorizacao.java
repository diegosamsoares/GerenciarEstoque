package br.vendas.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.sun.jndi.toolkit.url.Uri;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import br.vendas.modelo.Usuario;


@WebFilter(filterName="FiltroAltorizacao" , urlPatterns="/*")
public class FiltroAutorizacao implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String acao = request.getParameter("acao");
	if (acao==null) {
		acao="";
	}
		
		
		if ( uri.equals("login.jsp") ||acao.endsWith("AutenticaUsuario")) {
			req.getSession().setAttribute("usuarioLogado", null);
			chain.doFilter(request, response);	
		}else {
			Usuario usuario= (Usuario) req.getSession().getAttribute("usuarioLogado");
			if (usuario!=null ) {
				chain.doFilter(request, response);	
			}else {
			
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		
				dispatcher.forward(request, response);
			}
			
		
		}
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
