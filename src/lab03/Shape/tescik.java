package lab03.Shape;

public class tescik {
    public static void main(String[] args){
        Shape[] a= {new Circle(),new Rectangle(),new Triangle(),new Square()};
        for(Shape x : a){
            x.draw();
        }
    }
}
