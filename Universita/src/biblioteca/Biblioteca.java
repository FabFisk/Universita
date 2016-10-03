package biblioteca;

import java.util.*;
import utility.*;

public class Biblioteca implements Validate {
	
	private String nome;
	private List<Libro> libri = new ArrayList<Libro>();
	private List<Utente> utenti = new ArrayList<Utente>();
	private List<Prestito> prestiti = new ArrayList<Prestito>();

	public Biblioteca (){}
	public Biblioteca(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Libro> getLibri() {
		return libri;
	}
	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}
	public List<Utente> getUtenti() {
		return utenti;
	}
	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}
	public List<Prestito> getPrestiti() {
		return prestiti;
	}
	public void setPrestiti(List<Prestito> prestiti) {
		this.prestiti = prestiti;
	}

	@Override
	public boolean isValid() {
		boolean token = false;
		if((!this.nome.isEmpty()&& this.nome!=null)){
			token = true;
		}
		return token;
	}
}
