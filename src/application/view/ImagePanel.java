package application.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class ImagePanel extends JPanel {

	private BufferedImage image;

	public ImagePanel(String path) {
		try {
			//System.out.println(new File(path));
		//	System.out.println(System.getProperty("user.dir"));
			image = ImageIO.read(new File(path));
//			image = ImageIO.read(this.getClass().getResource("/images/pic1.jpg"));

		} catch (IOException ex) {
			System.out.println("Probleme de chargement d'image");
			ex.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
	}

}
