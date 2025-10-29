package P2;

public class Main {
    public static void main(String[] args) {
        Action[] actions = {
                new Action(ActionType.RotF, 1),
                new Action(ActionType.ShiftF, 3),
                new Action(ActionType.DoSomth, 1),
                new Action(ActionType.RotB, 1),
                new Action(ActionType.ShiftB, 2)
        };

        WalkRobot walker = new WalkRobot(0, 0, 0, actions);

        walker.view_actionList();

        System.out.println("\n=== Starting Movement ===");
        walker.move();
    }
}