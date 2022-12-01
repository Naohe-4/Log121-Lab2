package application;

import application.view.Environnement;
import application.view.FenetrePrincipale;

import java.awt.*;

public class Simulation {

	/**
	 * Cette classe représente l'application dans son ensemble.
	 */
	public static void main(String[] args) {
		Environnement environnement = new Environnement();

		//JFrame
		FenetrePrincipale fenetre = new FenetrePrincipale();
		fenetre.setPreferredSize(new Dimension(700, 700));

		environnement.addPropertyChangeListener(fenetre);
		environnement.execute();
	}

}
