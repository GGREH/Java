package LR1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть значення num1: ");
        String inum1 = scanner.nextLine();
        BigInt num1 = new BigInt(inum1);

        System.out.print("Введіть значення num2: ");
        int inum2 = scanner.nextInt();
        BigInt num2 = new BigInt(inum2);

        Calculator calculator = new Calculator(num1, num2);

        System.out.println("num1 + num2 = " + calculator.add());
        System.out.println("num1 - num2 = " + calculator.minus());
        System.out.println("num1 * num2 = " + calculator.multiply());
        System.out.println("num1 / num2 = " + calculator.divide());

        System.out.println("num1 = num2 ?: " + calculator.isEqual());
        System.out.println("num1 > num2 ?: " + calculator.isGreater());
        System.out.println("num1 < num2 ?: " + calculator.isLess());

        System.out.println("num1 before assign: " + calculator.get_n1());
        System.out.println("num2 before assign: " + calculator.get_n2());

        calculator.assign();

        System.out.println("num1 after assign: " + calculator.get_n1());
        System.out.println("num2 after assign: " + calculator.get_n2());

        scanner.close();
    }
}