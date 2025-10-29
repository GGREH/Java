package P1;

public class WalkRobot extends Robot implements Rotatable, Shiftable {
    @Override
    public void doSomething() {
        System.out.println("WalkRobot does something");
    }

    public void move() {
        System.out.println("WalkRobot moves");
    }

    public void rotateForward() {
        System.out.println("WalkRobot rotates forward");
    }

    public void rotateBackward() {
        System.out.println("WalkRobot rotates backward");
    }

    public void shiftForward() {
        System.out.println("WalkRobot shifts forward");
    }

    public void shiftBackward() {
        System.out.println("WalkRobot shifts backward");
    }

    public void setActionList() {
        System.out.println("WalkRobot sets action list");
    }

    public void getActionList() {
        System.out.println("WalkRobot gets action list");
    }
}