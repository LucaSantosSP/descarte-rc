package br.com.reciclavel.descarterc.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JWTValidarFilter extends BasicAuthenticationFilter {

	public static final String HEADER_ATRIBUTO = "Authorization";
	public static final String HEADER_PREFIXO = "Bearer ";
	
	public JWTValidarFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(
			HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException{
		
		String atributo = request.getHeader(HEADER_ATRIBUTO);
		
		if (atributo == null) {
			filterChain.doFilter(request, response);
			return;
		}
	}

	
	
}
