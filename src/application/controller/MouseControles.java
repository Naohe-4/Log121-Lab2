package application.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.HashMap;

public class MouseControles implements MouseListener , MouseWheelListener {


    JPanel[] panels;
    HashMap<JPanel, Point> pressedPointInPanels = new HashMap<>();
    HashMap<JPanel, Point> releasedPointInPanels = new HashMap<>();

    public MouseControles(JPanel[] panels) {
        this.panels = panels;
        for (int i = 0; i < panels.length; i++) {
            pressedPointInPanels.put(panels[i],null);
            releasedPointInPanels.put(panels[i],null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < panels.length; i++) {
            pressedPointInPanels.put(panels[i],panels[i].getMousePosition());

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (int i = 0; i < panels.length; i++) {
            releasedPointInPanels.put(panels[i],panels[i].getMousePosition());
        }
        for (int i = 0; i < panels.length; i++)
        {
            Point from = pressedPointInPanels.get(panels[i]);
            Point to = releasedPointInPanels.get(panels[i]);

            if(from!=null && to!=null)
            {
                CommandHandler.getInstance().HandleTranslate(to.x- from.x,to.y -from.y );
            }

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int rot= e.getWheelRotation();

        while (rot>0)
        {
            CommandHandler.getInstance().HandleZoomIn();
            rot--;
        }
        while (rot<0)
        {
            CommandHandler.getInstance().HandleZoomOut();
            rot++;
        }
    }
}
