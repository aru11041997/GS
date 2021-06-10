package org.example.fraction;

public class Main {
    public static void main(String[] args) {
        Fraction fraction = new Fraction();
        int[] res = fraction.addFraction(new int[]{2, 3}, new int[]{1, 2});
        System.out.println(res[0] + " " + res[1]);
    }
}
