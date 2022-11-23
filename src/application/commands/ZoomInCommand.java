package application.commands;

public class ZoomInCommand extends ZoomCommand{

    @Override
    public void execute() {
        //multiplier set to bet the inverse of zoom out
        reciver.rescale(1/(1+ZOOMSPEED));
    }
}
