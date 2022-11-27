package application.commands;

import application.model.Perspective;

public abstract class PerspectiveCommand extends Command {

    Perspective reciver;

    public PerspectiveCommand(Perspective reciver) {
        this.reciver = reciver;
    }


}
