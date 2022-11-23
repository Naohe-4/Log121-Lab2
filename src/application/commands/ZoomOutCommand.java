package application.commands;

public class ZoomOutCommand extends ZoomCommand {


    @Override
    public void execute() {
        reciver.rescale(1 + ZOOMSPEED);
    }
}
