package application.view;

import application.model.ModelFacade;
import application.model.RenderData;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class ImagePanel extends JPanel implements Observer {

    private BufferedImage image;
    private RenderData imageData;
    private ModelFacade facade;
    private int id;

/*    public ImagePanel(String path) {
        try {
            //System.out.println(new File(path));
            //	System.out.println(System.getProperty("user.dir"));
            image = ImageIO.read(new File(path));
//			image = ImageIO.read(this.getClass().getResource("/images/pic1.jpg"));

        } catch (IOException ex) {
            System.out.println("Probleme de chargement d'image");
            ex.printStackTrace();
        }
    }*/

    public ImagePanel(int id) {
        this.id = id;
        facade=ModelFacade.getInstance();
		this.imageData=facade.getRenderData(id);
        this.repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int posX = imageData.getPerspective().getxPosition();
        int posY = imageData.getPerspective().getyPosition();
        int imgWidth = imageData.getImage().getWidth(null);
        int imgHeight = imageData.getImage().getHeight(null);
        float scale = imageData.getPerspective().getScale();

        g.drawImage(imageData.getImage(), posX, posY, (int) (imgWidth * scale), (int) (imgHeight * scale), this);
        //System.out.println("Paint paint paint");

    }

    @Override
    public void update(Observable o, Object arg) {
        imageData = facade.getRenderData(id);
        this.repaint();
    }

    public int getId() {
        return id;
    }
}
