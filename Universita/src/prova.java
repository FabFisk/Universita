import java.text.ParseException;
import universita.*;

public class prova {

	public static void main(String[] args) throws ParseException {
		
		Universita u = new Universita("polito");
		Segreteria s = new Segreteria();	
		
		Studente s1;
		System.out.println(s1=s.registraStudente(u, "Mario", "Rossi"));
		Studente s2;
		System.out.println(s2=s.registraStudente(u, "Chiara", "Bianchi"));
		Studente s3;
		System.out.println(s3=s.registraStudente(u, "Luca", "Verdi"));
		
		Docente d1;
		System.out.println(d1=s.registraDocente (u, "Pippo", "Pappo", "PPPPPP01"));
		
		Corso c1;
		System.out.println(c1=s.regCorso(u, "Java", 160));
		
		System.out.println(s.aggiungiStudCorso(u, s1, c1));
		System.out.println(s.aggiungiStudCorso(u, s2, c1));
		System.out.println(s.aggiungiStudCorso(u, s3, c1));
		
		System.out.println(s.aggiungiDocCorso(u, d1, c1));
		
		System.out.println(s.prestaLibro(u, s1, "AAAA", "aaaa", "27-09-2016"));
	}
}

