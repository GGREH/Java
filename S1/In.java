package S1;

import java.util.Scanner;

public class In {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input value of a: ");
        var a = scanner.nextInt();
        System.out.println(a);

        System.out.print("Input value of d: ");
        var d = scanner.nextDouble();
        System.out.println(d);

        System.out.print("Input value of b: ");
        var b = scanner.nextBoolean();
        System.out.println(b);

        System.out.print("Input value of ch: ");
        var ch = scanner.nextLine().charAt(0);
        System.out.println(ch);

        System.out.print("Input value of s: ");
        var s = scanner.nextLine();
        System.out.println(s);

        scanner.close();
    }
}
