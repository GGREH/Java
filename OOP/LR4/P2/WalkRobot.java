package P2;

public class WalkRobot extends Robot implements Rotetable, Shiftable {
    private Action[] actionList;

    public static class MissionPlanner {
        public static Action[] createDefaultMission() {
            System.out.println("MissionPlanner: Creating default mission plan.");
            Action[] actions = {
                    new Action(ActionType.RotF, 1),
                    new Action(ActionType.ShiftF, 3),
                    new Action(ActionType.DoSomth, 1),
                    new Action(ActionType.RotB, 1),
                    new Action(ActionType.ShiftB, 2)
            };
            return actions;
        }

        public static Action[] createSquareMission() {
            System.out.println("MissionPlanner: Creating square mission plan.");
            Action[] actions = {
                    new Action(ActionType.ShiftF, 4),
                    new Action(ActionType.RotF, 1),
                    new Action(ActionType.ShiftF, 4),
                    new Action(ActionType.RotF, 1),
                    new Action(ActionType.ShiftF, 4),
                    new Action(ActionType.RotF, 1),
                    new Action(ActionType.ShiftF, 4),
                    new Action(ActionType.RotF, 1),
            };
            return actions;
        }
    }

    public WalkRobot() {
        super();
        this.actionList = new Action[0];
    }

    public WalkRobot(int x, int y, int course) {
        super(x, y, course);
        this.actionList = new Action[0];
    }

    public WalkRobot(int x, int y, int course, Action[] actionList) {
        super(x, y, course);
        this.actionList = actionList != null ? actionList : new Action[0];
    }

    public void set_actionList(Action[] actionList) {
        this.actionList = actionList != null ? actionList : new Action[0];
    }

    public void view_actionList() {
        System.out.println("Action List for WalkRobot:");
        if (actionList.length == 0) {
            System.out.println("  No actions defined");
            return;
        }

        for (int i = 0; i < actionList.length; i++) {
            System.out.println("  " + (i + 1) + ". " + actionList[i]);
        }
    }

    @Override
    public void doSomething() {
        System.out.println("WalkRobot is doing its mission");
    }

    @Override
    public void rotateForward() {
        if (course + step_angle >= 360) {
            course = course + step_angle - 360;
        } else {
            course = course + step_angle;
        }
        System.out.println("Rotated forward to course: " + course + "°");
    }

    @Override
    public void rotateBackward() {
        if (course - step_angle < 0) {
            course = course - step_angle + 360;
        } else {
            course = course - step_angle;
        }
        System.out.println("Rotated backward to course: " + course + "°");
    }

    @Override
    public void shiftForward() {
        switch (course) {
            case 0:
                y += step_shift;
                break;
            case 90:
                x += step_shift;
                break;
            case 180:
                y -= step_shift;
                break;
            case 270:
                x -= step_shift;
                break;
        }
        System.out.println("Shifted forward to (" + x + ", " + y + ")");
    }

    @Override
    public void shiftBackward() {
        switch (course) {
            case 0:
                y += step_shift;
                break;
            case 90:
                x += step_shift;
                break;
            case 180:
                y -= step_shift;
                break;
            case 270:
                x -= step_shift;
                break;
        }
        System.out.println("Shifted backward to (" + x + ", " + y + ")");
    }

    @Override
    public void move() {
        System.out.println("WalkRobot starting movement sequence...");

        if (actionList.length == 0) {
            System.out.println("No actions to perform");
            return;
        }

        for (int i = 0; i < actionList.length; i++) {
            Action action = actionList[i];
            System.out.println("Executing action " + (i + 1) + ": " + action);

            for (int step = 0; step < action.getStepsCount(); step++) {
                switch (action.getType()) {
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
                    case DoSomth:
                        doSomething();
                        break;
                }
            }
        }

        System.out.println("WalkRobot finished movement sequence");
        getPosition();
    }
}