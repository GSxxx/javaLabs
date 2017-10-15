package lab06.Shapes;

import lab06.UpgradedShape;

import java.awt.*;
import java.util.Random;

public class Triangle extends UpgradedShape{
    @Override
    public void draw(Graphics in) {
        Random rand = new Random();
        in.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), 255));
        in.drawPolygon(new int[] {10, 20, 30}, new int[] {100, 20, 100}, 3);
    }
}
