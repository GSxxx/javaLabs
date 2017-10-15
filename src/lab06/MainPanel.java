package lab06;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MainPanel extends JPanel {
    private LinkedList<UpgradedShape> objectsList = new LinkedList<>();

    MainPanel() {
        super();

        for (int i = 0; i < 10; i++) {
            objectsList.add(UpgradedShape.createRandomOShape());
        }


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

//        Graphics2D g2 = (Graphics2D) g;
//        g2.drawRect(100, 100 , 400, 100);

        for (UpgradedShape x : objectsList) {
            x.draw(g);
        }
    }
}
