package application;

import java.util.Stack;

public class CareTaker {


    Stack<Memento> safeStack = new Stack<>();
    Stack<Memento> dangerStack = new Stack<>();


    public void AddNew(Memento memory) {
        safeStack.push(memory);
        dangerStack.clear();

    }

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


    public void Redo() {
        Memento memory = MoveUp();

        if (memory != null) {
            //apply memory
        }
    }

    public void Undo() {
        Memento memory = MoveDown();

        if (memory != null) {
            //apply memory
        }
    }

}
