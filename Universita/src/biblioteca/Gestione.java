package biblioteca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Gestione {

	public int registraLibro(Biblioteca b, String t, String a, String sn,
			int copie) {
		int tot = 0;
		if (esisteLibro(b, t, a, sn) == true) {
			cercaLibro(b, t, a, sn).setCopieTotali(
					cercaLibro(b, t, a, sn).getCopieTotali() + copie);
			cercaLibro(b, t, a, sn).setCopieDisp(
					cercaLibro(b, t, a, sn).getCopieDisp() + copie);
			tot = cercaLibro(b, t, a, sn).getCopieTotali();
		} else {
			Libro L = new Libro(t, a, sn);
			L.setCopieDisp(copie);
			L.setCopieTotali(copie);
			b.getLibri().add(L);
			tot = L.getCopieTotali();
		}
		return tot;
	}

	public boolean registraUtente(Biblioteca b, String n, String c) {
		boolean token = false;
		if (esisteUtente(b, n, c) != true) {
			Utente u = new Utente(n, c);
			b.getUtenti().add(u);
			token = true;
		}
		return token;
	}

	public boolean prestaLibro(Biblioteca b, String t, String a, String n,
			String c, String d) throws ParseException {
		boolean token = false;
		Date data = stringToDate(d);
		if (esisteLibro(b, t, a) == true) {
			Libro L = cercaLibro(b, t, a);
			if (esisteUtente(b, n, c) == true) {
				Utente u = cercaUtente(b, n, c);
				token = presta(b, token, data, L, u);
			}
		}
		return token;
	}

	private boolean presta(Biblioteca b, boolean token, Date data, Libro L,
			Utente u) {
		if (L.getCopieDisp() > 0 && u.getPrestiti().size() < 3) {
			u.getPrestiti().add(L);
			Prestito p = new Prestito(u, L, data);
			b.getPrestiti().add(p);
			L.setCopieDisp(L.getCopieDisp() - 1);
			token = true;
		}
		return token;
	}

	public boolean restituisciLibro(Biblioteca b, String t, String a, String n,
			String c, String d) throws ParseException {
		boolean token = false;
		Date data = stringToDate(d);
		if (esisteLibro(b, t, a) == true) {
			Libro libro = cercaLibro(b, t, a);
			if (esisteUtente(b, n, c) == true) {
				Utente u = cercaUtente(b, n, c);
				token = restituisci(b, token, data, libro, u);
			}
		}
		return token;
	}

	private boolean restituisci(Biblioteca b, boolean token, Date data,
			Libro libro, Utente u) {
		List<Libro> libriUtente = u.getPrestiti();
		if (libriUtente.contains(libro) == true) {
			libriUtente.remove(libro);
			libro.setCopieDisp(libro.getCopieDisp() + 1);
			token = dataRest(b, token, data, libro, u);
		}
		return token;
	}

	private boolean dataRest(Biblioteca b, boolean token, Date data,
			Libro libro, Utente u) {
		List<Prestito> prestiti = b.getPrestiti();
		for (Prestito p : prestiti) {
			if (p.getL() == libro && p.getU() == u) {
				p.setRestituzione(data);
				token = true;
			}
		}
		return token;
	}

	private Date stringToDate(String d) throws ParseException {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		date = sdf.parse(d);
		return date;
	}

	private Libro cercaLibro(Biblioteca b, String t, String a) {
		Libro libro = null;
		for (Libro L : b.getLibri()) {
			if (L.getTitolo().equals(t) == true
					&& L.getAutore().equals(a) == true) {
				libro = L;
				break;
			}
		}
		return libro;
	}

	private boolean esisteLibro(Biblioteca b, String t, String a) {
		boolean token = false;
		for (Libro L : b.getLibri()) {
			if (L.getTitolo().equals(t) == true
					&& L.getAutore().equals(a) == true) {
				token = true;
				break;
			}
		}
		return token;
	}

	private Libro cercaLibro(Biblioteca b, String t, String a, String sn) {
		Libro libro = null;
		for (Libro L : b.getLibri()) {
			if (L.getTitolo().equals(t) == true
					&& L.getAutore().equals(a) == true
					&& L.getSerialNum().equals(sn) == true) {
				libro = L;
				break;
			}
		}
		return libro;
	}

	private boolean esisteLibro(Biblioteca b, String t, String a, String sn) {
		boolean token = false;
		for (Libro L : b.getLibri()) {
			if (L.getTitolo().equals(t) == true
					&& L.getAutore().equals(a) == true
					&& L.getSerialNum().equals(sn) == true) {
				token = true;
				break;
			}
		}
		return token;
	}

	private Utente cercaUtente(Biblioteca b, String n, String c) {
		Utente user = null;
		for (Utente u : b.getUtenti()) {
			if (u.getNome().equals(n) == true
					&& u.getCognome().equals(c) == true) {
				user = u;
				break;
			}
		}
		return user;
	}

	private boolean esisteUtente(Biblioteca b, String n, String c) {
		boolean token = false;
		for (Utente u : b.getUtenti()) {
			if (u.getNome().equals(n) == true
					&& u.getCognome().equals(c) == true) {
				token = true;
				break;
			}
		}
		return token;
	}
}
