package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "rivista")
public class Rivista extends Elemento{
	
	@Enumerated(EnumType.STRING)
	private Periodicità periodicità;
	
	
//COSTRUTTORI
	public Rivista() {
		
	}
	
	public Rivista(Long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.periodicità = periodicità;
	}
	
	


//GETTERS & SETTERS
	
	public Periodicità getPeriodicità() {
		return periodicità;
	}

	public void setPeriodicità(Periodicità periodicità) {
		this.periodicità = periodicità;
	}



	@Override
	public String toString() {
		return "Rivista [Titolo=" + getTitolo()
				+ ", Anno di pubblicazione=" + getAnnoPubblicazione() + ", Numero di Pagine=" + getNumeroPagine()
				+ ", Codice ISBN=" + getCodiceISBN() + ", Periodicità=" + getPeriodicità();
	}
	
}
