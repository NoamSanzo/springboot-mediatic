package fr.iocean.application.adherent;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Embeddable
public class Cotisation {

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date debut;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fin;
	@NotNull
	private Double montant;
	
	public Date getDebut() {
		return debut;
	}
	public void setDebut(Date debut) {
		this.debut = debut;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
}
