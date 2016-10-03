package universita;

import java.util.*;
import utility.Validate;

public class Corso implements Validate {
	
	private String nome;
	private int ore;
	private List<Studente> iscritti = new ArrayList<Studente>();
	private List<Docente> insegnanti = new ArrayList<Docente>();

	public Corso(){}	
	public Corso(String nome, int ore){
		this.nome=nome;
		this.ore=ore;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getOre() {
		return ore;
	}
	public void setOre(int ore) {
		this.ore = ore;
	}	
	public List<Studente> getIscritti() {
		return iscritti;
	}
	public void setIscritti(List<Studente> iscritti) {
		this.iscritti = iscritti;
	}
	public List<Docente> getInsegnanti() {
		return insegnanti;
	}
	public void setInsegnanti(List<Docente> insegnanti) {
		this.insegnanti = insegnanti;
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
