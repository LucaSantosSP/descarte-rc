package br.com.reciclavel.descarterc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.reciclavel.descarterc.models.MaterialObj;

@Repository
public interface MaterialRepository extends JpaRepository<MaterialObj, Long>{

}