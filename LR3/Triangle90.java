package LR3;

import java.lang.Math;

public class Triangle90 extends Triangle {
    public Triangle90() {

        System.out.println("Triangle90 constructor was called");
        this.setFsl(5);
        this.setSsl(5);
        this.setAngle(90 * Math.PI / 180.0);
    }

    @Override
    public double calculatePerimeter() {
        double tsl = Math.sqrt(Math.pow(getFsl(), 2) + Math.pow(getSsl(), 2));
        double perimeter = getFsl() + getSsl() + tsl;
        return perimeter;
    }

    @Override
    public double calculateSquare() {
        double square = (getFsl() * getSsl()) / 2.0;
        return square;
    }
}
