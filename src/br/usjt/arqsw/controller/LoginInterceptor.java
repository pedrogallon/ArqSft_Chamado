package br.usjt.arqsw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * @author RA816124368 Pedro Gallon Alves CCP3AN-MCA1
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {
		String uri = request.getRequestURI();
		if (uri.endsWith("login") || uri.endsWith("usuario_logar") || uri.contains("css") || uri.contains("js") || uri.contains("img")
				) {
			
			return true;
		}
		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		response.sendRedirect("login");
		return false;
	}

}
