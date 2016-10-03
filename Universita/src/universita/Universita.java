package universita;

import java.util.*;
import utility.*;
import biblioteca.*;

public class Universita implements Validate {

	private String nome;
	private List<Studente> studenti = new ArrayList<Studente>();
	private List<Docente> docenti = new ArrayList<Docente>();
	private List<Corso> corsi = new ArrayList<Corso>();
	private Biblioteca b = new Biblioteca();
	private Gestione g = new Gestione();
	
	public Universita(){}
	public Universita(String nome){
		this.nome = nome;
	}
	public Universita(String nome, String biblio){
		this.nome=nome;
		this.b = new Biblioteca(biblio);
	}
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Studente> getStudenti() {
		return studenti;
	}
	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}
	public List<Docente> getDocenti() {
		return docenti;
	}
	public void setDocenti(List<Docente> docenti) {
		this.docenti = docenti;
	}
	public List<Corso> getCorsi() {
		return corsi;
	}
	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
	public Biblioteca getB() {
		return b;
	}
	public void setB(Biblioteca b) {
		this.b = b;
	}
	public Gestione getG() {
		return g;
	}
	public void setG(Gestione g) {
		this.g = g;
	}
	@Override
	public boolean isValid() {
		boolean token = false;
		if(!nome.isEmpty()
				&& nome!=null){
			token = true;
		}
		return token;
	}

}
