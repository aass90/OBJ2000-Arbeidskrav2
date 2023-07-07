package application;

public class HareGjenfangst_aass extends Gjenfangst_aass {
	private char farge;
	
	public HareGjenfangst_aass(String d, String gs, double l, double v, char f) {
		super(d, gs, l, v);
		farge = f;
	} // Konstruktør
	
	public String toString() {
		return super.toString() + "Farge: " + farge + "\n";
	}
}
