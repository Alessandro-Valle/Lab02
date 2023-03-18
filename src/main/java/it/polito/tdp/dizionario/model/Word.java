package it.polito.tdp.dizionario.model;

import java.util.LinkedList;
import java.util.List;

public class Word {

	private String parola;
	private List<String> traduzione;   	
	
	public Word(String parola, String traduzione) {
		super();
		this.parola = parola;
		this.traduzione = new LinkedList<String>();
		this.traduzione.add(traduzione);
	}

	public String getParola() {
		return parola;
	}

	public List<String> getTraduzione() {
		return this.traduzione;
	}

	@Override
	public String toString() {
		boolean a = false;
		String res = parola + "  =  ";
		for(String s : this.traduzione) {
			if(a)
				res += ", " + s;
			else
				res += s;
			a = true;
		}
		return res;
	}
	
	public void aggiungiTraduzione(String s) {
		this.traduzione.add(s);
	}
	
}
