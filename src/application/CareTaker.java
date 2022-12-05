package application;

import application.controller.CommandHandler;
import application.model.Memento;

import java.util.Stack;

public class CareTaker {


    private static CareTaker instance;
    Stack<Memento> safeStack = new Stack<>();
    Stack<Memento> dangerStack = new Stack<>();

    private CareTaker()
    {

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

        if (dangerStack.empty()) {
            if (!safeStack.empty()) {
                activeMemory = safeStack.peek();
            }
        } else {
            activeMemory = dangerStack.pop();
            safeStack.push(activeMemory);
        }

        return activeMemory;
    }

    private Memento MoveDown() {
        Memento activeMemory = null;

        if (safeStack.empty()) {
            if (!dangerStack.empty()) {
                activeMemory = dangerStack.peek();
            }

        } else {
            activeMemory = safeStack.pop();
            dangerStack.push(activeMemory);
        }

        return activeMemory;
    }


    //external services
    public void AddNew(Memento memory) {
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
