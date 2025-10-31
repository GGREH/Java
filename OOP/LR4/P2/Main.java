package P2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int Option;

        System.out.println("Input test option 1 - Robot; 2 - RotRobot; 3 - ShiftRobot; 4 - WalkRobot: ");
        Option = scanner.nextInt();

        switch (Option) {
            case 1:
                Robot R = new Robot(0, 0, 90);

                System.out.println("\n=== Starting Movement ===");
                R.doSomething();
                break;
            case 2:
                RotRobot RR = new RotRobot(0, 0, 0, 270);

                System.out.println("\n=== Starting Movement ===");
                RR.move();
                break;
            case 3:
                ShiftRobot SR = new ShiftRobot(1, 1, 5, 3, 0);

                System.out.println("\n=== Starting Movement ===");
                SR.move();
                break;
            case 4:
                Action[] actions = {
                        new Action(ActionType.RotF, 1),
                        new Action(ActionType.ShiftF, 3),
                        new Action(ActionType.DoSomth, 1),
                        new Action(ActionType.RotB, 1),
                        new Action(ActionType.ShiftB, 2)
                };

                WalkRobot RW = new WalkRobot(0, 0, 0, actions);

                RW.view_actionList();

                System.out.println("\n=== Starting Movement ===");
                RW.move();
                break;
            default:
                System.out.println("Invalid test option!");
                break;
        }
    }
}
