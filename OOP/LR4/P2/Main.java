package P2;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import P2.Action.ActionType;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Robot(1); RotRobot(2); ShiftRobot(3); WalkRobot(4)");
        System.out.print("Select robot for testing: ");

        if (!scan.hasNextInt()) {
            System.out.println("Input error. Program termination.");
            scan.close();
            return;
        }
        int task_num = scan.nextInt();

        scan.nextLine();

        System.out.println("-----------------------------------------");

        switch (task_num) {
            case 1:
                System.out.println("--- Testing basic functionality (Robot) ---");
                Robot baseRobot = new Robot(10, 20, 45) {
                    @Override
                    public void doSomething() {
                        System.out.println("Robot is doing anonymous action");
                    }
                };
                System.out.println("Start: " + baseRobot.getPosition());
                baseRobot.doSomething();
                break;

            case 2:
                System.out.println("--- Testing RotRobot (Single Full Oscillation Cycle) ---");

                System.out.print("Enter START angle (e.g., 0): ");
                int startAngle = scan.nextInt();

                System.out.print("Enter END angle (e.g., 180): ");
                int endAngle = scan.nextInt();

                scan.nextLine();

                RotRobot anonymousRotRobot = new RotRobot(startAngle, endAngle) {
                    @Override
                    public void move() {
                        super.move();
                        System.out.println("RotRobot is doing anonymous rotation");
                    }
                };

                System.out.println("Start: " + anonymousRotRobot.getPosition());

                int rotSteps = 0;
                while (!anonymousRotRobot.getIsDone()) {
                    anonymousRotRobot.move();
                    rotSteps++;
                    if (rotSteps > 20) {
                        System.out.println("Safety stop: Max steps reached.");
                        break;
                    }
                }

                System.out.println("End: " + anonymousRotRobot.getPosition());
                break;

            case 3:
                System.out.println("--- Testing ShiftRobot (Moving to Endpoint) ---");

                System.out.print("Enter END X coordinate (e.g., 5): ");
                int endX = scan.nextInt();

                System.out.print("Enter END Y coordinate (e.g., 5): ");
                int endY = scan.nextInt();

                scan.nextLine();

                final int START_X = 0;
                final int START_Y = 0;
                final int START_COURSE = 90;

                ShiftRobot anonymousShiftRobot = new ShiftRobot(START_X, START_Y, endX, endY, START_COURSE) {
                    @Override
                    public void move() {
                        System.out.println("ShiftRobot is moving in anonymous way");
                        super.move();
                    }
                };

                System.out.println("Start: " + anonymousShiftRobot.getPosition());

                System.out.println("\nMoving to End Position (" + endX + ", " + endY + "):");
                int steps = 0;
                while (anonymousShiftRobot.getX() != endX || anonymousShiftRobot.getY() != endY) {
                    anonymousShiftRobot.move();
                    steps++;
                    if (steps > 100) {
                        System.out.println("Safety stop: Max steps reached.");
                        break;
                    }
                }

                System.out.println("\nShiftRobot finished movement to target.");
                System.out.println("Final: " + anonymousShiftRobot.getPosition());
                break;

            case 4:
                System.out.println("--- Testing WalkRobot (Programmed Sequence) ---");
                WalkRobot walkRobot = new WalkRobot(0, 0, 0);
                System.out.println("Start: " + walkRobot.getPosition());

                List<Action> actions = Arrays.asList(
                        new Action(ActionType.ShiftF, 3),
                        new Action(ActionType.RotF, 1),
                        new Action(ActionType.ShiftF, 2),
                        new Action(ActionType.DoSomething, 1));

                walkRobot.setActionList(actions);

                walkRobot.getActionList();

                System.out.println("\nStarting execution until all actions completed:");

                int safetyStepCount = 0;
                while (!walkRobot.isFinished()) {
                    walkRobot.move();

                    safetyStepCount++;
                    if (safetyStepCount > 100) {
                        System.out.println("Safety break: Max steps reached.");
                        break;
                    }
                }

                System.out.println("Final: " + walkRobot.getPosition());
                break;

            default:
                System.out.println("Unknown command. Robot with number " + task_num + " not found.");
        }
        scan.close();
    }
}