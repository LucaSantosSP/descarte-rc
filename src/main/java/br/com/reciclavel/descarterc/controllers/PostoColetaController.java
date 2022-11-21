package br.com.reciclavel.descarterc.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.reciclavel.descarterc.models.PostoColetaObj;
import br.com.reciclavel.descarterc.service.PostoColetaService;

@RestController
@RequestMapping("/postocoleta")
public class PostoColetaController implements ControllerInterface<PostoColetaObj>{

	@Autowired
	private PostoColetaService postoColetaService;
	
	@Override
	@GetMapping
	public ResponseEntity<List<PostoColetaObj>> getAll() {
		return ResponseEntity.ok(postoColetaService.findAll());
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> get(Long id) {
		PostoColetaObj obj = postoColetaService.findById(id);
		if (obj != null)
			return ResponseEntity.ok(obj);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@PostMapping
	public ResponseEntity<PostoColetaObj> post(PostoColetaObj obj) {
		postoColetaService.create(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(location).body(obj);
	}

	@Override
	@PutMapping
	public ResponseEntity<?> put(PostoColetaObj obj) {
		if (postoColetaService.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(Long id) {
		if (postoColetaService.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
