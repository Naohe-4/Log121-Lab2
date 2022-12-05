package application.view;

import application.model.ModelFacade;
import application.model.RenderData;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class ImagePanel extends JPanel {

    private BufferedImage image;
    private RenderData imageData;
    private ModelFacade facade;
    private int id;

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

    public ImagePanel(int id) {
        this.id = id;
        facade=ModelFacade.getInstance();
		this.imageData=facade.getRenderData(id);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters

        int posX = imageData.getPerspective().getxPosition();
        int posY = imageData.getPerspective().getyPosition();
        int imgWidth = imageData.getImage().getWidth(null);
        int imgHeight = imageData.getImage().getHeight(null);
        float scale = imageData.getPerspective().getScale();

        g.drawImage(image, posX, posY, (int) (imgWidth * scale), (int) (imgHeight * scale), null);


    }

    public void update() {
        imageData = facade.getRenderData(id);
        repaint();
    }

}
