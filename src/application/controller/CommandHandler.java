package application.controller;

import application.CareTaker;
import application.commands.*;
import application.model.ModelFacade;
import application.model.Perspective;

import javax.swing.*;

public class CommandHandler {

    private static CommandHandler instance;
    CareTaker careTaker;
    Perspective activePerspective;


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
    public void HandleZoomIn(int id) {
        Command c = new ZoomInCommand(ModelFacade.getInstance().getPerspective(id));
        c.execute();
        careTaker.AddNew(ModelFacade.getInstance().TakeSnapshot());
    }
    public void HandleZoomOut(int id) {
        Command c = new ZoomOutCommand(ModelFacade.getInstance().getPerspective(id));
        c.execute();
        careTaker.AddNew(ModelFacade.getInstance().TakeSnapshot());
    }
    public void HandleTranslate(int id,int x,int y) {
        Command c = new TranslateCommand(ModelFacade.getInstance().getPerspective(id),x,y);
        c.execute();
        careTaker.AddNew(ModelFacade.getInstance().TakeSnapshot());
    }

}
