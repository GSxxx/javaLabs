package wyp_lab08.BouncingBall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class panelButtons extends JPanel {

    panelButtons(int width,int height, panelMain mainScreen) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.YELLOW);

        JButton start = (JButton) this.add(new JButton("Start"));
//        start.setLocation(this.getX() + this.getWidth() / 2, this.getY() + this.getHeight()/2+ 60);
        start.addActionListener((ActionEvent e) -> {
            mainScreen.createBall();
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.RED);
        int thickness = 10;
        g2.setStroke(new BasicStroke(thickness));
        g2.drawRect(thickness / 2 ,thickness / 2, this.getWidth() - thickness, this.getHeight() - thickness);


        System.out.println("buttons: "+this.getWidth());
        System.out.println(this.getHeight());
    }
}
