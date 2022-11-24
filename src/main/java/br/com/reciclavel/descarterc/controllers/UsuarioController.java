package br.com.reciclavel.descarterc.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.reciclavel.descarterc.models.UsuarioObj;
import br.com.reciclavel.descarterc.repository.UsuarioRepository;
import br.com.reciclavel.descarterc.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController implements ControllerInterface<UsuarioObj>{

	@Autowired
	private UsuarioService usuarioService;
	

	private final UsuarioRepository repository;
	private final PasswordEncoder encoder;
	
	public UsuarioController(UsuarioRepository repository, PasswordEncoder encoder) {
		this.encoder = encoder;
		this.repository = repository;
	}

	
	@Override
	@GetMapping
	public ResponseEntity<List<UsuarioObj>> getAll() {
		return ResponseEntity.ok(usuarioService.findAll());
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> get(Long id) {
		UsuarioObj obj = usuarioService.findById(id);
		if (obj != null)
			return ResponseEntity.ok(obj);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/validarSenha")
	public ResponseEntity<Boolean> validarSenha(@RequestParam String txEmail, @RequestParam String cdSenha) {
		
		Optional<UsuarioObj> optUser = repository.findByTxEmail(txEmail);
		if (optUser.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
		}
		
		boolean valid = false;
		
		UsuarioObj usuario = optUser.get();
		valid = encoder.matches(cdSenha, usuario.getCdSenha());
		
		HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		
		return ResponseEntity.status(status).body(valid);
	}

	@Override
	@PostMapping
	public ResponseEntity<UsuarioObj> post(UsuarioObj obj) {
		obj.setCdSenha(encoder.encode(obj.getCdSenha()));
		usuarioService.create(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(location).body(obj);
	}

	@Override
	@PutMapping
	public ResponseEntity<?> put(UsuarioObj obj) {
		if (usuarioService.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(Long id) {
		if (usuarioService.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
