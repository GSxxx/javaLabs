package wyp_lab08.BouncingBall;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private Main() {
        this.setTitle("Bouncing Ball");
        int windowWidth = 1280;
        int windowHeight = 720;

        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
//        this.setLocation((width - windowWidth) / 2, (height - windowHeight) / 2);
        this.setBounds((width - windowWidth) / 2, (height - windowHeight) / 2, windowWidth, windowHeight);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        Container mainScreen = new panelMain();
//        new Thread((panelMain) mainScreen).start();
        Container panelButtons = new panelButtons(windowWidth, this.getBounds().height - 620 - 38, (panelMain) mainScreen);

        this.getContentPane().add(mainScreen, BorderLayout.NORTH);
        this.getContentPane().add(panelButtons, BorderLayout.SOUTH);

    }


    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
