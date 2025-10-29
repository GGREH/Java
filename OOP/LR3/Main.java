package LR3;

import LR3.Triangle;
import LR3.Triangle60;
import LR3.Triangle90;

public class Main {
    public void foo(Triangle Obj) {
        Obj.getInfo();
    }

    public static void main(String[] args) {
        Main mainApp = new Main();

        System.out.println("\n--- Task 1: Direct Creation and Invocation ---");

        Triangle90 tr90 = new Triangle90();
        Triangle60 tr60 = new Triangle60();

        System.out.println("Triangle90 (tr90):");
        tr90.getInfo();

        System.out.println("Triangle60 (tr60):");
        tr60.getInfo();

        System.out.println("\n--- Task 2: Base Class Reference (Upcasting) ---");

        Triangle l = tr90;
        Triangle m = tr60;

        System.out.println("Triangle90 (l - base class reference):");
        l.getInfo();

        System.out.println("Triangle60 (m - base class reference):");
        m.getInfo();

        System.out.println("\n--- Task 3: Method Invocation via foo() ---");

        System.out.println("Triangle90 via foo:");
        mainApp.foo(l);

        System.out.println("Triangle60 via foo:");
        mainApp.foo(m);

        System.out.println("\n--- Task 4: Array of Base Class References ---");

        Triangle[] mas = new Triangle[5];
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                mas[i] = new Triangle90();
                System.out.println("mas[" + i + "] - Triangle90");
            } else {
                mas[i] = new Triangle60();
                System.out.println("mas[" + i + "] - Triangle60");
            }
            mas[i].getInfo();
            System.out.println();
        }
    }
}