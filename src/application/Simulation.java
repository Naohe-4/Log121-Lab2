package application;

import application.controller.ButtonController;
import application.controller.MouseControls;
import application.view.Environnement;
import application.view.FenetrePrincipale;

import javax.swing.*;
import java.awt.*;

public class Simulation {

	/**
	 * Cette classe représente l'application dans son ensemble.
	 */

	private static Dimension screenSize = new Dimension(700, 700);

	public static void main(String[] args) {
		Environnement environnement = new Environnement();

		MouseControls mouseControls = new MouseControls();
		ButtonController buttonController = new ButtonController();

		//JFrame
		FenetrePrincipale fenetre = new FenetrePrincipale(mouseControls, buttonController);
		fenetre.setPreferredSize(new Dimension(700, 700));

		environnement.addPropertyChangeListener(fenetre);
		environnement.execute();



	}


}
