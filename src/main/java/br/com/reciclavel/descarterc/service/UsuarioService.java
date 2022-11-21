package br.com.reciclavel.descarterc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reciclavel.descarterc.models.UsuarioObj;
import br.com.reciclavel.descarterc.repository.UsuarioRepository;

@Service
public class UsuarioService implements ServiceInterface<UsuarioObj>{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UsuarioObj create(UsuarioObj obj) {
		usuarioRepository.save(obj);
		return obj;
	}

	@Override
	public UsuarioObj findById(Long id) {
		Optional<UsuarioObj> obj = usuarioRepository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public List<UsuarioObj> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public boolean update(UsuarioObj obj) {
		if (usuarioRepository.existsById(obj.getId())) {
			usuarioRepository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (usuarioRepository.existsById(id)) {
			usuarioRepository.deleteById(id);
			return true;			
		}
		return false;
	}

}
