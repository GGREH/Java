package Java.OOP.IR3;

public class Model {
    public double calculateArea(double length, double width) {
        return length *
                width;
    }

    public double calculatePerimeter(double length, double width) {
        return 2 *
                (length + width);
    }

    public double calculateDiagonal(double length, double width) {
        return Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2));
    }
}