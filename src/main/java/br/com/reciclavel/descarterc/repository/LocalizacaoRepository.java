package br.com.reciclavel.descarterc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reciclavel.descarterc.models.LocalizacaoObj;

public interface LocalizacaoRepository extends JpaRepository<LocalizacaoObj, Long>{

}
