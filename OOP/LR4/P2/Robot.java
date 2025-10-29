package P2;

public class Robot {
    protected int x;
    protected int y;
    protected int course;

    Robot() {
        this.x = 0;
        this.y = 0;
        this.course = 0;
    }

    Robot(int xi, int yi, int ci) {
        this.x = xi;
        this.y = yi;
        this.course = ci;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCourse() {
        return course;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCourse(int course) {
        if (course % 90 == 0 && course < 360 && course >= 0) {
            this.course = course;
        } else {
            System.out.println("Invalid course value! Will be set as 0");
            this.course = 0;
        }
    }

    public void doSomething() {
        System.out.println("Robot is doing something");
    }

    public void getPosition() {
        System.out.println("Robot is on (" + x + ", " + y + "), course: " + course);
    }
}
