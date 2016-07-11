package fr.iocean.application.adherent;

import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class Cotisation {

	private Date debut;
	private Date fin;
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
