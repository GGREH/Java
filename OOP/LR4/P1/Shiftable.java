package P1;

public interface Shiftable extends Movable {
    public final int step_shift = 1;

    public void shiftForward();

    public void shiftBackward();
}
