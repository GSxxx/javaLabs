package wyp_lab08.BouncingBall;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Ball extends JComponent implements Runnable {

    private int x;
    private int y;
    private int dx;
    private int dy;
    private Rectangle bounds;
    private panelMain panel;

    Ball(JPanel panel) {
        bounds = panel.getBounds();
        this.panel = (panelMain) panel;
        Random rand = new Random();
        this.setX(rand.nextInt((int) bounds.getMaxX() - 50 - panelMain.thickness * 2) + (int) bounds.getMinX() + panelMain.thickness);
        this.setY(rand.nextInt((int) bounds.getMaxY() - 50 - panelMain.thickness * 2) + (int) bounds.getMinY() + panelMain.thickness);


//        this.setX(-55);
//        this.setY(-55);
        this.setDx(-6);
        this.setDy(9);

    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            move();
            repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void move() {
        setX(getX() + getDx());
        setY(getY() + getDy());


        if (getY() + 50 + panelMain.thickness >= bounds.getMaxY()) setDy(-getDy());
        if (getY() - panelMain.thickness < bounds.getMinY()) setDy(-getDy());
        if (getX() + 50 + panelMain.thickness >= bounds.getMaxX()) setDx(-getDx());
        if (getX() - panelMain.thickness < bounds.getMinX()) setDx(-getDx());

        if (!panel.getBounds().contains(this.getBounds())) {

//            Thread.currentThread().interrupt();//todo przy pierwszym obejsciu petli warunek jest zawsze prawda
//            System.out.println("wylaczylem");
//            panel.listOfBalls.remove(this);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.fillOval(this.getX(), this.getY(), 50, 50);
        this.setSize(50, 50);
        this.setLocation(this.getX(), this.getY());
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
