package LR3;

import java.lang.Math;

public class Triangle {
    private double fsl;
    private double ssl;
    private double angle;

    public Triangle() {
        System.out.println("Triangle constructor was called");
        this.fsl = 5;
        this.ssl = 5;
        this.angle = 30 * Math.PI / 180.0;
    }

    public Triangle(double fsl, double ssl, double angleDegrees) {
        System.out.println("Triangle constructor was called");

        this.fsl = fsl;
        this.ssl = ssl;
        this.angle = angleDegrees * Math.PI / 180.0;
    }

    public void setFsl(double len) {
        this.fsl = len;
    }

    public void setSsl(double len) {
        this.ssl = len;
    }

    public void setAngle(double angleDegrees) {
        this.angle = angleDegrees * Math.PI / 180.0;
    }

    public double getFsl() {
        return this.fsl;
    }

    public double getSsl() {
        return this.ssl;
    }

    public double getAngle() {
        return this.angle;
    }

    public double calculatePerimeter() {
        double thirdSideSquared = Math.pow(fsl, 2) + Math.pow(ssl, 2) -
                2 * fsl * ssl * Math.cos(angle);

        double thirdSide = Math.sqrt(thirdSideSquared);

        double perimeter = fsl + ssl + thirdSide;

        return perimeter;
    }

    public double calculateSquare() {
        double square = (fsl * ssl * Math.sin(angle)) / 2;

        return square;
    }

    public void getInfo() {
        System.out.println("Perimeter of triangle: " + calculatePerimeter());
        System.out.println("Square of triangle: " + calculateSquare());
    }
}