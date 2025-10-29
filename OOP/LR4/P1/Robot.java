package P1;

public class Robot {
    protected int x;
    protected int y;
    protected int course;

    Robot() {
        x = 0;
        y = 0;
        course = 0;
    }

    Robot(int xi, int yi, int ci) {
        x = xi;
        y = yi;
        course = ci;
    }

    public void doSomething() {
        System.out.println("Robot does something");
    }
}