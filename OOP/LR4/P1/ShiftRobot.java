package P1;

public class ShiftRobot extends Robot implements Shiftable {
    protected int start_shift;
    protected int end_shift;

    ShiftRobot() {
        start_shift = 0;
        end_shift = 0;
    }

    ShiftRobot(int ssi, int esi) {
        start_shift = ssi;
        end_shift = esi;
    }

    @Override
    public void doSomething() {
        System.out.println("ShiftRobot does something");
    }

    public void move() {
        System.out.println("ShiftRobot moves");
    }

    public void shiftForward() {
        System.out.println("ShiftRobot shifts forward");
    }

    public void shiftBackward() {
        System.out.println("ShiftRobot shifts backward");
    }
}
