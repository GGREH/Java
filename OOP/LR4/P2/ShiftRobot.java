package P2;

public class ShiftRobot extends Robot implements Shiftable {
    private int start_pos_x;
    private int start_pos_y;
    private int end_pos_x;
    private int end_pos_y;
    private boolean movingToStart = false;

    ShiftRobot() {
        this(0, 0, 0, 0, 0);
    }

    ShiftRobot(int sx, int sy, int ex, int ey, int ci) {
        course = (ci / 90) * 90 % 360;
        x = sx;
        y = sy;
        start_pos_x = sx;
        start_pos_y = sy;
        end_pos_x = ex;
        end_pos_y = ey;
    }

    @Override
    public void doSomething() {
        System.out.println("ShiftRobot: Scanning environment. " + getPosition());
    }

    private void applyShift(int direction) {
        int dx = 0;
        int dy = 0;

        switch (course) {
            case 0:
                dx = direction * step_shift;
                break;
            case 90:
                dy = direction * step_shift;
                break;
            case 180:
                dx = direction * step_shift * (-1);
                break;
            case 270:
                dy = direction * step_shift * (-1);
                break;
            default:
                System.err.println("Error: Invalid course for ShiftRobot!");
                return;
        }
        x += dx;
        y += dy;
    }

    @Override
    public void shiftForward() {
        applyShift(1);
    }

    @Override
    public void shiftBackward() {
        applyShift(-1);
    }

    @Override
    public void move() {
        doSomething();

        if (x == end_pos_x && y == end_pos_y && !movingToStart) {
            movingToStart = true;
            System.out.println("ShiftRobot: Reached END_POS. Reversing to start.");
            return;
        } else if (x == start_pos_x && y == start_pos_y && movingToStart) {
            movingToStart = false;
            System.out.println("ShiftRobot: Reached START_POS. Reversing to end.");
            return;
        }

        int target_x = movingToStart ? start_pos_x : end_pos_x;
        int target_y = movingToStart ? start_pos_y : end_pos_y;

        int dx = target_x - x;
        int dy = target_y - y;

        if (dx == 0 && dy == 0) {
            System.out.println("ShiftRobot: Currently at target. Waiting for move() to be called again.");
            return;
        }

        boolean moved = false;

        if (dx != 0 && (course == 0 || course == 180)) {
            if ((course == 0 && dx > 0) || (course == 180 && dx < 0)) {
                shiftForward();
            } else {
                shiftBackward();
            }
            moved = true;
        }

        else if (dy != 0 && (course == 90 || course == 270)) {
            if ((course == 90 && dy > 0) || (course == 270 && dy < 0)) {
                shiftForward();
            } else {
                shiftBackward();
            }
            moved = true;
        }

        if (!moved) {
            if (Math.abs(dx) > Math.abs(dy)) {
                if (dx > 0) {
                    course = 0;
                    shiftForward();
                } else {
                    course = 180;
                    shiftForward();
                }
            } else {
                if (dy > 0) {
                    course = 90;
                    shiftForward();
                } else {
                    course = 270;
                    shiftForward();
                }
            }
        }
    }
}