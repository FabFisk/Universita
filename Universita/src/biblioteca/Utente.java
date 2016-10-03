package biblioteca;

import java.util.*;
import utility.Validate;

public class Utente implements Validate {
	
	protected String nome, cognome;
	protected List<Libro> prestiti;

	public Utente(){};
	public Utente(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		prestiti = new ArrayList<Libro>();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public List<Libro> getPrestiti() {
		return prestiti;
	}
	public void setPrestiti(List<Libro> prestiti) {
		this.prestiti = prestiti;
	}

	@Override
	public boolean isValid() {
		boolean token = false;
		if((!this.nome.isEmpty()&& this.nome!=null)
				&& (!this.cognome.isEmpty()&& this.cognome!=null)){
			token =true;
		}
		return token;
	}	
}
