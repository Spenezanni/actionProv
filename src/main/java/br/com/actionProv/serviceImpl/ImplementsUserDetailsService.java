package br.com.actionProv.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.actionProv.model.User;
import br.com.actionProv.repository.UserRepository;

@Service
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = Optional.ofNullable(this.userRepository.findByNome(username))
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
		return new User(user.getNome(), user.getSenha(), user.getAuthorities(), true, true, true, true);
	}
}
