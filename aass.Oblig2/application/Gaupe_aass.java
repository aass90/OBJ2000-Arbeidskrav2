package application;

public class Gaupe_aass extends Dyr_aass {
	double ørehårlengde;
	
	public Gaupe_aass(String i, char k, double l, double v, String fs, String d, double øhl) {
		super(i, k, l, v, fs, d);
		this.ørehårlengde = øhl;
	} // Konstruktør
	
	@Override
	public String toString() {
		return super.toString() + "Ørehårlengde: " + ørehårlengde + "cm";
	}
	
	public double getØrehårlengde() {
		return ørehårlengde;
	}

}
