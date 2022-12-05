package application.model;

import java.awt.*;
import java.io.Serializable;
import java.util.Observable;

public class ImageModel extends Observable implements Serializable {

    private Image data;

    public ImageModel()
    {
        this.data = null;
    }

    public ImageModel(Image data)
    {
        this.data=data;
    }

    public ImageModel(ImageModel model)
    {
        this.data = model.getData();
    }

    public Image getData()
    {
        return data;
    }

    public void setData(Image data)
    {
        this.data=data;
        System.out.println("Notifications sent...");
        this.setChanged();
        notifyObservers();
    }



}
