package application.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Observer;

public class ModelFacade {


    private static ModelFacade instance;
    ImageModel imageModel;
    LinkedList<Perspective> perspectives = new LinkedList<Perspective>();
//    private String path="";
    private String path="Log121-Lab2/src/application/resource/Cheetos2_500_535.JPG";


    public static ModelFacade getInstance()
    {
        if(instance==null)
        {
            instance=new ModelFacade();
        }
        return instance;
    }

    private ModelFacade()
    {
       //if (!this.path.equals("")){
           try {
               if (!path.equals("")){
                   Image image = ImageIO.read(new File(path));
                   System.out.println(image.getHeight(null));
                   imageModel = new ImageModel(image);
               }else{
                   imageModel = new ImageModel();
               }

               perspectives.add(new Perspective(0,0,0.2f));
               perspectives.add(new Perspective());
               perspectives.add(new Perspective());

           } catch (IOException ex) {
               System.out.println("Probleme de chargement d'image");
               ex.printStackTrace();
           }
       //}

    }


    /**
     * @param index
     * @return the perspective at the index if it exists
     */
    public Perspective getPerspective(int index) {
        if (index < perspectives.size() && index >= 0) {
            return perspectives.get(index);
        }
        return null;
    }

    /**
     * if perspective at index exist, return that
     * if perspective at index does not exist, return a new perspective
     * if the index is equal to the number of perspectives, add the new perspective to the others
     *
     * @param index
     * @return
     */    public Perspective getPerspectiveFailsafe(int index) {
        Perspective p = getPerspective(index);
        if (p == null) {
            p = new Perspective();
        }
        if (index == perspectives.size()) {
            perspectives.add(p);
        }

        return p;
    }

    public void setImage(String path){
        try {
            Image image = ImageIO.read(new File(path));
            System.out.println(image.getHeight(null));

            imageModel.setData(image);

        } catch (IOException ex) {
            System.out.println("Probleme de chargement d'image");
            ex.printStackTrace();
        }
    }


    /**
     * wrap the model into a class for ease of access
     *
     * @param index
     * @return
     */
    public RenderData getRenderData(int index) {
        if (this.imageModel != null){
            return new RenderData(imageModel.getData(), getPerspectiveFailsafe(index));
        }else{
            return null;
        }


    }


    public Memento TakeSnapshot() {
        return new Memento(imageModel, perspectives);
    }

    public void ApplySnapshot(Memento snapshot) {
        imageModel.setData(snapshot.imageModel.getData());
        for (int i = 0; i < perspectives.size(); i++) {
            Perspective p = perspectives.get(i);
            p.resetScale();
            p.resetPosition();
            p.rescale(snapshot.perspectives.get(i).scale);
            p.translate(snapshot.perspectives.get(i).xPosition,snapshot.perspectives.get(i).yPosition);
        }
    }

    public void setPerspectivePosition(int id, int x, int y){
        perspectives.get(id).setPosition(x, y);
    }

    public void addObserver(int index, Observer observer)
    {
       if (this.imageModel != null){
           imageModel.addObserver(observer);
           perspectives.get(index).addObserver(observer);

           System.out.println("Observers: " + imageModel.countObservers());
       }
    }

    public void setPerspectiveStartingPoint(int id, Point point){

        perspectives.get(id).setStartingPos(point);
    }
    public Point getPerspectiveStartingPoint(int id){
        return perspectives.get(id).getStartingPos();
    }

    public void rescalePerspertive(int id, float multiplier){
        perspectives.get(id).rescale(multiplier);
    }

}
