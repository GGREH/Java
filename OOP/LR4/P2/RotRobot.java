package P2;

public class RotRobot extends Robot implements Rotetable {
    protected int start_angle;
    protected int end_angle;
    public boolean MovingToEnd = true;

    RotRobot() {
        start_angle = 0;
        end_angle = 0;
    }

    RotRobot(int xi, int yi, int ci, int ei) {
        super(xi, yi, ci);
        this.start_angle = ci;
        this.end_angle = ei;
    }

    public int getStart_angle() {
        return start_angle;
    }

    public int getEnd_angle() {
        return end_angle;
    }

    public void setStart_angle(int start_angle) {
        if (start_angle % 90 == 0) {
            this.start_angle = start_angle;
        } else {
            System.out.println("Invalid start_angle value! Will be set as 0");
            this.start_angle = 0;
        }
    }

    public void setEnd_angle(int end_angle) {
        if (end_angle % 90 == 0) {
            this.end_angle = end_angle;
        } else {
            System.out.println("Invalid end_angle value! Will be set as 0");
            this.end_angle = 0;
        }
    }

    @Override
    public void doSomething() {
        System.out.println("RotRobot is doing something");
    }

    @Override
    public void rotateForward() {
        if (course + step_angle >= 360) {
            course = course + step_angle - 360;
        } else {
            course = course + step_angle;
        }
    }

    @Override
    public void rotateBackward() {
        if (course - step_angle <= 0) {
            course = course - step_angle + 360;
        } else {
            course = course - step_angle;
        }
    }

    @Override
    public void move() {

        System.out.println("We start moving from the start to the end angle");

        if (course > end_angle) {
            while (course != end_angle) {
                rotateBackward();
                doSomething();
            }
        }

        else if (course < end_angle) {
            while (course != end_angle) {
                rotateForward();
                doSomething();
            }
        }
        System.out.println("RotRobot is on the end angle");
        getPosition();

        System.out.println("We start moving from the end to the start angle");
        MovingToEnd = false;

        if (course > start_angle) {
            while (course != start_angle) {
                rotateBackward();
                doSomething();
            }
        }

        else if (course < start_angle) {
            while (course != start_angle) {
                rotateForward();
                doSomething();
            }
        }
        System.out.println("RotRobot is on the start angle");
        getPosition();
    }
}
