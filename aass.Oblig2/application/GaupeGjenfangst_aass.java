package application;

public class GaupeGjenfangst_aass extends Gjenfangst_aass {
	double �reh�rlengde;
	
	public GaupeGjenfangst_aass(String d, String gs, double l, double v, double �reh�rlengde) {
		super(d, gs, l, v);
		this.�reh�rlengde = �reh�rlengde;
	}// Konstrukt�r
	
	public String toString() {
		return super.toString() + "�reh�rlengde: " + �reh�rlengde + "cm";
	}

}
