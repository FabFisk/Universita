package universita;

import biblioteca.*;

public class Docente extends Utente {
	
	private String codFisc;
	
	public Docente(){}
	public Docente(String nome, String cognome){
		super(nome, cognome);
	}
	
	public String getCodFisc() {
		return codFisc;
	}
	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}
}
