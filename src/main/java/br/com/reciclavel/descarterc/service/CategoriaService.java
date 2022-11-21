package br.com.reciclavel.descarterc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reciclavel.descarterc.models.CategoriaObj;
import br.com.reciclavel.descarterc.repository.CategoriaRepository;

@Service
public class CategoriaService implements ServiceInterface<CategoriaObj>{

	@Autowired
	private CategoriaRepository CategoriaRepository;
	
	@Override
	public CategoriaObj create(CategoriaObj obj) {
		CategoriaRepository.save(obj);
		return obj;
	}

	@Override
	public CategoriaObj findById(Long id) {
		Optional<CategoriaObj> obj = CategoriaRepository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public List<CategoriaObj> findAll() {
		return CategoriaRepository.findAll();
	}

	@Override
	public boolean update(CategoriaObj obj) {
		if (CategoriaRepository.existsById(obj.getId())) {
			CategoriaRepository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (CategoriaRepository.existsById(id)) {
			CategoriaRepository.deleteById(id);
			return true;			
		}
		return false;
	}


}
