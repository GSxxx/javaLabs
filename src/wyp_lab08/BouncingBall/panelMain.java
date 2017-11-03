package wyp_lab08.BouncingBall;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class panelMain extends JPanel {

    private LinkedList<Ball> listOfBalls = new LinkedList<>();
    static int thickness = 10;

    panelMain() {
        this.setPreferredSize(new Dimension(1280, 620));
        this.setBackground(Color.GRAY);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;


        g2.setStroke(new BasicStroke(thickness));
        g2.drawRect(thickness / 2, thickness / 2, this.getWidth() - thickness, this.getHeight() - thickness);

        for(Ball x : listOfBalls) x.paintComponent(g2);
    }

    void createBall(){
        repaint();    //todo why does it work?
        Ball new_ball = new Ball(this);
        this.add(new_ball);
        listOfBalls.add(new_ball);
        new Thread(new_ball).start();
    }



//
//    @Override
//    public void run() {
//        repaint();
//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
