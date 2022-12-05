package application.model;

import java.awt.*;
import java.io.Serializable;
import java.util.Observable;


public class Perspective extends Observable implements Serializable {


    float scale = 1;
    int xPosition = 0;//distance from origin (pixel)
    int yPosition = 0;//distance from origin (pixel)
    Point startingPoint;

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public float getScale() {
        return scale;
    }


    public Perspective() {
    }

    ;

    public Perspective(int x, int y, float scale) {
        this.scale = scale;
        xPosition = x;
        yPosition = y;
    }

    public void translate(int x, int y) {
        xPosition += x;
        yPosition += y;
        this.setChanged();
        notifyObservers();
    }

    public void resetPosition() {
        translate(-xPosition, -yPosition);
    }


    //A retirer quand command va etre mis en place.
    public void setPosition(int x, int y){
        this.xPosition = x;
        this.yPosition = y;
        this.setChanged();
        notifyObservers();
    }

    public Point getPosition(){
        return new Point(this.xPosition, this.yPosition);
    }

    /**
     * /apply multiplier to the current scale
     */
    public void rescale(float scaleMultiplyer) {
        scale *= scaleMultiplyer;
        this.setChanged();
        notifyObservers();
    }

    public Point getStartingPos() {
        return startingPoint;
    }

    public void setStartingPos(Point startingPoint) {
        this.startingPoint = startingPoint;
    }

    public void resetScale() {
        rescale(1 / scale);
    }
}
