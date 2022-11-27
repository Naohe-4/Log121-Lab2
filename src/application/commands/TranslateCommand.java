package application.commands;

import application.model.Perspective;

public class TranslateCommand extends PerspectiveCommand{

    int x,y;


    public TranslateCommand(Perspective reciver,int x,int y) {
        super(reciver);
        this.x=x;
        this.y=y;
    }

    @Override
    public void execute() {
        reciver.translate(x,y);
    }
}
