package lab06.Shapes;

import lab06.UpgradedShape;

import java.awt.*;
import java.util.Random;

public class Rectangle extends UpgradedShape {
    private int width;
    private int height;
    private int x;
    private int y;
    private int alpha;
    private int color_r;
    private int color_g;
    private int color_b;

    public Rectangle() {
        Random rand = new Random();
        this.width = 60;
        this.height = 110;

        this.x = rand.nextInt(1280 - this.width);
        this.y = rand.nextInt(720 - this.height - 30);

        color_r = rand.nextInt(255);
        color_g = rand.nextInt(255);
        color_b = rand.nextInt(255);

        this.alpha = 255;
    }

    @Override
    public void draw(Graphics in) {
        in.setColor(new Color(color_r, color_g, color_b, alpha));
        in.fillRect(this.x, this.y, this.width, this.height);
        this.setSize(this.width, this.height);
        this.setLocation(this.x, this.y);
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

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
}
