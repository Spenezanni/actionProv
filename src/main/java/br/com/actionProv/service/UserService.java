package br.com.actionProv.service;

import java.util.List;

import br.com.actionProv.model.User;


public interface UserService {
	
	 public User salvar(User usuario); 
	    
	    public List<User> buscarListaDeUsers();
	    
	    public void deletarUser(Long id);
	    
	    public void verificarIdUser(Long id);

}
