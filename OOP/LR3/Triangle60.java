package LR3;

import java.lang.Math;

public class Triangle60 extends Triangle {
    public Triangle60() {
        System.out.println("Triangle60 constructor was called");
        this.setFsl(5);
        this.setSsl(5);
        this.setAngle(60 * Math.PI / 180.0);
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = 3 * getFsl();
        return perimeter;
    }

    @Override
    public double calculateSquare() {
        double square = (Math.pow(getFsl(), 2) * Math.sqrt(3)) / 4.0;
        return square;
    }
}
