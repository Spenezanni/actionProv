package br.com.actionProv.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name = "ROLE")
public class Role implements GrantedAuthority {
	
	@Id
	private String nomeRole;
	
	@ManyToMany(mappedBy = "roles")
	private List<User> user;
	

	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String getAuthority() {
		return nomeRole;
	}

}
