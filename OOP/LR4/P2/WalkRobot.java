package P2;

import java.util.List;
import java.util.ArrayList;

public class WalkRobot extends Robot implements Rotatable, Shiftable {
    public WalkRobot() {
        super();
    }

    public WalkRobot(int xi, int yi, int ci) {
        super(xi, yi, ci);
    }

    private List<Action> actionList = new ArrayList<>();
    private int currentActionIndex = 0;
    private int currentStepCount = 0;

    @Override
    public void doSomething() {
        System.out.println("WalkRobot: Performing action from list.");
    }

    @Override
    public void rotateForward() {
        course = (course + Rotatable.step_angle) % 360;
        System.out.println("RotF (course: " + course + "°)");
    }

    @Override
    public void rotateBackward() {
        course = (course - Rotatable.step_angle + 360) % 360;
        System.out.println("RotB (course: " + course + "°)");
    }

    @Override
    public void shiftForward() {
        if (course == 0)
            x += Shiftable.step_shift;
        else if (course == 90)
            y += Shiftable.step_shift;
        else if (course == 180)
            x -= Shiftable.step_shift;
        else if (course == 270)
            y -= Shiftable.step_shift;
        System.out.println("ShiftF " + getPosition());
    }

    @Override
    public void shiftBackward() {
        if (course == 0)
            x -= Shiftable.step_shift;
        else if (course == 90)
            y -= Shiftable.step_shift;
        else if (course == 180)
            x += Shiftable.step_shift;
        else if (course == 270)
            y += Shiftable.step_shift;
        System.out.println("ShiftB " + getPosition());
    }

    @Override
    public void move() {
        if (actionList.isEmpty() || currentActionIndex >= actionList.size()) {
            System.out.println("WalkRobot: All actions completed. Current " + getPosition());
            return;
        }

        Action currentAction = actionList.get(currentActionIndex);

        if (currentStepCount >= currentAction.getStepCount()) {
            currentActionIndex++;
            currentStepCount = 0;
            if (currentActionIndex < actionList.size()) {
                move();
                return;
            } else {
                System.out.println("WalkRobot: All actions completed. Current " + getPosition());
                return;
            }
        }

        System.out.print("Action " + (currentActionIndex + 1) + " of " + actionList.size() + " ("
                + (currentStepCount + 1) + "/" + currentAction.getStepCount() + "): ");

        switch (currentAction.getAction()) {
            case RotF:
                rotateForward();
                break;
            case RotB:
                rotateBackward();
                break;
            case ShiftF:
                shiftForward();
                break;
            case ShiftB:
                shiftBackward();
                break;
            case DoSomething:
                doSomething();
                break;
        }

        currentStepCount++;
    }

    public void setActionList(List<Action> list) {
        this.actionList = list;
        this.currentActionIndex = 0;
        this.currentStepCount = 0;
        System.out.println("WalkRobot: Action list set with " + list.size() + " actions.");
    }

    public List<Action> getActionList() {
        System.out.println("WalkRobot: Viewing action list: " + actionList);
        return actionList;
    }

    public boolean isFinished() {
        return currentActionIndex >= actionList.size();
    }
}