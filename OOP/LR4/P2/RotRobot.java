package P2;

public class RotRobot extends Robot implements Rotatable {
    private int start_angle;
    private int end_angle;
    protected boolean movingForward = true;
    protected boolean isDone = false;

    RotRobot() {
        start_angle = 0;
        end_angle = 0;
        course = 0;
    }

    RotRobot(int sai, int eai) {
        start_angle = sai % 360;
        end_angle = eai % 360;
        course = start_angle;
        movingForward = (start_angle <= end_angle);
    }

    @Override
    public void doSomething() {
        System.out.println("RotRobot: Searching for next angle. " + getPosition());
    }

    @Override
    public void rotateForward() {
        course = (course + step_angle) % 360;
    }

    @Override
    public void rotateBackward() {
        course = (course - step_angle + 360) % 360;
    }

    @Override
    public void move() {
        if (isDone) {
            System.out.println("RotRobot: Cycle complete. Waiting.");
            return;
        }

        doSomething();

        if (movingForward) {
            if (course == end_angle) {
                movingForward = false;
                isDone = true;
                System.out.println("RotRobot: Reached END_ANGLE. Reversing direction.");
                return;
            }
        } else {
            if (course == start_angle) {
                movingForward = true;
                System.out.println("RotRobot: Reached START_ANGLE. Cycle finished.");
                return;
            }
        }

        if (movingForward) {
            rotateForward();
        } else {
            rotateBackward();
        }

        System.out.println("RotRobot: New course is " + course + "°");
    }

    public boolean getIsDone() {
        return isDone;
    }
}