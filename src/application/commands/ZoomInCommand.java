package application.commands;

import application.model.Perspective;

public class ZoomInCommand extends ZoomCommand{

    public ZoomInCommand(Perspective reciver) {
        super(reciver);
    }

    @Override
    public void execute() {
        //multiplier set to bet the inverse of zoom out
        receiver.rescale(1/(1+ZOOMSPEED));
    }
}
