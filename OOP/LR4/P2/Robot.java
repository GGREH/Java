package P2;

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
            this.course = 0;
        }
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

    public void location() {
        System.out.println("Robot's position (" + x + ";" + y + ") and course " + course + " degrees");
    }

    public void doSomething() {
        System.out.println("Robot does something");
    }
}