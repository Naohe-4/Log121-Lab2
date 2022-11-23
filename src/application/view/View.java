package application.view;

import application.model.ModelFacade;
import application.model.Perspective;
import application.model.RenderData;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {

    private ModelFacade model;
    private int index;


    @Override
    public void update(Observable o, Object arg) {
        RenderData rd = model.getRenderData(index);
        display(rd.getImage(),rd.getPerspective());
    }

    public void display(Image i, Perspective p)
    {
        //display
    }



}
