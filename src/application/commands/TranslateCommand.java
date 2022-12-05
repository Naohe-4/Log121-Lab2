package application.commands;

import application.model.Perspective;

public class TranslateCommand extends PerspectiveCommand{

    int x,y;


    public TranslateCommand(Perspective receiver,int x,int y) {
        super(receiver);
        this.x=x;
        this.y=y;
    }

    @Override
    public void execute() {
        receiver.translate(x,y);
    }
}
