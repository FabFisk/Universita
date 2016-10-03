package universita;

import biblioteca.*;

public class Studente extends Utente {
	
	static int contatore;
	private String matricola;
	private double media;

	public Studente(){
		super();
	};
	public Studente(String nome, String cognome) {
		super(nome, cognome);
		contatore++;
	}
	
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	public static int getContatore() {
		return contatore;
	}
	public static void setContatore(int contatore) {
		Studente.contatore = contatore;
	}	
}
