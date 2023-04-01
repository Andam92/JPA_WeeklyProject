package model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TipoElemento", discriminatorType= DiscriminatorType.STRING)
@NamedQuery(name = "Elementi.FindAll", query = "SELECT e FROM Elemento e")
@NamedQuery(name = "Elementi.ricercaAnno", query = "SELECT e FROM Elemento e WHERE e.annoPubblicazione = :anno")
@NamedQuery(name = "Elementi.ricercaTitolo", query = "SELECT e FROM Elemento e WHERE e.titolo LIKE :titolo")


public abstract class Elemento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codiceISBN;
	private String titolo;
	private int annoPubblicazione;
	private int numeroPagine;
	
	//COSTRUTTORE GENERICO
	public Elemento() {		
	}
	
	
	public Elemento(Long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
		super();
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;		
	}
	
	//METODI
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}
	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}
	public int getNumeroPagine() {
		return numeroPagine;
	}
	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	public void setCodiceISBN(Long codiceISBN) {
		this.codiceISBN = codiceISBN;
	}

	public Long getCodiceISBN() {
		return codiceISBN;
	}
	
	@Override
	public String toString() {
		return "Elemento [codiceISBN=" + codiceISBN + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", numeroPagine=" + numeroPagine + "]";
	}
	
	
}
