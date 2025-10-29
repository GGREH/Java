package P1;

public class RotRobot extends Robot implements Rotatable {
    protected int start_angle;
    protected int end_angle;

    RotRobot() {
        start_angle = 0;
        end_angle = 0;
    }

    RotRobot(int sai, int eai) {
        start_angle = sai;
        end_angle = eai;
    }

    @Override
    public void doSomething() {
        System.out.println("RotRobot does something");
    }

    public void move() {
        System.out.println("RotRobot moves");
    }

    public void rotateForward() {
        System.out.println("RotRobot rotate forward");
    }

    public void rotateBackward() {
        System.out.println("RotRobot rotate backward");
    }
}
