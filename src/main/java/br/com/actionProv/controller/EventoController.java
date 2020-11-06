package br.com.actionProv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.actionProv.model.Evento;
import br.com.actionProv.model.User;
import br.com.actionProv.service.EventoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private EventoService eventoService;
	
	@PostMapping(path = "/admin")
    @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> salvarEvento(@RequestBody Evento evento) {
		return new ResponseEntity<>(eventoService.salvar(evento), HttpStatus.CREATED);
	}
	
	@GetMapping(path = "")
	@PreAuthorize("hasRole('USER')")
	public List<Evento> listTodosEventos() {
		return this.eventoService.buscarListaDeEventos();
	}
	
	@DeleteMapping(path = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> deleleUser(@PathVariable Long id) {
		this.eventoService.verificarIdEvento(id);
		this.eventoService.deletarEvento(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
