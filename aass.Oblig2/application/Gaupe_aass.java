package application;

public class Gaupe_aass extends Dyr_aass {
	double �reh�rlengde;
	
	public Gaupe_aass(String i, char k, double l, double v, String fs, String d, double �hl) {
		super(i, k, l, v, fs, d);
		this.�reh�rlengde = �hl;
	} // Konstrukt�r
	
	@Override
	public String toString() {
		return super.toString() + "�reh�rlengde: " + �reh�rlengde + "cm";
	}
	
	public double get�reh�rlengde() {
		return �reh�rlengde;
	}

}
