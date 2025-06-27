package S1;

import java.util.Scanner;

public class In {
    public static void main(String[] args) {
        System.out.print("Input value of a: ");
        var a = new Scanner(System.in).nextInt();
        System.out.println(a);

        System.out.print("Input value of d: ");
        var d = new Scanner(System.in).nextDouble();
        System.out.println(d);

        System.out.print("Input value of b: ");
        var b = new Scanner(System.in).nextBoolean();
        System.out.println(b);

        System.out.print("Input value of ch: ");
        var ch = new Scanner(System.in).nextLine().charAt(0);
        System.out.println(ch);

        System.out.print("Input value of s: ");
        var s = new Scanner(System.in).nextLine();
        System.out.println(s);
    }
}
