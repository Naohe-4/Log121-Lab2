package application.model;

import java.awt.*;
import java.util.Observable;

public class ImageModel extends Observable {

    private Image data;

    public ImageModel(Image data)
    {
        this.data=data;
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
