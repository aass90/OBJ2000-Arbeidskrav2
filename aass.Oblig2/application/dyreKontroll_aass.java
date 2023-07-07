package application;

import java.util.ArrayList;

public class dyreKontroll_aass {
	// ArrayList for dyr
	ArrayList<Dyr_aass> dyreliste = new ArrayList<Dyr_aass>();
	
	// Setter en verdi for antall av de forskjellige dyrene
	private int antallHarer = 1;
	private int antallGauper = 1;
	
	// Registrerer de forskjellige dyreartene
	public void regHare(char kjønn, double lengde, double vekt, String fangsted, String dato, char rase, char farge) {
		// Oppretter et autonummer for Id + dyr
		antallHarer ++;
		String id = "H" + antallHarer;
		id = id.trim();
		Hare_aass nyHare = new Hare_aass(id, kjønn, lengde, vekt, fangsted, dato, rase, farge);
		dyreliste.add(nyHare);
	}
	
	// Registrerer på lik måte for Gaupe
	public void regGaupe(char kjønn, double lengde, double vekt, String fangsted, String dato, double ørehårlengde) {
		// Oppretter et autonummer for Gaupen også
		antallGauper ++;
		String id = "G" + antallGauper;
		id = id.trim();
		Gaupe_aass nyGaupe = new Gaupe_aass(id, kjønn, lengde, vekt, fangsted, dato, ørehårlengde);
		dyreliste.add(nyGaupe);
	}
	
	// Oppretter regDyr()
	public void regDyr(Dyr_aass dyr) {
		dyreliste.add(dyr);
	}
	
	// Finne/ søke etter dyr
	public Dyr_aass søkDyr(String id) {
		// Lineært søk
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
		Dyr_aass dyret = søkDyr(id);
		if (dyret != null) {
			dyret.regGjenfangst(gjenfangst);
		}
	}
	
	// Registrerer gjenfangst for haren
	public void regHareGjenfangst(String id, String dato, String sted, double lengde, double vekt, char farge) {
		Hare_aass haren = (Hare_aass) søkDyr(id);
		if (haren != null) {
			HareGjenfangst_aass fangst = new HareGjenfangst_aass(dato, sted, lengde, vekt, farge);
			haren.regGjenfangst(fangst);
		}
	}
	
	// Registrerer gjenfangst for gaupen
	public void regGaupeGjenfangst(String id, String dato, String sted, double lengde, double vekt, double ørehårlengde) {
		Gaupe_aass gaupen = (Gaupe_aass) søkDyr(id);
		if (gaupen != null) {
			GaupeGjenfangst_aass fangst = new GaupeGjenfangst_aass(dato, sted, lengde, vekt, ørehårlengde);
			gaupen.regGjenfangst(fangst);
		}
	}
	
	public ArrayList<Dyr_aass> getDyr() {
		return dyreliste;
	}
}
