package application;

import java.util.ArrayList;

public class dyreKontroll_aass {
	// ArrayList for dyr
	ArrayList<Dyr_aass> dyreliste = new ArrayList<Dyr_aass>();
	
	// Setter en verdi for antall av de forskjellige dyrene
	private int antallHarer = 1;
	private int antallGauper = 1;
	
	// Registrerer de forskjellige dyreartene
	public void regHare(char kj�nn, double lengde, double vekt, String fangsted, String dato, char rase, char farge) {
		// Oppretter et autonummer for Id + dyr
		antallHarer ++;
		String id = "H" + antallHarer;
		id = id.trim();
		Hare_aass nyHare = new Hare_aass(id, kj�nn, lengde, vekt, fangsted, dato, rase, farge);
		dyreliste.add(nyHare);
	}
	
	// Registrerer p� lik m�te for Gaupe
	public void regGaupe(char kj�nn, double lengde, double vekt, String fangsted, String dato, double �reh�rlengde) {
		// Oppretter et autonummer for Gaupen ogs�
		antallGauper ++;
		String id = "G" + antallGauper;
		id = id.trim();
		Gaupe_aass nyGaupe = new Gaupe_aass(id, kj�nn, lengde, vekt, fangsted, dato, �reh�rlengde);
		dyreliste.add(nyGaupe);
	}
	
	// Oppretter regDyr()
	public void regDyr(Dyr_aass dyr) {
		dyreliste.add(dyr);
	}
	
	// Finne/ s�ke etter dyr
	public Dyr_aass s�kDyr(String id) {
		// Line�rt s�k
		Dyr_aass dyr = null;
		boolean funnet = false;
		int teller = 0;
		while (!funnet) {
			dyr = dyreliste.get(teller);
			if (id.equals(dyr.hentId())) funnet = true;
			else teller ++;
		}
		return dyr;
	}
	
	public void regGjenfangst(Gjenfangst_aass gjenfangst, String id) {
		Dyr_aass dyret = s�kDyr(id);
		if (dyret != null) {
			dyret.regGjenfangst(gjenfangst);
		}
	}
	
	// Registrerer gjenfangst for haren
	public void regHareGjenfangst(String id, String dato, String sted, double lengde, double vekt, char farge) {
		Hare_aass haren = (Hare_aass) s�kDyr(id);
		if (haren != null) {
			HareGjenfangst_aass fangst = new HareGjenfangst_aass(dato, sted, lengde, vekt, farge);
			haren.regGjenfangst(fangst);
		}
	}
	
	// Registrerer gjenfangst for gaupen
	public void regGaupeGjenfangst(String id, String dato, String sted, double lengde, double vekt, double �reh�rlengde) {
		Gaupe_aass gaupen = (Gaupe_aass) s�kDyr(id);
		if (gaupen != null) {
			GaupeGjenfangst_aass fangst = new GaupeGjenfangst_aass(dato, sted, lengde, vekt, �reh�rlengde);
			gaupen.regGjenfangst(fangst);
		}
	}
	
	public ArrayList<Dyr_aass> getDyr() {
		return dyreliste;
	}
}
