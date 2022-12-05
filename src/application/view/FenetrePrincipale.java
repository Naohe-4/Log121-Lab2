package application.view;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class FenetrePrincipale extends JFrame implements PropertyChangeListener, ItemListener {

	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Laboratoire 1 : LOG121 - Simulation";
	private static final Dimension DIMENSION = new Dimension(700, 700);

	private final String CHEETOS_100 = "Log121-Lab2/src/application/resource/Cheetos_100_107.jpg";
	private final String CHEETOS1_500 = "Log121-Lab2/src/application/resource/Cheetos_500_535.JPG";
	private final String CHEETOS2_500 = "Log121-Lab2/src/application/resource/Cheetos2_500_535.JPG";

	JPanel panel;

	public FenetrePrincipale() {

		//ImagePanel panneauPrincipal = new ImagePanel();

		//options de menu
		MenuFenetre menuFenetre = new MenuFenetre();


		//add(panneauPrincipal);
		add(menuFenetre, BorderLayout.NORTH);

		createSpringLayout();

		// Faire en sorte que le X de la fen�tre ferme la fen�tre
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(TITRE_FENETRE);
		setSize(DIMENSION);
		setPreferredSize(DIMENSION);



		// Rendre la fen�tre visible
		setVisible(true);
		// Mettre la fen�tre au centre de l'�cran
		setLocationRelativeTo(null);
		// Emp�cher la redimension de la fen�tre
		setResizable(false);
	}

	private void createSpringLayout(){

		Dimension ButtonDimension = new Dimension(100, 25);

		ImagePanel thumbnail = new ImagePanel(CHEETOS_100);
		thumbnail.setPreferredSize(new Dimension(100, 107));

		//Creation of all the elements
		JButton bt1 = new JButton("BT 1");
		JButton bt2 = new JButton("BT 2");
		JButton bt3 = new JButton("BT 3");
		JButton tab1 = new JButton("View 1");
		JButton tab2 = new JButton("View 2");
		bt1.setPreferredSize(ButtonDimension);
		bt2.setPreferredSize(ButtonDimension);
		bt3.setPreferredSize(ButtonDimension);
		tab1.setPreferredSize(ButtonDimension);
		tab2.setPreferredSize(ButtonDimension);

		JTabbedPane tabbedPane = createTabbedPane();
		panel = new JPanel();
		SpringLayout layout = new SpringLayout();
		panel.setLayout(layout);

		//Adds all the elements to the panel
		panel.add(thumbnail);
		panel.add(bt1);
		panel.add(bt2);
		panel.add(bt3);
		panel.add(tabbedPane);


		//All the constraints for the SpringLayout
		layout.putConstraint(SpringLayout.NORTH, thumbnail, 25, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, thumbnail, 25, SpringLayout.WEST, panel);

		layout.putConstraint(SpringLayout.NORTH, bt1, 8, SpringLayout.SOUTH, thumbnail);
		layout.putConstraint(SpringLayout.WEST, bt1, 25, SpringLayout.WEST, panel);

		layout.putConstraint(SpringLayout.NORTH, bt2, 8, SpringLayout.SOUTH, bt1);
		layout.putConstraint(SpringLayout.WEST, bt2, 25, SpringLayout.WEST, panel);

		layout.putConstraint(SpringLayout.NORTH, bt3, 8, SpringLayout.SOUTH, bt2);
		layout.putConstraint(SpringLayout.WEST, bt3, 25, SpringLayout.WEST, panel);

		layout.putConstraint(SpringLayout.NORTH, tabbedPane, 0, SpringLayout.SOUTH, tab1);
		layout.putConstraint(SpringLayout.WEST, tabbedPane, 25, SpringLayout.EAST, thumbnail);

		//Adds the panel to this JFrame
		add(panel);
		pack();

	}

	private JTabbedPane createTabbedPane(){
		JTabbedPane tabbedPane = new JTabbedPane();

		//First View
		ImagePanel firstView = new ImagePanel(CHEETOS1_500);
		firstView.setPreferredSize(new Dimension(500, 535));

		//Second View
		ImagePanel secondView = new ImagePanel(CHEETOS2_500);
		secondView.setPreferredSize(new Dimension(500, 535));

		final String LABELVIEW1 = "First View";
		final String LABELVIEW2 = "Second View";

		tabbedPane.addTab(LABELVIEW1, firstView);
		tabbedPane.addTab(LABELVIEW2, secondView);

		//this.frame.add(tabbedPane, BorderLayout.CENTER);
		return tabbedPane;
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("TEST")) {
			repaint();
			System.out.println(evt.getNewValue());
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		CardLayout cl = (CardLayout)(this.panel.getLayout());
		cl.show(this.panel, (String)e.getItem());
	}
}
