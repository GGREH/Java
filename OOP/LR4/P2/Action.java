package P2;

public class Action {
    private ActionType action;
    private int step_count = 0;

    public Action(ActionType ai, int sci) {
        action = ai;
        step_count = sci;
    }

    public ActionType getAction() {
        return action;
    }

    public int getStepCount() {
        return step_count;
    }

    public void setStep_count(int step_count) {
        this.step_count = step_count;
    }

    public void setAction(ActionType action) {
        this.action = action;
    }

    public enum ActionType {
        RotF, RotB, ShiftF, ShiftB, DoSomething
    }

    @Override
    public String toString() {
        return "[" + action + " x" + step_count + "]";
    }
}
