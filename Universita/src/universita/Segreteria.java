package universita;

import java.text.ParseException;

import biblioteca.Utente;

public class Segreteria {
	
	public Studente registraStudente(Universita u, String nome, String cognome){
		Studente s=null;
		if (esisteStudente(u, nome, cognome) != true) {
			s = new Studente(nome, cognome);
			s.setMatricola(calcolaMatricola(nome, cognome));
			u.getStudenti().add(s);
			if(u.getB().getUtenti().contains(s)!=true){
				u.getB().getUtenti().add(s);
			}
		}else{
			s = cercaStudente(u, nome, cognome);
		}
		return (Studente) s;
	}
	
	public Docente registraDocente (Universita u, String nome, String cognome, String codFisc){
		Docente d = null;
		if (esisteDocente(u, nome, cognome) != true) {
			d = new Docente(nome, cognome);
			d.setCodFisc(codFisc);
			u.getDocenti().add(d);
			if(u.getB().getUtenti().contains(d)!=true){
				u.getB().getUtenti().add(d);
			}
		}else{
			d = cercaDocente(u, nome, cognome);
		}
		return d;
	}
	
	public Corso regCorso(Universita u, String nome, int ore){
		Corso c=null;
		if(!esisteCorso(u, nome, ore)){
			c = new Corso(nome, ore);
			u.getCorsi().add(c);
		}else{
			c = cercaCorso(u, nome, ore);
		}		
		return c;
	}
	
	public boolean aggiungiStudCorso(Universita u, Studente s, Corso c){
		boolean token = false;
		if(esisteStudente(u, s)
				&& esisteCorso(u, c)){
			c.getIscritti().add(s);
			token = true;
		}		
		return token;
	}
	
	public boolean aggiungiDocCorso(Universita u, Docente d, Corso c){
		boolean token = false;
		if(esisteDocente(u, d)
				&& esisteCorso(u, c)){
			c.getInsegnanti().add(d);
			token = true;
		}		
		return token;
	}
	
	public boolean prestaLibro(Universita u, Utente s, String t, String a, String data) 
			throws ParseException {
		boolean token=false;
		u.getG().prestaLibro(u.getB(), t, a, s.getNome(), s.getCognome(), data);
		return token;
	}
	
	//Metodi ausiliari
	
	private String calcolaMatricola(String nome, String cognome) {
		StringBuilder sb = new StringBuilder();
		sb.append(nome.substring(0, 3))
			.append(cognome.substring(0, 3))
			.append(Studente.getContatore());;		
		String st = sb.toString();
		return st;
	}	
	
	private Docente cercaDocente(Universita u, String n, String c) {
		Docente user = null;
		for (Docente d : u.getDocenti()) {
			if (d.getNome().equals(n) == true
					&& d.getCognome().equals(c) == true) {
				user = d;
				break;
			}
		}
		return user;
	}
//	private Docente cercaDocente(Universita u, Docente d) {
//		Docente user = null;
//		for (Docente doc : u.getDocenti()) {
//			if (doc.equals(d)) {
//				user = doc;
//				break;
//			}
//		}
//		return user;
//	}
	private boolean esisteDocente(Universita u, String n, String c) {
		boolean token = false;
		for (Docente d : u.getDocenti()) {
			if (d.getNome().equals(n) == true
					&& d.getCognome().equals(c) == true) {
				token = true;
				break;
			}
		}
		return token;
	}
	private boolean esisteDocente(Universita u, Docente d) {
		boolean token = false;
		for (Docente doc : u.getDocenti()) {
			if (d.getCodFisc().equals(doc.getCodFisc())) {
				token = true;
				break;
			}
		}
		return token;
	}
	
	private Studente cercaStudente(Universita u, String n, String c) {
		Studente user = null;
		for (Studente s : u.getStudenti()) {
			if (s.getNome().equals(n) == true
					&& s.getCognome().equals(c) == true) {
				user = s;
				break;
			}
		}
		return user;
	}
//	private Studente cercaStudente(Universita u, Studente st) {
//		Studente user = null;
//		for (Studente s : u.getStudenti()) {
//			if (s.equals(st)) {
//				user = s;
//				break;
//			}
//		}
//		return user;
//	}
	private boolean esisteStudente(Universita u, String n, String c) {
		boolean token = false;
		for (Studente p : u.getStudenti()) {
			if (p.getNome().equals(n) == true
					&& p.getCognome().equals(c) == true) {
				token = true;
				break;
			}
		}
		return token;
	}
	private boolean esisteStudente(Universita u, Studente st) {
		boolean token = false;
		for (Studente s : u.getStudenti()) {
			if (s.getMatricola().equals(st.getMatricola())) {
				token = true;
				break;
			}
		}
		return token;
	}
		
	private Corso cercaCorso(Universita u, String n, int ore) {
		Corso cor = null;
		for (Corso c : u.getCorsi()) {
			if (c.getNome().equals(n) == true
					&& c.getOre()== ore) {
				cor = c;
				break;
			}
		}
		return cor;
	}
//	private Corso cercaCorso(Universita u, Corso c) {
//		Corso corso = null;
//		for (Corso cor : u.getCorsi()) {
//			if (cor.equals(corso)) {
//				corso = cor;
//				break;
//			}
//		}
//		return corso;
//	}
	private boolean esisteCorso(Universita u, String n, int ore) {
		boolean token = false;
		for (Corso c : u.getCorsi()) {
			if (c.getNome().equals(n) == true
					&& c.getOre() == ore) {
				token = true;
				break;
			}
		}
		return token;
	}
	private boolean esisteCorso(Universita u, Corso c) {
		boolean token = false;
		for (Corso cor : u.getCorsi()) {
			if (cor.equals(c)) {
				token = true;
				break;
			}
		}
		return token;
	}
	
	
}
