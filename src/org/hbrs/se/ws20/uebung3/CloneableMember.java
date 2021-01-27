package org.hbrs.se.ws20.uebung3;

/**
 * Die Klasse muss das Interface Clonebale implementieren, 
 * damit sie von aussen kopiert = geklont werden kann. Ohne das
 * Interface tritt eine gepruefte Exception auf (java.lang.CloneNotSupportedException),
 * daher auch die Notwendigkeit, den Clone-Vorgang mit einem try-catch Block
 * zu umschliessen!
 * 
 * @author sascha
 *
 */

public class CloneableMember implements Member, Info, Cloneable {

	public Integer getID() {
		// TODO Auto-generated method stub
		return this.id;
	}

	/*
	 * Der Access Qualifier muss auf public (oder protected) gesetzt werden, damit man von aussen
	 * die Klasse klonen kann (Methode in Object nur protected, daher nicht sichtbar in einem anderen Package,
	 * ausser der Subclass (hier: ClonebaleMember).
	 * Es reicht, mittels super die Methode clone der Oberklasse aufzurufen. 
	 * Es erfolgt dann eine bit-weise Kopie aller Datentypen (hier: ID)
	 * @see java.lang.Object#clone()
	 */
	protected Object clone() throws CloneNotSupportedException {
		// Alternative 1: Aufruf der Methode aus Object, hier bit-weise Kopie der Variablen
		// sowie Check, ob Object cloneable ist. Aber nur: nur ein shallow (flacher) Clone,
		// die inhaltenen Instanzvariablen werden nur per Referenz kopiert!
		// return super.clone();
		
		// Alternative 2: ein eigenes neues Objekt wird erstellt mit der gesetzten ID.
		// Nachteil: kein Check, ob Objekt cloneable ist (keine Exception!). Vorteil: Deep Clone
		// wird explizit durch ein neues Integer-Objekt erzeugt. Bei anderen Referenztypen:
		// rekursiver Aufruf der clone-Methode notwendig, um vollstaendigen Deep Clone durchzuführen.
		return new CloneableMember( this.id , this.name );
	}
	
	private Integer id = null;
	
	private String name = "";
	
	
	public CloneableMember(Integer id, String string) {
		this.id = id;
		this.name = string;
	}

	@Override
	public String toString() {
		return "CloneableMember [id=" + id + "]";
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	} 
	
	
	
 
}
