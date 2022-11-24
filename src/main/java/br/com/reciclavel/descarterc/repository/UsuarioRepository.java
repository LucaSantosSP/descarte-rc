package br.com.reciclavel.descarterc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reciclavel.descarterc.models.UsuarioObj;

public interface UsuarioRepository extends JpaRepository<UsuarioObj, Long>{

	public Optional<UsuarioObj> findByTxEmail(String txEmail);
}
