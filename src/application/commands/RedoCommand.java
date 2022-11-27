package application.commands;

import application.CareTaker;

public class RedoCommand extends RecordCommand{


    public RedoCommand(CareTaker reciever) {
        super(reciever);
    }

    @Override
    public void execute() {
        reciever.Redo();
    }
}
