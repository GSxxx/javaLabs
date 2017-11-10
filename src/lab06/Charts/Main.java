package lab06.Charts;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame {


    private Main() {
        super("Polynomial");
        int windowWidth = 1280;
        int windowHeight = 820;

        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        this.setBounds((width - windowWidth) / 2, (height - windowHeight) / 2, windowWidth, windowHeight);

        this.setBackground(Color.WHITE);
        Container container = this.getContentPane();

        container.add(new DrawingPanel(0.1, -2, 3, 1, -1, -2, 0));
//        container.add(new DrawingPanel(1, -10, 10, 2, 0, -1), BorderLayout.PAGE_END);
//        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
    }


    public static void main(String[] args) {
        new Main().setVisible(true);
    }


}
