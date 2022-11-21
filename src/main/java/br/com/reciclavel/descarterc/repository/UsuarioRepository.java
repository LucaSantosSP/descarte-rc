package br.com.reciclavel.descarterc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reciclavel.descarterc.models.UsuarioObj;

public interface UsuarioRepository extends JpaRepository<UsuarioObj, Long>{

}
