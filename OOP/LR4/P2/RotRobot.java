package P2;

public class RotRobot extends Robot implements Rotatable {
    protected int start_angle;
    protected int end_angle;

    RotRobot() {
        start_angle = 0;
        end_angle = 0;
    }

    RotRobot(int xi, int yi, int ci) {
        super(xi, yi, ci);
        start_angle = ci;
    }

    public void setStart_angle(int start_angle) {
        this.start_angle = start_angle;
    }

    public void setEnd_angle(int end_angle) {
        if (end_angle % 90 != 0)
            end_angle = 0;
        this.end_angle = end_angle;
    }

    public int getStart_angle() {
        return start_angle;
    }

    public int getEnd_angle() {
        return end_angle;
    }

    @Override
    public void doSomething() {
        System.out.println("RotRobot does something");
    }

    @Override
    public void move() {
        if (start_angle > end_angle) {
            while (end_angle != start_angle) {
                rotateForward();
                doSomething();
                start_angle -= step_angle;
                if (start_angle < 0) {
                    start_angle += 360;
                    end_angle += 360;
                }
            }
        } else if (start_angle < end_angle) {
            while (end_angle != start_angle) {
                rotateBackward();
                doSomething();
                start_angle += step_angle;
                if (start_angle >= 360) {
                    start_angle -= 360;
                    end_angle -= 360;
                }
            }
        } else {
            System.out.print("RotRobot is here");
        }
        doSomething();
    }

    @Override
    public void rotateBackward() {
        if (course + step_angle >= 360) {
            course = course + step_angle - 360;
        } else {
            course += step_angle;
        }
    }

    @Override
    public void rotateForward() {
        if (course - step_angle < 0) {
            course = course + 360 - step_angle;
        } else {
            course -= step_angle;
        }
    }

    public void location() {
        System.out.println("ShiftRobot's position (" + x + ";" + y + ") and course " + course + " degrees");
    }
}
