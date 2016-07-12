package fr.iocean.application.authorization;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import fr.iocean.application.IoEntity;

@Entity
@Table(name= "authorization_")
public class Authorization implements IoEntity{
	
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	Long id;

	@NotBlank
	String code;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
//	@Override
//	public String getAuthority() {
//		return this.code;
//	}
}