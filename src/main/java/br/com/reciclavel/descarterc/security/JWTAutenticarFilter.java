package br.com.reciclavel.descarterc.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.reciclavel.descarterc.models.UsuarioObj;
import br.com.reciclavel.descarterc.models.data.DetalhesUsuarioData;

public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {
	
	public static final int TOKEN_EXPIRACAO = 600_000;
	public static final String TOKEN_SENHA = "525b0df1-0635-4410-ba9e-4a2e9c3162b3";

	private final AuthenticationManager authenticationManager;

	public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
			try {
				UsuarioObj usuario = new ObjectMapper().
						readValue(request.getInputStream(), UsuarioObj.class);
				
				return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getTxEmail(), usuario.getCdSenha(), new ArrayList<>()));
			} catch (IOException e) {
				throw new RuntimeException("Falaha ao autenticar o usuário", e);
			}
	}
	
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		DetalhesUsuarioData usuarioData = (DetalhesUsuarioData) authResult.getPrincipal();
		
		String token = JWT.create().withSubject(usuarioData.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO)).sign(Algorithm.HMAC512(TOKEN_SENHA));
		
		response.getWriter().write(token);
		response.getWriter().flush();
	}

}
