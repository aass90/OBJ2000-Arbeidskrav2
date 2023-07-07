package application;

public class Gjenfangst_aass {
	private String dato;
	private String gjenfangsted;
	private double lengde;
	private double vekt;
	
	public Gjenfangst_aass(String d, String gs, double l, double v) {
		dato = d;
		gjenfangsted = gs;
		lengde = l;
		vekt = v;
	} // Konstruktør
	
	public String hentDato() {
		return dato;
	}
	
	public String hentSted() {
		return gjenfangsted;
	}
	
	public double hentLengde() {
		return lengde;
	}
	
	public double hentVekt() {
		return vekt;
	}
	
	public String toString() {
		return "\n" + "\n" + "Dato for gjenfangst: " + dato + " Sted: " + gjenfangsted + "\n" + " Lengde: " + lengde + "cm" + "  " + " Vekt: " + vekt + "kg" + "\n";
	}
}
