package P1;

public class Action {
    private ActionType action;
    private int step_count = 0;

    public Action(ActionType ai, int sci) {
        action = ai;
        step_count = sci;
    }

    public enum ActionType {
        RotF, RotB, ShiftF, ShiftB, DoSmth
    };
}
