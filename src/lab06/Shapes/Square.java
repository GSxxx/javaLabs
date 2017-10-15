package lab06.Shapes;

import lab06.UpgradedShape;

import java.awt.*;
import java.util.Random;

public class Square extends UpgradedShape {
    @Override
    public void draw(Graphics in) {
        Random rand = new Random();
        in.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), 255));
        in.fillRect(rand.nextInt(1100)+60, rand.nextInt(540)+60, 120, 120);
    }
}
