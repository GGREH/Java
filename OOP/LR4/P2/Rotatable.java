package P2;

public interface Rotatable extends Movable {
    public final int step_angle = 90;

    public void rotateForward();

    public void rotateBackward();
}