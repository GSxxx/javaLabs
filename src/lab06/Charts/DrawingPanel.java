package lab06.Charts;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;

class DrawingPanel extends JPanel {

    private double[] data;

    private int from;
    private double sampling;
    private int shift = 70; // shift downwards

    DrawingPanel(double sampling, int from, int to, int... input) {
        this.from = from;
        this.sampling = sampling;
        this.setSize(new Dimension(1280, 720));
        int dataLength = (int) ((to - from) / sampling + 1);
        this.setBackground(Color.WHITE);
        data = new double[dataLength];
        for (int i = 0; i < dataLength; i++) {
            double output = 0;
            for (int j = 0; j < input.length; j++) {
                output += input[j] * Math.pow(from + sampling * i, input.length - 1 - j);
            }
            data[i] = output;
        }
    }

    @Override
    public void paint(Graphics g) {
        //horizontal scaling
        double xScale = 1230 / data.length;

        //vertical scaling
        double yMinimum = getMin(data);
        double yMaximum = getMax(data);
        double yScale = 720 / (yMaximum - yMinimum);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(50, 0, 50, 720 + shift);
        g2.drawLine(0, 660 + shift, 1280, 660 + shift);


        //horizontal grid
        g2.setStroke(new BasicStroke(1));

        for (int i = 0; i < data.length; i++) {
            int x = (int) (i * xScale) + 50;
            g2.setColor(Color.GREEN);
            g2.setStroke(new BasicStroke(1));
            g2.drawLine(x, shift - 100, x, 670 + shift);
            //labels
            g2.setColor(Color.BLUE);
            g2.setFont(new Font("Serif", Font.BOLD, 14));
            g2.drawString(Double.toString(from + sampling * i), x - 5, 685 + shift);

            if(from + sampling * i == 0) g2.drawLine(x, shift - 100, x, 670 + shift);
        }
        //vertical grid
        g2.setStroke(new BasicStroke(1));

        for (int i = 0; i <= 20; i++) {
            int y = 720 / 20 * i; // 20 - amount of vertical lines
            y = 660 - y + shift;
            g2.setColor(Color.GREEN);
            g2.drawLine(35, y, 1280, y);
            //labels
            g2.setColor(Color.BLUE);
            g2.drawString(Integer.toString((int) (yMinimum + (yMaximum - yMinimum) / 20 * i)), 10, y + 5);

            if(yMinimum + (yMaximum - yMinimum) / 20 * i == 0) g2.drawLine(35, y, 1280, y);
        }

        //plot
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(8));

        int xPrev = -1, yPrev = -1;
        for (int i = 0; i < data.length; i++) {
            int x = (int) (i * xScale) + 50;
            int y = (int) ((data[i] - yMinimum) * yScale);
            y = 660 - y + shift;

            if (xPrev != -1) {
                g2.drawLine(xPrev, yPrev, x, y);
            }
            xPrev = x;
            yPrev = y;
        }
    }


    private double getMax(double[] input) {
        double max = input[0];
        for (double x : input) {
            if (x > max) max = x;
        }
        return max;
    }

    private double getMin(double[] input) {
        double min = input[0];
        for (double x : input) {
            if (x < min) min = x;
        }
        return min;
    }
}