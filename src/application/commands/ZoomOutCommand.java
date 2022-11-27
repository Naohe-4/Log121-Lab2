package application.commands;

import application.model.Perspective;

public class ZoomOutCommand extends ZoomCommand {


    public ZoomOutCommand(Perspective reciver) {
        super(reciver);
    }

    @Override
    public void execute() {
        reciver.rescale(1 + ZOOMSPEED);
    }
}
