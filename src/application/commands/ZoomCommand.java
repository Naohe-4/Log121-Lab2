package application.commands;

import application.model.Perspective;

public abstract class ZoomCommand extends PerspectiveCommand {

    final protected float ZOOMSPEED = 0.1f;


    public ZoomCommand(Perspective reciver) {
        super(reciver);
    }
}
