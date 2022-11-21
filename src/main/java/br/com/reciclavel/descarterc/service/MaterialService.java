package br.com.reciclavel.descarterc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reciclavel.descarterc.models.MaterialObj;
import br.com.reciclavel.descarterc.repository.MaterialRepository;

@Service
public class MaterialService implements ServiceInterface<MaterialObj> {

	@Autowired
	private MaterialRepository materialRepository;
	
	@Override
	public MaterialObj create(MaterialObj obj) {
		materialRepository.save(obj);
		return obj;
	}

	@Override
	public MaterialObj findById(Long id) {
		Optional<MaterialObj> obj = materialRepository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public List<MaterialObj> findAll() {
		return materialRepository.findAll();
	}

	@Override
	public boolean update(MaterialObj obj) {
		if (materialRepository.existsById(obj.getId())) {
			materialRepository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (materialRepository.existsById(id)) {
			materialRepository.deleteById(id);
			return true;			
		}
		return false;
	}

}
