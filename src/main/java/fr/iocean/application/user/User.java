package fr.iocean.application.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//import org.dta.IoEntity;
//import org.dta.authority.Authority;
import org.hibernate.validator.constraints.NotBlank;

import fr.iocean.application.IoEntity;

@Entity
@Table(name = "user_")
public class User implements IoEntity{
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String login;
	@NotBlank
	private String password;
	@NotBlank
	private String name;
	
//	@ManyToMany
//	private List<Authority> authorities;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return this.id;
	}
}
//	public List<Authority> getAuthorities() {
//		return authorities;
//	}
//
//	public void setAuthorities(List<Authority> authorities) {
//		this.authorities = authorities;
//	}



