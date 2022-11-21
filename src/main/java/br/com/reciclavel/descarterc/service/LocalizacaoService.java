package br.com.reciclavel.descarterc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reciclavel.descarterc.models.LocalizacaoObj;
import br.com.reciclavel.descarterc.repository.LocalizacaoRepository;

@Service
public class LocalizacaoService implements ServiceInterface<LocalizacaoObj>{

	@Autowired
	private LocalizacaoRepository localizacaoRepository;

	@Override
	public LocalizacaoObj create(LocalizacaoObj obj) {
		localizacaoRepository.save(obj);
		return obj;
	}

	@Override
	public LocalizacaoObj findById(Long id) {
		Optional<LocalizacaoObj> obj = localizacaoRepository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public List<LocalizacaoObj> findAll() {
		return localizacaoRepository.findAll();
	}

	@Override
	public boolean update(LocalizacaoObj obj) {
		if (localizacaoRepository.existsById(obj.getId())) {
			localizacaoRepository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (localizacaoRepository.existsById(id)) {
			localizacaoRepository.deleteById(id);
			return true;			
		}
		return false;
	}
	


}
