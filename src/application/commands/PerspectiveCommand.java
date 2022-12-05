package application.commands;

import application.model.Perspective;


//command done on a perspective
public abstract class PerspectiveCommand extends Command {

    Perspective receiver;

    public PerspectiveCommand(Perspective receiver) {
        this.receiver = receiver;
    }


}
