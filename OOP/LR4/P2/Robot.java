package P2;

import java.util.ArrayList;

public class Robot {
    protected int x;
    protected int y;
    protected int course;

    public class RobotStateLogger {
        private ArrayList<String> log = new ArrayList<>();

        public void logState(String action) {
            String state = "Action: " + action + ", Position: (" + x + ", " + y + "), Course: " + course;
            log.add(state);
            System.out.println("LOGGED: " + state);
        }

        public void printLog() {
            System.out.println("--- Robot Log (Instance: " + Robot.this.hashCode() + ") ---");
            for (String entry : log) {
                System.out.println(entry);
            }
            System.out.println("-----------------");
        }
    }

    private RobotStateLogger logger = new RobotStateLogger();

    Robot() {
        this.x = 0;
        this.y = 0;
        this.course = 0;
        logger.logState("Created (Default)");
    }

    Robot(int xi, int yi, int ci) {
        this.x = xi;
        this.y = yi;
        this.course = ci;
        logger.logState("Created (Params)");
    }

    public RobotStateLogger getLogger() {
        return logger;
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
        logger.logState("Set Course");
    }

    public void doSomething() {
        System.out.println("Robot is doing something");
        logger.logState("Do Something");
    }

    public void getPosition() {
        System.out.println("Robot is on (" + x + ", " + y + "), course: " + course);
    }
}