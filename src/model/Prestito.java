package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prestiti")
public class Prestito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Utente utente;
	
	@ManyToOne
	private Elemento elementoPrestato;
	
	private LocalDate inizioPrestito;
	private LocalDate dataRestituzionePrevista;  // a 30 gg dalla data di inizio prestito
	private LocalDate dataRestituzioneEffettiva;
	
	//GETTER & SETTER
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Elemento getElementoPrestato() {
		return elementoPrestato;
	}
	public void setElementoPrestato(Elemento elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
	}
	public LocalDate getInizioPrestito() {
		return inizioPrestito;
	}
	public void setInizioPrestito(LocalDate inizioPrestito) {
		this.inizioPrestito = inizioPrestito;
	}
	public LocalDate getDataRestituzionePrevista() {
		return dataRestituzionePrevista;
	}
	public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}
	public LocalDate getDataRestituzioneEffettiva() {
		return dataRestituzioneEffettiva;
	}
	public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}
	
	//COSTRUTTORI
	public Prestito() {
		super();
	}
	
	public Prestito(Utente utente, Elemento elementoPrestato, LocalDate inizioPrestito,
			LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
		super();
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.inizioPrestito = inizioPrestito;
		this.dataRestituzionePrevista = dataRestituzionePrevista;
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}
	
	
}
