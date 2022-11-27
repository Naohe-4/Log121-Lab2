package application.model;

import java.awt.*;
import java.util.Observable;

public class ImageModel extends Observable {

    private Image data;

    public Image getData()
    {
        return data;
    }

    public void setData(Image data)
    {
        this.data=data;
        notifyObservers();
    }


}
