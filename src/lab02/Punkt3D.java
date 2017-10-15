package lab02;

public class Punkt3D extends Punkt2D {
    private double z;

    Punkt3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    double distance(Punkt3D input) {
        return  Math.sqrt(Math.pow(this.getX() - input.getX(), 2)
                + Math.pow(this.getY() - input.getY(), 2)
                + Math.pow(this.getZ() - input.getZ(), 2));
    }
}
