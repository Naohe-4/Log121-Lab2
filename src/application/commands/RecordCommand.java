package application.commands;

import application.CareTaker;

public abstract class RecordCommand extends Command{

    CareTaker reciever;

    public RecordCommand(CareTaker reciever)
    {
        this.reciever=reciever;
    }

}
