package second;

public class SecondClass {
    private int f;
    private int s;

    public SecondClass() {
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