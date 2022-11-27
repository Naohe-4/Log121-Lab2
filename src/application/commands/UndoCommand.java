package application.commands;

import application.CareTaker;

public class UndoCommand extends RecordCommand{


    public UndoCommand(CareTaker reciever) {
        super(reciever);
    }

    @Override
    public void execute() {
        reciever.Undo();
    }
}
