package main;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Elemento;
import model.Genere;
import model.Libro;
import model.Periodicità;
import model.Rivista;
import model.Utente;

public class Catalogo {
	
	static EntityManagerFactory emf =Persistence.createEntityManagerFactory("JPA_WeeklyProject");

    // l'oggetto che mi servirà per comunicare col db
    static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {
		
		Libro libro1 = new Libro();
		libro1.setAnnoPubblicazione(1999);
		libro1.setAutore("B. Cornwell");
		libro1.setGenere(Genere.STORICO);
		libro1.setNumeroPagine(564);
		libro1.setTitolo("I re sassoni");
		
		Libro libro2 = new Libro();
		libro2.setAnnoPubblicazione(2022);
		libro2.setAutore("B. Cornwell");
		libro2.setGenere(Genere.STORICO);
		libro2.setNumeroPagine(357);
		libro2.setTitolo("Re Artù");
		
		Libro libro3 = new Libro();
		libro3.setAnnoPubblicazione(2022);
		libro3.setAutore("Stefano");
		libro3.setGenere(Genere.STORICO);
		libro3.setNumeroPagine(357);
		libro3.setTitolo("Le 9 meraviglie di Stefano");
		
		Rivista rivista1 = new Rivista();
		rivista1.setAnnoPubblicazione(2022);
		rivista1.setNumeroPagine(34);
		rivista1.setTitolo("Kung fu magazine");
		rivista1.setPeriodicità(Periodicità.SEMESTRALE);
		
		Rivista rivista2 = new Rivista();
		rivista2.setAnnoPubblicazione(2023);
		rivista2.setNumeroPagine(25);
		rivista2.setTitolo("Come educare un cane");
		rivista2.setPeriodicità(Periodicità.MENSILE);
		
		
		Utente utente1 = new Utente();
		utente1.setNome("Antonio");
		utente1.setCognome("D'Amico");
		utente1.setDataDiNascita(LocalDate.of(1992, 03, 12));
		
		
		//LIBRI & RIVISTE
		//aggiungiLibro(libro3);
		//aggiungiLibro(rivista1);
		//aggiungiLibro(rivista2);
			
		//UTENTI
		//aggiungiUtente(utente1);
		
		//VISUALIZZA TUTTI GLI ELEMENTI
		List<Elemento> catalogo = recuperaCatalogo();
		catalogo.forEach(e -> System.out.println(e.toString()));
		
		//CANCELLA UN ELEMENTO IN BASE AL CODICE ISBN
		//rimuoviElemento(3l);
		
		//RICERCA PER CODICE
		//ricercaPerCodice(2l);
		
		//RICERCA PER ANNO DI PUBBLICAZIONE
		//ricercaPerAnno(1999);
		
		//RICERCA PER AUTORE
		//ricercaPerAutore("sassoni");
		
		//RICERCA PER TITOLO
		//ricercaPerTitolo("cane");
	
	}
	
	public static void aggiungiLibro(Elemento e) {
		try {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println(e.getTitolo() + " è stato aggiunto al catalogo!");
		}
		catch (Exception exception) {
			exception.getMessage();
		} finally {
			em.close();
		}
	}
	
	public static void rimuoviElemento(Long isbn) {
        try {
            em.getTransaction().begin();
            Query querySelect = em.createQuery("DELETE Elemento e WHERE e.codiceISBN = :id");
            querySelect.setParameter("id", isbn);
            querySelect.executeUpdate();
            em.getTransaction().commit();
            System.out.println("Elemento rimosso per codice: " + isbn);
        } catch (Exception e) {
            e.getMessage();
        } finally {
            em.close();
        }
    }
		
	public static void aggiungiUtente(Utente u) {
			try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			System.out.println(u.getNome() + " è stato aggiunto agli utenti!");
			}
			catch (Exception exception) {
				exception.getMessage();
			} finally {
				em.close();
			}
	}
	
	public static List<Elemento> recuperaCatalogo(){
		em.getTransaction().begin();
		Query q = em.createNamedQuery("Elementi.FindAll");
		List<Elemento> catalogo = q.getResultList();
		em.getTransaction().commit();
		return catalogo;		
	}
	
	public static Elemento ricercaPerCodice(Long isbn){
		try {
		em.getTransaction().begin();
		Query qSearch = em.createQuery("SELECT e FROM Elemento e WHERE e.codiceISBN = :id");
		qSearch.setParameter("id", isbn);
		Elemento results = (Elemento) qSearch.getSingleResult();
		em.getTransaction().commit();
		System.out.println("Risultati della ricerca: " + results.toString());
		return results;
		
		} catch (Exception exception) {
			
		} finally {
			em.close();
		}
		
		return null;
	}
	
	public static List<Elemento> ricercaPerAnno(int anno){
		try {
			em.getTransaction().begin();
			Query qSearch = em.createNamedQuery("Elementi.ricercaAnno");
			qSearch.setParameter("anno", anno);
			List<Elemento> results = qSearch.getResultList();
			em.getTransaction().commit();
			System.out.println("Risultati della ricerca: " + results.toString());
			return results;
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			em.close();
		}
		return null;
	}
	
	public static List<Elemento> ricercaPerAutore(String autore){
		try {
			em.getTransaction().begin();
			Query qSearch = em.createNamedQuery("Elementi.ricercaAutore");
			qSearch.setParameter("autore", autore);
			List<Elemento> results = qSearch.getResultList();
			em.getTransaction().commit();
			System.out.println("Risultati della ricerca: " + results.toString());
			return results;
			
		} catch (Exception exception) {
			// TODO: handle exception
		} finally {
			em.close();
		}
		return null;
	}
	
	public static List<Elemento> ricercaPerTitolo(String titolo) {
		try {
			em.getTransaction().begin();
			Query qSearch = em.createNamedQuery("Elementi.ricercaTitolo");
			qSearch.setParameter("titolo", "%" + titolo + "%");
			List<Elemento> results = qSearch.getResultList();
			em.getTransaction().commit();
			System.out.println("Risultati della ricerca: " + results.toString());
			return results;
			
		} catch (Exception exception) {
			// TODO: handle exception
		} finally {
			em.close();
		}
		return null;
	}

}
