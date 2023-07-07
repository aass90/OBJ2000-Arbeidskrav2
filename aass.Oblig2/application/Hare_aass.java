package application;

public class Hare_aass extends Dyr_aass {
	private char rase;
	private char farge;
	
	public Hare_aass(String i, char k, double l, double v, String s, String d, char r, char f) {
		super(i, k, l, v, s, d);
		rase = r;
		farge = f;
	} // Konstruktør
	
	public char hentRase() {
		return rase;
	}
	
	public char hentFarge() {
		return farge;
	}
	
	public String toString() {
		return super.toString() + "Rase: " + rase + "  " + "\t" + "Farge: " + farge;
	}
}
