package no.noroff.accelerate;

public class Calculator {

    // Method overloading

    public static int sum(int a, int b) {
        if (a == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Tallet er for stort!!");
        }
        return a + b;
    }

    public static float sum(float a, float b) {
        return a + b;
    }

}
