package br.com.actionProv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.actionProv.error.ResourceNotFoundException;
import br.com.actionProv.model.User;
import br.com.actionProv.repository.UserRepository;
import br.com.actionProv.service.UserService;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserRepository UserRepository;

	@Override
	public User salvar(User User) {
		return UserRepository.save(User);
	}

	@Override
	public List<User> buscarListaDeUsers() {
		return UserRepository.findAll();
	}

	@Override
	public void verificarIdUser(Long id) {
		if (this.UserRepository.findById(id) == null) {
			throw new ResourceNotFoundException("Usuário não encontrado" + " " + id);
		}

	}

	@Override
	public void deletarUser(Long id) {
		this.UserRepository.deleteById(id);
	}

}
