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

class SecondClass {
    private int f;
    private int s;

    SecondClass() {
        f = 0;
        s = 0;
    }

    public void setF(int sf) {
        this.f = sf;
    }

    public void setS(int ss) {
        this.s = ss;
    }

    public int sum() {
        return f + s;
    }
}