package application;

import application.controller.CommandHandler;
import application.model.Memento;
import application.model.ModelFacade;

import java.util.Stack;

public class CareTaker {


    private static CareTaker instance;
    Stack<Memento> safeStack = new Stack<>();
    Stack<Memento> dangerStack = new Stack<>();

    private CareTaker()
    {
        AddNew(ModelFacade.getInstance().TakeSnapshot());
    }

    public static CareTaker getInstance()
    {
        if(instance==null)
        {
            instance=new CareTaker();
        }
        return instance;
    }

    //internal data manipulation
    private Memento MoveUp() {
        Memento activeMemory = null;
        Memento lastState;
        System.out.println("moving up");

        if (dangerStack.isEmpty()) {
            if (!safeStack.isEmpty()) {
                activeMemory = safeStack.peek();
                System.out.println("peeking");

            }
        } else {
            lastState = dangerStack.pop();
            safeStack.push(lastState);
            if(!safeStack.isEmpty())
            {
                activeMemory=safeStack.peek();
            }
            System.out.println("poping");

        }

        return activeMemory;
    }

    private Memento MoveDown() {
        Memento activeMemory = null;
        Memento lastState;

        System.out.println("moving down");

        if (safeStack.isEmpty()) {
            if (!dangerStack.isEmpty()) {
                activeMemory = dangerStack.peek();
                System.out.println("peeking");

            }

        } else {
            lastState = safeStack.pop();
            dangerStack.push(lastState);

            if(!safeStack.isEmpty()) {
                activeMemory = safeStack.peek();
            }
            System.out.println("poping");

        }

        return activeMemory;
    }


    //external services
    public void AddNew(Memento memory) {
        System.out.println(safeStack.size());
        System.out.println(dangerStack.size());
        safeStack.push(memory);
        dangerStack.clear();


    }
    public void Redo() {
        Memento memory = MoveUp();

        if (memory != null) {
            memory.Load();
        }
    }

    public void Undo() {
        Memento memory = MoveDown();

        if (memory != null) {
            memory.Load();
        }
    }

}
