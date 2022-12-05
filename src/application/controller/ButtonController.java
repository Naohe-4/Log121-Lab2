package application.controller;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelListener;

public class ButtonController implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Button Clicked");

        JButton button = (JButton)e.getSource();
        System.out.println(button.getText());
        switch (button.getText())
        {
            case "Undo":
            {
                CommandHandler.getInstance().HandleUndo();
                break;
            }
            case "Redo":
            {
                CommandHandler.getInstance().HandleRedo();
                break;
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
