package application.commands;

import application.model.Perspective;


//command done on a perspective
public abstract class PerspectiveCommand extends Command {

    Perspective reciver;

    public PerspectiveCommand(Perspective reciver) {
        this.reciver = reciver;
    }


}
