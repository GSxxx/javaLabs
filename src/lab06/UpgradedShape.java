package lab06;


import lab06.Shapes.Circle;
import lab06.Shapes.Rectangle;
import lab06.Shapes.Square;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class UpgradedShape{
    public abstract void draw(Graphics in);

    static UpgradedShape createRandomOShape(){
        Random rand = new Random();
        int number = rand.nextInt(3)+1;
        if(number == 1) return new Circle();
        if(number == 2) return new Rectangle();
        if(number == 3) return new Square();
        return null;
    }
}
