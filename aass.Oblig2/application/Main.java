package application;
	
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
// Oppretter et objekt av dyreKontroll
dyreKontroll_aass kontroll = new dyreKontroll_aass();	
	
	private MenuBar menylinje = new MenuBar();
	private Menu reg_dyr = new Menu("Registrer dyr");
	private MenuItem hare = new MenuItem("Registrer Hare");
	private MenuItem gaupe = new MenuItem("Registrer Gaupe");
	
	private Menu gjenfangst = new Menu("Gjenfangst");
	private MenuItem ghare = new MenuItem("Haregjenfangst");
	private MenuItem ggaupe = new MenuItem("Gaupegjenfangst");
	
	private Menu visning = new Menu("Visning");
	private MenuItem søk = new MenuItem("Søk dyr");
	private MenuItem oversikt = new MenuItem("Oversikt, dyr");
	private MenuItem historikk = new MenuItem("Dyr med historikk");
	
	// Lager et skille for valg og avslutt
	private Menu tom = new Menu();
	
	private Menu avslutt = new Menu("Avslutt");
	private MenuItem exit = new MenuItem("Avslutt program");
	BorderPane rotpanel = new BorderPane();
	
	// Legger til noen testdata
	public Main() {
		kontroll.regDyr(new Hare_aass("H1", 'F', 13.2, 3.2, "S1", "28.10.2021", 'S', 'B'));
		kontroll.regDyr(new Gaupe_aass("G1", 'M', 47.2, 36.4, "S14", "29.10.2021", 3.2));
		kontroll.regHareGjenfangst("H1", "30.10.2021", "S2", 13.2, 3.4, 'B');
		kontroll.regGaupeGjenfangst("G1", "31.10.2021", "S16", 47.2, 36.7, 3.4);
	}
	
	@Override
	public void start (Stage vindu) {
		try {
			// Legger menyelementene inn i menyen
			reg_dyr.getItems().addAll(hare, gaupe);
			gjenfangst.getItems().addAll(ghare, ggaupe);
			visning.getItems().addAll(søk, oversikt, historikk);
			avslutt.getItems().addAll(exit);
			
			// Legger menyen til en menylinje
			menylinje.getMenus().addAll(reg_dyr);
			menylinje.getMenus().addAll(gjenfangst);
			menylinje.getMenus().addAll(visning);
			menylinje.getMenus().addAll(tom);
			menylinje.getMenus().addAll(avslutt);
			
			// Knytter menyvalgene til brukeren
			hare.setOnAction(e -> regHare(e));
			gaupe.setOnAction(e -> regGaupe(e));
			ghare.setOnAction(e -> regHareGjenfangst(e));
			ggaupe.setOnAction(e -> regGaupeGjenfangst(e));
			søk.setOnAction(e -> søkDyr(e));
			oversikt.setOnAction(e -> oversiktDyr(e));
			historikk.setOnAction(e -> historikkDyr(e));
			exit.setOnAction(e -> behandleAvslutt());
			
			// Legger menylinjen i toppfeltet til rotpanelet
			rotpanel.setTop(menylinje);
			
			// Lager scenen med rotpanelet som parameter
			Scene scene = new Scene(rotpanel, 400, 150);
			vindu.setScene(scene);
			vindu.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void regGaupe(ActionEvent e) {
		String lestKjønn = JOptionPane.showInputDialog("Oppgi gaupens kjønn: ");
		char kjønn = lestKjønn.charAt(0);
		double lengde = Double.parseDouble(JOptionPane.showInputDialog("Oppgi gaupens lengde: "));
		double vekt = Double.parseDouble(JOptionPane.showInputDialog("Oppgi gaupens vekt: "));
		String fangsted = JOptionPane.showInputDialog("Oppgi fangsted for gaupen: ");
		String dato = JOptionPane.showInputDialog("Oppgi dato for fangst: ");
		double ørehårlengde = Double.parseDouble(JOptionPane.showInputDialog("Oppgi lengde på ørehår: "));
		kontroll.regGaupe(kjønn, lengde, vekt, fangsted, dato, ørehårlengde);
	}
	
	public void regHare(ActionEvent e) {
		String lestKjønn = JOptionPane.showInputDialog("Oppgi harens kjønn: ");
		char kjønn = lestKjønn.charAt(0);
		double lengde = Double.parseDouble(JOptionPane.showInputDialog("Oppgi harens lengde: "));
		double vekt = Double.parseDouble(JOptionPane.showInputDialog("Oppgi harens vekt: "));
		String fangsted = JOptionPane.showInputDialog("Oppgi fangsted for haren: ");
		String dato = JOptionPane.showInputDialog("Oppgi dato for fangst: ");
		String lestRase = JOptionPane.showInputDialog("Oppgi harens rase: ");
		char rase = lestRase.charAt(0);
		String lestFarge = JOptionPane.showInputDialog("Oppgi harens farge: ");
		char farge = lestFarge.charAt(0);
		kontroll.regHare(kjønn, lengde, vekt, fangsted, dato, rase, farge);
	}
	
	public void regHareGjenfangst(ActionEvent e) {
		String id = JOptionPane.showInputDialog("Oppgi harens ID: ");
		String dato = JOptionPane.showInputDialog("Oppgi dato for gjenfangst: ");
		String sted = JOptionPane.showInputDialog("Oppgi sted for gjenfangst: ");
		double lengde = Double.parseDouble(JOptionPane.showInputDialog("Oppgi harens lengde: "));
		double vekt = Double.parseDouble(JOptionPane.showInputDialog("Oppgi harens vekt: "));
		String lestFarge = JOptionPane.showInputDialog("Oppgi harens farge: ");
		char farge = lestFarge.charAt(0);
		kontroll.regHareGjenfangst(id, dato, sted, lengde, vekt, farge);
	}
	
	public void regGaupeGjenfangst(ActionEvent e) {
		String id = JOptionPane.showInputDialog("Oppgi gaupens ID: ");
		String dato = JOptionPane.showInputDialog("Oppgi dato for gjenfangst: ");
		String sted = JOptionPane.showInputDialog("Oppgi sted for gjenfangst: ");
		double lengde = Double.parseDouble(JOptionPane.showInputDialog("Oppgi gaupens lengde: "));
		double vekt = Double.parseDouble(JOptionPane.showInputDialog("Oppgi gaupens vekt: "));
		double ørehårlengde = Double.parseDouble(JOptionPane.showInputDialog("Oppgi gaupens ørehårlengde: "));
		kontroll.regGaupeGjenfangst(id, dato, sted, lengde, vekt, ørehårlengde);
	}
	
	public void søkDyr(ActionEvent e) {
		String id = JOptionPane.showInputDialog("Oppgi dyrets ID: ");
		id = id.trim();
		Dyr_aass dyret = kontroll.søkDyr(id);
		if (dyret != null) JOptionPane.showMessageDialog(null, dyret.toString());
		else JOptionPane.showMessageDialog(null, "Dyret finnes ikke vår database");
	}
	
	public void oversiktDyr(ActionEvent e) {
		ArrayList<Dyr_aass> dyrene = kontroll.getDyr();
		String uttekst = "";
		for (int i =0; i < dyrene.size(); i ++) {
			Dyr_aass dyret = dyrene.get(i);
			uttekst += dyret.toString();
		}
		JOptionPane.showMessageDialog(null, uttekst);
	}
	
	public void historikkDyr(ActionEvent e) {
		ArrayList<Dyr_aass> dyrene = kontroll.getDyr();
		String uttekst = "";
		for (int i = 0; i < dyrene.size(); i ++) {
			Dyr_aass dyret = dyrene.get(i);
			uttekst += dyret.toString();
			for (Gjenfangst_aass g : dyret.gjenfangster) {
				uttekst += g.toString();
			}
			
		}
		JOptionPane.showMessageDialog(null, uttekst);
	}
	
	// Knyttes til menyvalget "exit" for å avslutte programmet
	public void behandleAvslutt() {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

/*
 * Kilder:
 * Tidligere arbeid fra forelesning, JavaFX meny med inspirasjon fra "Demo JavaFX meny"
 * samt diverse filer og programmer som ligger tilgjengelig under "Filer" på Canvas
 * 
 */
