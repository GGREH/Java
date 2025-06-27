package S1;

public class DataTypes {
    public static void main(String[] args) {
        int i = 0;
        System.out.println(Integer.MIN_VALUE + " < " + i + " < " + Integer.MAX_VALUE);

        double d = 0.1;
        System.out.println(Double.MIN_VALUE + " < " + d + " < " + Double.MAX_VALUE);

        boolean b1 = true;
        boolean b2 = false;

        System.out.println(b1 + " or " + b2);

        char ch = 'a';
        System.out.println(ch + " (" + (int) ch + ") ");

        String s = "Hello world";
        System.out.println(s);
    }
}
