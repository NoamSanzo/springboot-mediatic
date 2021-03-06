package fr.iocean.application.adherent;

import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import fr.iocean.application.IoEntity;


@Entity
@Table(name = "adherent")
public class Adherent implements IoEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@NotBlank
	private String nom;
	
	@NotBlank
	private String prenom;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date date_naissance;
	
	@NotBlank
	private String email;
	
	@NotNull
	@Embedded
	@Valid
	private Adresse adresse;
	
	@NotNull
	@Valid
	@Embedded
	private Cotisation cotisation;
	
	
	private int age;
	

	private int nombre_media;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse	 adresse) {
		this.adresse = adresse;
	}
	public Cotisation getCotisation() {
		return cotisation;
	}
	public void setCotisation(Cotisation cotisation) {
		this.cotisation = cotisation;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNombre_media() {
		return nombre_media;
	}
	public void setNombre_media(int nombre_media) {
		this.nombre_media = nombre_media;
	}
	
	

}
