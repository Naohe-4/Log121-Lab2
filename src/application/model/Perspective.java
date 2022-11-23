package application.model;

import java.util.Observable;


public class Perspective extends Observable {


    float scale = 1;
    int xPosition = 0;//distance from origin (pixel)
    int yPosition = 0;//distance from origin (pixel)

    public Perspective(){};

    public Perspective( int x,int y,float scale)
    {
        this.scale=scale;
        xPosition=x;
        yPosition=y;
    }

    public void  translate(int x,int y)
    {
        xPosition+=x;
        yPosition+=y;

        notifyObservers();
    }

    public void resetPosition()
    {
        translate(-xPosition,-yPosition);
    }

    /**
     * /apply multiplier to the current scale
     */
    public void rescale(float scaleMultiplyer)
    {
        scale*= scaleMultiplyer;
        notifyObservers();
    }

    public  void resetScale()
    {
        rescale(1/scale);
    }
}
