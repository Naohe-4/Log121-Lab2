package application.controller;

import application.model.ModelFacade;
import application.view.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.HashMap;

public class MouseControls implements MouseListener , MouseWheelListener {


    JPanel[] panels;
    HashMap<JPanel, Point> pressedPointInPanels = new HashMap<>();
    HashMap<JPanel, Point> releasedPointInPanels = new HashMap<>();
    ModelFacade facade;
    CommandHandler handler;

    public MouseControls() {
        this.facade = ModelFacade.getInstance();
        this.handler = CommandHandler.getInstance();
    }

    public MouseControls(JPanel[] panels) {
//        this.panels = panels;
//        for (int i = 0; i < panels.length; i++) {
//            pressedPointInPanels.put(panels[i],null);
//            releasedPointInPanels.put(panels[i],null);
//        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
//        for (int i = 0; i < panels.length; i++) {
//            pressedPointInPanels.put(panels[i],panels[i].getMousePosition());
//
//        }
        //System.out.println(e.getSource());
        ImagePanel panel = (ImagePanel) e.getSource();
        facade.setPerspectiveStartingPoint(panel.getId(), e.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        for (int i = 0; i < panels.length; i++) {
//            releasedPointInPanels.put(panels[i],panels[i].getMousePosition());
//        }
//        for (int i = 0; i < panels.length; i++)
//        {
//            Point from = pressedPointInPanels.get(panels[i]);
//            Point to = releasedPointInPanels.get(panels[i]);
//
//            if(from!=null && to!=null)
//            {
//                CommandHandler.getInstance().HandleTranslate(to.x- from.x,to.y -from.y );
//            }
//
//        }

        ImagePanel panel = (ImagePanel) e.getSource();

        Point movement = e.getPoint();
        Point origin = facade.getPerspectiveStartingPoint(panel.getId());

        int deltaX = movement.x - origin.x;
        int deltaY = movement.y - origin.y;

        CommandHandler.getInstance().HandleTranslate(panel.getId(), deltaX,deltaY);

       //Point imagePosition = facade.getPerspective(panel.getId()).getPosition();
       //facade.getPerspective(panel.getId()).setPosition( imagePosition.x + deltaX, imagePosition.y + deltaY);

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
//        int rot= e.getWheelRotation();
//
//        while (rot>0)
//        {
//            CommandHandler.getInstance().HandleZoomIn();
//            rot--;
//        }
//        while (rot<0)
//        {
//            CommandHandler.getInstance().HandleZoomOut();
//            rot++;
//        }
        float positiveMultiplier = 1.1f;
        float negativeMultiplier = 0.9f;
        ImagePanel panel = (ImagePanel) e.getSource();
        if (e.getPreciseWheelRotation() == 1.0){
            //facade.rescalePerspertive(panel.getId(), negativeMultiplier);
            CommandHandler.getInstance().HandleZoomIn(panel.getId());
        }else{
            //facade.rescalePerspertive(panel.getId(), positiveMultiplier);
            CommandHandler.getInstance().HandleZoomOut(panel.getId());
        }
        System.out.println(e.getPreciseWheelRotation());
    }
}
