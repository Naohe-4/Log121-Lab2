package application.controller;

import application.CareTaker;
import application.commands.*;
import application.model.ModelFacade;
import application.model.Perspective;

import javax.swing.*;

public class CommandHandler {

    private static CommandHandler instance;

    public static CommandHandler getInstance()
    {
        if(instance==null)
        {
            instance=new CommandHandler();
        }
        return instance;

    }

    private CommandHandler()
    {

    }


    CareTaker careTaker;

    Perspective activePerspective;


    ///caretaker commands
    public void HandleUndo() {
        Command c = new UndoCommand(careTaker);
        c.execute();
    }

    public void HandleRedo() {
        Command c = new RedoCommand(careTaker);
        c.execute();
    }


    ///perspective commands
    public void HandleZoomIn() {
        Command c = new ZoomInCommand(activePerspective);
        c.execute();
        careTaker.AddNew(ModelFacade.getInstance().TakeSnapshot());
    }
    public void HandleZoomOut() {
        Command c = new ZoomOutCommand(activePerspective);
        c.execute();
        careTaker.AddNew(ModelFacade.getInstance().TakeSnapshot());
    }
    public void HandleTranslate(int x,int y) {
        Command c = new TranslateCommand(activePerspective,x,y);
        c.execute();
        careTaker.AddNew(ModelFacade.getInstance().TakeSnapshot());
    }

}
