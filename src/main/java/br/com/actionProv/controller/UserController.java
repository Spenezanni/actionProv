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

import br.com.actionProv.model.User;
import br.com.actionProv.service.UserService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/actionProv")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/admin/user")
    @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> salvarUser(@RequestBody User User) {
		return new ResponseEntity<>(userService.salvar(User), HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/protected/user")
	@PreAuthorize("hasRole('USER')")
	public List<User> listTodosUsers() {
		return this.userService.buscarListaDeUsers();
	}
	
	@DeleteMapping(path = "/admin/user/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> deleleUser(@PathVariable Long id) {
		this.userService.verificarIdUser(id);
		this.userService.deletarUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

}
