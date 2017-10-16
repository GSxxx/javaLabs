package lab06;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MainPanel extends JPanel {
    private LinkedList<UpgradedShape> objectsList = new LinkedList<>();

    MainPanel() {
        super();
        this.setBackground(Color.GRAY);

        for (int i = 0; i < 20; i++) {
            objectsList.add(UpgradedShape.createRandomOShape());

            MouseListener listener = new MouseListener();
            objectsList.get(i).addMouseListener(listener);
            objectsList.get(i).addMouseMotionListener(listener);

            this.add(objectsList.get(i));
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (UpgradedShape x : objectsList) {
            x.draw(g);
        }
    }


}
