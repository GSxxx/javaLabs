package lab02;

public class Punkt2D {
    private double x, y;

    Punkt2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    double getX() {

        return x;
    }

    double getY() {
        return y;
    }

    double distance(Punkt2D input) {
        return Math.sqrt(Math.pow(this.getX() - input.getX(), 2) + Math.pow(this.getY() - input.getY(), 2));
    }
}
