package lab06.UpgradedShapes;


import lab06.UpgradedShapes.Shapes.Circle;
import lab06.UpgradedShapes.Shapes.Rectangle;
import lab06.UpgradedShapes.Shapes.Square;
import lab06.UpgradedShapes.Shapes.Triangle;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class UpgradedShape extends JComponent {
    protected int width;
    protected int height;
    protected int x;
    protected int y;
    protected int alpha;
    protected int color_r;
    protected int color_g;
    protected int color_b;

    public abstract void draw(Graphics in);


    static UpgradedShape createRandomOShape() {
        Random rand = new Random();
        int number = rand.nextInt(4) + 1;
        if (number == 1) return new Circle();
        if (number == 2) return new Rectangle();
        if (number == 3) return new Square();
        if (number == 4) return new Triangle();
        return null;
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

    void setAlpha(int alpha) {
        this.alpha = alpha;
    }
}
