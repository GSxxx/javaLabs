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

    Ball(JPanel panel) {
        bounds = panel.getBounds();

//        Random rand = new Random();
//        this.setX(rand.nextInt(1200) + 20);
//        this.setY(rand.nextInt(600) + 20);

        this.setX(500);
        this.setY(300);
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
//            System.out.println("im moving");
//            System.out.println(this.getX());
//            System.out.println(this.getY());
        }
    }

    private void move() {
        setX(getX() + getDx());
        setY(getY() + getDy());


        if (getY() + 50 + panelMain.thickness >= bounds.getMaxY()) setDy(-getDy());
        if (getY() - panelMain.thickness < bounds.getMinY()) setDy(-getDy());
        if (getX() + 50 + panelMain.thickness >= bounds.getMaxX()) setDx(-getDx());
        if (getX() - panelMain.thickness < bounds.getMinX()) setDx(-getDx());

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
