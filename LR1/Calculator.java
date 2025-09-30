package LR1;

public class Calculator {
    private BigInt n1;
    private BigInt n2;

    public Calculator(BigInt num1, BigInt num2) {
        this.n1 = num1;
        this.n2 = num2;
    }

    public String toString() {
        return "n1: " + n1 + ", n2: " + n2;
    }

    public BigInt get_n1() {
        return n1;
    }

    public BigInt get_n2() {
        return n2;
    }

    public void set_n1(BigInt num) {
        this.n1 = num;
    }

    public void set_n2(BigInt num) {
        this.n2 = num;
    }

    public BigInt add() {
        return n1.add(n2);
    }

    public BigInt minus() {
        return n1.minus(n2);
    }

    public BigInt multiply() {
        return n1.multiply(n2);
    }

    public BigInt divide() {
        return n1.divide(n2);
    }

    public boolean isEqual() {
        return n1.compare(n2) == 0;
    }

    public boolean isGreater() {
        return n1.compare(n2) > 0;
    }

    public boolean isLess() {
        return n1.compare(n2) < 0;
    }

    public void assign() {
        BigInt temp = n1;
        n1 = n2;
        n2 = temp;
    }
}
