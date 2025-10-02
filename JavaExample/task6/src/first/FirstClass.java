package first;

import second.SecondClass;

public class FirstClass {
    public static void main(String[] s) {
        SecondClass t = new SecondClass();
        int i, j;

        for (i = 1; i <= 3; i++) {
            for (j = 1; j <= 4; j++) {
                t.setF(i);
                t.setS(j);
                System.out.print(t.sum() + " ");
            }
            System.out.println();
        }
    }
}