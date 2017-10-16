package lab06.UpgradedShapes;


import lab06.UpgradedShapes.Shapes.Circle;
import lab06.UpgradedShapes.Shapes.Rectangle;
import lab06.UpgradedShapes.Shapes.Square;
import lab06.UpgradedShapes.Shapes.Triangle;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class UpgradedShape extends JComponent {

    public abstract void draw(Graphics in);
    public abstract int getX();
    public abstract int getY();
    public abstract void setX(int x);
    public abstract void setY(int y);
    public abstract void setAlpha(int alpha);


    static UpgradedShape createRandomOShape() {
        Random rand = new Random();
        int number = rand.nextInt(4) + 1;
        if (number == 1) return new Circle();
        if (number == 2) return new Rectangle();
        if (number == 3) return new Square();
        if (number == 4) return new Triangle();
        return null;
    }
}
