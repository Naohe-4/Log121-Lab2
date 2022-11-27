package application.model;

import java.util.Collection;
import java.util.LinkedList;

public class Memento {

    ImageModel imageModel;
    LinkedList<Perspective> perspectives;


    public Memento(ImageModel image, Collection<Perspective> perspectives)
    {
        imageModel =image;
        this.perspectives =new LinkedList<>(perspectives);
    }

    public void Load()
    {
        ModelFacade.getInstance().ApplySnapshot(this);
    }
}
