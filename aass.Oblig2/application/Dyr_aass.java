package application;

import java.text.Collator;
import java.util.ArrayList;

public class Dyr_aass {
	private String id;
	private char kjønn;
	private double lengde;
	private double vekt;
	private String fangsted;
	private String dato;
	
	public ArrayList<Gjenfangst_aass> gjenfangster = new ArrayList<Gjenfangst_aass>();
	private final static Collator KOLLATOR = Collator.getInstance();
	
	public Dyr_aass(String i, char k, double l, double v, String fs, String d) {
		id = i;
		kjønn = k;
		lengde = l;
		vekt = v;
		fangsted = fs;
		dato = d;
	} // Konstruktør
	
	// compareTO
	public int compareTo(Dyr_aass dyr) {
		return KOLLATOR.compare(this.id, dyr.id);
	}
	
	// Bolsk
	public boolean equals(Dyr_aass dyr) {
		return KOLLATOR.equals(this.id, dyr.id);
	}
	
	// ArrayList
	public ArrayList<Gjenfangst_aass> hentFangst() {
		return gjenfangster;
	}
	
	public String hentId() {
		return id;
	}
	
	public char hentKjønn() {
		return kjønn;
	}
	
	public double hentLengde() {
		return lengde;
	}
	
	public double hentVekt() {
		return vekt;
	}
	
	public String hentSted() {
		return fangsted;
	}
	
	public String hentDato() {
		return dato;
	}
	
	public void regGjenfangst(Gjenfangst_aass g) {
		gjenfangster.add(g);
	}
	
	public ArrayList<Gjenfangst_aass> getGjenfangst() {
		return gjenfangster;
	}
	
	//toString med formattering for å vise oversiktlig utskrift
	public String toString() {
		return "\n" + "\n" + "Id: " + id + "  " + "Kjønn: " + kjønn + "\n" + "Lengde: " + lengde + "cm" + "  " + "Vekt: " + vekt + "kg" + "  " + "Fangsted: " + fangsted + "  " +"Dato: " + dato + "\n";
	}

}
