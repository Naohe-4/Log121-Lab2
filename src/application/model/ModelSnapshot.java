package application.model;

import java.util.Collection;
import java.util.LinkedList;

public class ModelSnapshot {

    ImageModel imageModel;
    LinkedList<Perspective> perspectives;


    public ModelSnapshot(ImageModel image, Collection<Perspective> perspectives)
    {
        imageModel =image;
        this.perspectives =new LinkedList<>(perspectives);
    }

}
