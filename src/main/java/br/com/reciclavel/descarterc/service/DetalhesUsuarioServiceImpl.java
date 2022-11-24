package br.com.reciclavel.descarterc.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.reciclavel.descarterc.models.UsuarioObj;
import br.com.reciclavel.descarterc.models.data.DetalhesUsuarioData;
import br.com.reciclavel.descarterc.repository.UsuarioRepository;

public class DetalhesUsuarioServiceImpl implements UserDetailsService{

	private final UsuarioRepository repository;
	
	public DetalhesUsuarioServiceImpl(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String txTmail) throws UsernameNotFoundException {
		Optional<UsuarioObj> usuario = repository.findByTxEmail(txTmail);
		if (usuario.isEmpty()) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		return new DetalhesUsuarioData(usuario);
	}

}
