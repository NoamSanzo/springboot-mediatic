package fr.iocean.application.adherent;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Embeddable
public class Adresse {
	
	@NotBlank
	private String ligne1;
	
	
	private String ligne2;
	
	@NotBlank
	private String codepostal;
	
	@NotBlank
	private String ville;

	public String getLigne1() {
		return ligne1;
	}

	public void setLigne1(String ligne1) {
		this.ligne1 = ligne1;
	}

	public String getLigne2() {
		return ligne2;
	}

	public void setLigne2(String ligne2) {
		this.ligne2 = ligne2;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
