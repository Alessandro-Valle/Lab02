package it.polito.tdp.dizionario.model;

import java.util.LinkedList;
import java.util.List;

import javax.naming.NameNotFoundException;


public class Dictionary {
	
	private List<Word> words;

	public Dictionary() {
		this.words = new LinkedList<Word>();
	}
	
	public String traduci(String s) throws NameNotFoundException {
		
		String[] var = s.toLowerCase().split(" ");
			
//		Controlli su numero parole inserite
		if(var.length != 1 && var.length != 2)
    		return "ERRORE NELL'INSERIMENTO DEI DATI";
		for(int i=0; i<var.length; i++)
			if(!var[i].matches("[a-z]+"))
				return "INSERIRE SOLO CARATTERI ALFABETICI.";
		
//		Lunghezza = 1, quindi restituisce tutte le traduzioni della parola aliena data in input
		if(var.length == 1)
			return this.cercaTraduzione(var[0]);
		
//		Lunghezza = 2 quindi se la parola aliena ha già una traduzione, glie ne si aggiunge una nuova, mentre
//		se non esiste ancora una traduzione viene creata una nuova voce nel dizionario
		if(this.esisteParola(var[0]))
				this.cercaParola(var[0]).aggiungiTraduzione(var[1]);
		
		else
			this.words.add(new Word(var[0],var[1]));
		
		return "Aggiunta traduzione: " + this.cercaParola(var[0]).toString();
	}
	
	/**
	 * Cerca la parola, data in input, nel dizionario
	 * @param s
	 * @return tutte le traduzioni della parola, altrimenti dice che non ne esistono
	 */
	public String cercaTraduzione(String s) {
		
		for(Word w : this.words) {
			if(w.getParola().equals(s))
				return "Traduzioni di " + s + ": " + w.getTraduzione().toString();
		}
		return "Non esiste traduzione nel dizionario";
	}
	
	
//	Elimnina tutti i dati nel dizionario
	public void pulisciDizionario() {
		this.words.clear();
	}
	
	/**
	 * Controlla se nella lista esiste già la parola aliena data in input
	 * @param s = parola aliena
	 * @return vero se esiste, falso se non esiste
	 */
	public boolean esisteParola(String s) {
		for(Word w : this.words)
			if(w.getParola().equals(s))
				return true;
		return false;
	}
	
	/**
	 * Cerca la parola s nel dizionario
	 * @param s = parola aliena inserita in input
	 * @return Word che equivale alla parola s
	 * @throws NameNotFoundException  se non trova nessuna parola (Impossibile)
	 */
	public Word cercaParola(String s) throws NameNotFoundException {
		for(Word w : this.words)
			if(w.getParola().equals(s))
				return w;
		throw new NameNotFoundException();
	}
	
}
