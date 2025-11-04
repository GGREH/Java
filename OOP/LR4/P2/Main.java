package P2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int Option;

        System.out.println(
                "Input test option 1 - Robot; 2 - RotRobot; 3 - ShiftRobot; 4 - WalkRobot; 5 - Anonymous Classes: ");
        Option = scanner.nextInt();

        switch (Option) {
            case 1:
                Robot R = new Robot(0, 0, 90);

                System.out.println("\n=== Starting Movement ===");
                R.doSomething();
                R.getLogger().printLog();
                break;
            case 2:
                RotRobot RR = new RotRobot(0, 0, 0, 270);

                System.out.println("\n=== Starting Movement ===");
                RR.move();
                RR.getLogger().printLog();
                break;
            case 3:
                ShiftRobot SR = new ShiftRobot(1, 1, 5, 3, 0);

                System.out.println("\n=== Starting Movement ===");
                SR.move();
                SR.getLogger().printLog();
                break;
            case 4:
                Action[] actions = WalkRobot.MissionPlanner.createDefaultMission();

                WalkRobot RW = new WalkRobot(0, 0, 0, actions);

                RW.view_actionList();

                System.out.println("\n=== Starting Movement ===");
                RW.move();
                RW.getLogger().printLog();
                break;

            case 5:
                System.out.println("\n--- Anonymous Classes Test ---");

                Robot extendingRobot = new Robot(10, 10, 0) {
                    @Override
                    public void doSomething() {
                        System.out.println("AnonymousExtendingRobot: Preparing to do something...");
                        super.doSomething();
                        System.out.println("AnonymousExtendingRobot: Finished doing something!");
                        getLogger().logState("Anonymous Extended Action");
                    }
                };

                System.out.println("\nTesting extending anonymous class:");
                extendingRobot.doSomething();
                extendingRobot.getPosition();
                extendingRobot.getLogger().printLog();

                Robot modifyingRobot = new Robot(20, 20, 90) {
                    @Override
                    public void doSomething() {
                        System.out.println(
                                "AnonymousModifyingRobot: Doing something completely different! (e.g., charging batteries)");
                        getLogger().logState("Anonymous Modified Action");
                    }
                };

                System.out.println("\nTesting modifying anonymous class:");
                modifyingRobot.doSomething();
                modifyingRobot.getPosition();
                modifyingRobot.getLogger().printLog();
                break;

            default:
                System.out.println("Invalid test option!");
                break;
        }
        scanner.close();
    }
}