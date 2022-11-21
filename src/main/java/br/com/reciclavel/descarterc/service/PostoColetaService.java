package br.com.reciclavel.descarterc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reciclavel.descarterc.models.PostoColetaObj;
import br.com.reciclavel.descarterc.repository.PostoColetaRepository;

@Service
public class PostoColetaService implements ServiceInterface<PostoColetaObj>{

	@Autowired
	private PostoColetaRepository postoColetaRepository;
	
	@Override
	public PostoColetaObj create(PostoColetaObj obj) {
		postoColetaRepository.save(obj);
		return obj;
	}

	@Override
	public PostoColetaObj findById(Long id) {
		Optional<PostoColetaObj> obj = postoColetaRepository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public List<PostoColetaObj> findAll() {
		return postoColetaRepository.findAll();
	}

	@Override
	public boolean update(PostoColetaObj obj) {
		if (postoColetaRepository.existsById(obj.getId())) {
			postoColetaRepository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (postoColetaRepository.existsById(id)) {
			postoColetaRepository.deleteById(id);
			return true;			
		}
		return false;
	}

}
