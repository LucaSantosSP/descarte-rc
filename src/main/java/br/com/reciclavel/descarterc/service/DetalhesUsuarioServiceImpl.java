package br.com.reciclavel.descarterc.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.reciclavel.descarterc.models.UsuarioObj;
import br.com.reciclavel.descarterc.models.data.DetalhesUsuarioData;
import br.com.reciclavel.descarterc.repository.UsuarioRepository;

@Component
public class DetalhesUsuarioServiceImpl implements UserDetailsService{

	private final UsuarioRepository repository;
	
	public DetalhesUsuarioServiceImpl(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String txEmail) throws UsernameNotFoundException {
		Optional<UsuarioObj> usuario = repository.findByTxEmail(txEmail);
		if (usuario.isEmpty()) {
			throw new UsernameNotFoundException("Email de usuário [" + txEmail + "] não encontrado");
		}
		
		return new DetalhesUsuarioData(usuario);
	}

}
