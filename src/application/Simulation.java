package application;

import application.view.Environnement;
import application.view.FenetrePrincipale;
import application.view.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class Simulation {

	/**
	 * Cette classe représente l'application dans son ensemble.
	 */

	private static Dimension screenSize = new Dimension(700, 700);

	public static void main(String[] args) {
		Environnement environnement = new Environnement();

		//JFrame
		FenetrePrincipale fenetre = new FenetrePrincipale();
		fenetre.setPreferredSize(new Dimension(700, 700));

		environnement.addPropertyChangeListener(fenetre);
		environnement.execute();


	}


}
