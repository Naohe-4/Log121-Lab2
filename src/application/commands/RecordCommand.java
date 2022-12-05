package application.commands;

import application.CareTaker;


//command done on the careTaker
public abstract class RecordCommand extends Command{

    CareTaker reciever;

    public RecordCommand(CareTaker reciever)
    {
        this.reciever=reciever;
    }

}
