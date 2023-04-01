package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "libri")
@NamedQuery(name = "Elementi.ricercaAuore", query = "SELECT l FROM Libro l WHERE l.autore = :autore")
public class Libro extends Elemento{
	
	private String autore;
	
	@Enumerated(EnumType.STRING)
	private Genere genere;
	
//COSTRUTTORI
	public Libro() {
		
	}
	
	public Libro(Long codiceISBN, String titolo,  int annoPubblicazione, int numeroPagine) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
	}

	
	public Libro(Long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore,
			Genere genere) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}


	public String getAutore() {
		return autore;
	}


	public void setAutore(String autore) {
		this.autore = autore;
	}


	public Genere getGenere() {
		return genere;
	}


	public void setGenere(Genere genere) {
		this.genere = genere;
	}


	@Override
	public String toString() {
		return "Libro [Autore=" + autore + ", Genere=" + genere + ", Titolo=" + getTitolo()
				+ ", Anno di pubblicazione=" + getAnnoPubblicazione() + ", Numero diPagine=" + getNumeroPagine()
				+ ", Codice ISBN=" + getCodiceISBN();
	}
	
	
}

