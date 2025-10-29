package P2;

public class ShiftRobot extends Robot implements Shiftable {
    protected int start_x, start_y;
    protected int end_x, end_y;

    public ShiftRobot() {
        super();
        this.start_x = 0;
        this.start_y = 0;
        this.end_x = 0;
        this.end_y = 0;
    }

    public ShiftRobot(int start_x, int start_y, int end_x, int end_y, int course) {
        super(start_x, start_y, course);
        this.start_x = start_x;
        this.start_y = start_y;
        this.end_x = end_x;
        this.end_y = end_y;
        setCourse(course);
    }

    public int getStart_x() {
        return start_x;
    }

    public int getStart_y() {
        return start_y;
    }

    public int getEnd_x() {
        return end_x;
    }

    public int getEnd_y() {
        return end_y;
    }

    public void setStart_x(int start_x) {
        this.start_x = start_x;
    }

    public void setStart_y(int start_y) {
        this.start_y = start_y;
    }

    public void setEnd_x(int end_x) {
        this.end_x = end_x;
    }

    public void setEnd_y(int end_y) {
        this.end_y = end_y;
    }

    @Override
    public void doSomething() {
        System.out.println("ShiftRobot is doing something");
    }

    @Override
    public void shiftForward() {
        switch (course) {
            case 0:
                y += step_shift;
                break;
            case 90:
                x += step_shift;
                break;
            case 180:
                y -= step_shift;
                break;
            case 270:
                x -= step_shift;
                break;
            default:
                System.out.println("Invalid course value!");
                break;
        }
    }

    @Override
    public void shiftBackward() {
        switch (course) {
            case 0:
                y += step_shift;
                break;
            case 90:
                x += step_shift;
                break;
            case 180:
                y -= step_shift;
                break;
            case 270:
                x -= step_shift;
                break;
            default:
                System.out.println("Invalid course value!");
                break;
        }
    }

    @Override
    public void move() {
        System.out.println("Moving from start to end");

        while (x != end_x) {
            if (x < end_x) {
                if (course != 90) {
                    course = 90;
                    System.out.println("Course set to EAST (90°)");
                }
                shiftForward();
            } else {
                if (course != 270) {
                    course = 270;
                    System.out.println("Course set to WEST (270°)");
                }
                shiftForward();
            }

            doSomething();
            getPosition();
        }

        while (y != end_y) {
            if (y < end_y) {
                if (course != 0) {
                    course = 0;
                    System.out.println("Course set to NORTH (0°)");
                }
                shiftForward();
            } else {
                if (course != 180) {
                    course = 180;
                    System.out.println("Course set to SOUTH (180°)");
                }
                shiftForward();
            }

            doSomething();
            getPosition();
        }

        System.out.println("Reached end point: (" + end_x + ", " + end_y + ")");

        System.out.println("Moving from end to start");

        while (x != start_x) {
            if (x > start_x) {
                if (course != 270) {
                    course = 270;
                    System.out.println("Course set to WEST (270°)");
                }
                shiftBackward();
            } else {
                if (course != 90) {
                    course = 90;
                    System.out.println("Course set to EAST (90°)");
                }
                shiftBackward();
            }
            doSomething();
            getPosition();
        }

        while (y != start_y) {
            if (y > start_y) {
                if (course != 180) {
                    course = 180;
                    System.out.println("Course set to SOUTH (180°)");
                }
                shiftBackward();
            } else {
                if (course != 0) {
                    course = 0;
                    System.out.println("Course set to NORTH (0°)");
                }
                shiftBackward();
            }
            doSomething();
            getPosition();
        }

        System.out.println("Reached start point: (" + start_x + ", " + start_y + ")");
    }
}