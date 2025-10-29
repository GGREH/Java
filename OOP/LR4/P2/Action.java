package P2;

public class Action {
    private ActionType type;
    private int steps_count;

    public Action(ActionType type, int steps_count) {
        this.type = type;
        this.steps_count = steps_count;
    }

    public ActionType getType() {
        return type;
    }

    public int getStepsCount() {
        return steps_count;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public void setStepsCount(int steps_count) {
        this.steps_count = steps_count;
    }

    @Override
    public String toString() {
        return type + "(" + steps_count + ")";
    }
}