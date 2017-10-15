package lab06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main extends JFrame {

    private Main() {
        super("Shapes");
        int windowWidth = 1280;
        int windowHeight = 720;

        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        this.setBounds((width - windowWidth) / 2, (height - windowHeight) / 2, windowWidth, windowHeight);



        MainPanel drawPanel = new MainPanel();
        this.getContentPane().add(drawPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

}
