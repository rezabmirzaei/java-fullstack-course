package no.noroff.accelerate.recursion;

public class RecursiveCountdown {

    public static void countDownFrom(int start) {
        if (start >= 0) {
            System.out.println(start);
            countDownFrom(start - 1);
        }
    }

}
