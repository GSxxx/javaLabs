package lab06;

import lab06.Shapes.Rectangle;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
    private Point p;

    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("Clicked!");
//        ((lab06.Shapes.Rectangle)e.getComponent()).setX(100);
//        ((lab06.Shapes.Rectangle)e.getComponent()).setY(100);
//        e.getComponent().paint(e.getComponent().getGraphics());
    }

    public void mousePressed(MouseEvent e) {
        p = e.getPoint();
        ((UpgradedShape)e.getComponent()).setAlpha(100);
        e.getComponent().repaint();
    }

    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        ((UpgradedShape) e.getComponent()).setX(e.getComponent().getX() + e.getX() - p.x);
        ((UpgradedShape) e.getComponent()).setY(e.getComponent().getY() + e.getY() - p.y);
        ((UpgradedShape)e.getComponent()).setAlpha(255);
        e.getComponent().repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        ((UpgradedShape) e.getComponent()).setX(e.getComponent().getX() + e.getX() - p.x);
        ((UpgradedShape) e.getComponent()).setY(e.getComponent().getY() + e.getY() - p.y);
        e.getComponent().repaint();
    }

}
