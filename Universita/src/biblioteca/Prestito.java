package biblioteca;

import java.util.Date;

public class Prestito {
	
	private Libro l;
	private Utente u;
	private Date prestito;
	private Date restituzione;
	
	public Prestito(){}
	public Prestito(Utente u, Libro l, Date prestito){
		this.l = l;
		this.u = u;
		this.prestito = prestito;
	}

	public Libro getL() {
		return l;
	}
	public void setL(Libro l) {
		this.l = l;
	}
	public Utente getU() {
		return u;
	}
	public void setU(Utente u) {
		this.u = u;
	}
	public Date getPrestito() {
		return prestito;
	}
	public void setPrestito(Date prestito) {
		this.prestito = prestito;
	}
	public Date getRestituzione() {
		return restituzione;
	}
	public void setRestituzione(Date restituzione) {
		this.restituzione = restituzione;
	}
}
