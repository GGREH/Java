package OOP.LR2;

public class BigInt {
    private String v;

    public BigInt() {
        this.v = "0";
    }

    public BigInt(String v) {
        if (!v.matches("-?\\d+")) {
            throw new IllegalArgumentException("Incorrect input format!");
        }
        this.v = v;
    }

    public BigInt(BigInt other) {
        this.v = other.v;
    }

    public BigInt(int d) {
        String sd = String.valueOf(d);
        this.v = sd;
    }

    public String toString() {
        return v;
    }

    public void set_value(String v) {
        if (!v.matches("\\d+")) {
            throw new IllegalArgumentException("Incorrect input format!");
        }
        this.v = v;
    }

    public String get_value() {
        return v;
    }

    public BigInt add(BigInt other) {
        String num1 = this.v;
        String num2 = other.v;

        while (num1.length() < num2.length())
            num1 = "0" + num1;
        while (num2.length() < num1.length())
            num2 = "0" + num2;

        int len = num1.length();
        StringBuilder res = new StringBuilder();
        int charge = 0;

        for (int i = len - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            int d2 = num2.charAt(i) - '0';
            int sum = d1 + d2 + charge;
            charge = sum / 10;
            res.append(sum % 10);
        }

        if (charge != 0) {
            res.append(charge);
        }

        return new BigInt(res.reverse().toString());
    }

    public BigInt minus(BigInt other) {
        String num1 = this.v;
        String num2 = other.v;

        boolean negative = false;
        if (this.compare(other) < 0) {
            negative = true;
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        while (num1.length() < num2.length())
            num1 = "0" + num1;
        while (num2.length() < num1.length())
            num2 = "0" + num2;

        StringBuilder res = new StringBuilder();
        int borrow = 0;

        for (int i = num1.length() - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0' - borrow;
            int d2 = num2.charAt(i) - '0';
            if (d1 < d2) {
                d1 += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            res.append(d1 - d2);
        }

        while (res.length() > 1 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }

        String result = res.reverse().toString();
        if (negative)
            result = "-" + result;

        return new BigInt(result);
    }

    public BigInt multiply(BigInt other) {
        BigInt result = new BigInt("0");
        BigInt o = new BigInt("1");

        BigInt mult = new BigInt(other);
        while (mult.compare(new BigInt("0")) > 0) {
            result = result.add(this);
            mult = mult.minus(o);
        }

        return result;
    }

    public BigInt divide(BigInt other) {
        if (other.v.equals("0")) {
            throw new ArithmeticException("Divide by zero!");
        }

        BigInt dividend = new BigInt(this.v);
        BigInt divisor = new BigInt(other.v);
        BigInt result = new BigInt("0");
        BigInt one = new BigInt("1");

        while (dividend.compare(divisor) >= 0) {
            dividend = dividend.minus(divisor);
            result = result.add(one);
        }

        return result;
    }

    public int compare(BigInt other) {
        if (this.v.length() > other.v.length())
            return 1;
        if (this.v.length() < other.v.length())
            return -1;
        return this.v.compareTo(other.v);
    }
}
