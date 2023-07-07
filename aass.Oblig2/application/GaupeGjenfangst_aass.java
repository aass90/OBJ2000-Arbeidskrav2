package application;

public class GaupeGjenfangst_aass extends Gjenfangst_aass {
	double ørehårlengde;
	
	public GaupeGjenfangst_aass(String d, String gs, double l, double v, double ørehårlengde) {
		super(d, gs, l, v);
		this.ørehårlengde = ørehårlengde;
	}// Konstruktør
	
	public String toString() {
		return super.toString() + "Ørehårlengde: " + ørehårlengde + "cm";
	}

}
