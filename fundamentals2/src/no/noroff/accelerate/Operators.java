package no.noroff.accelerate;

public class Operators {

     public void basicOperators() {
        int myInt = 5;
        myInt = myInt + 3;
        System.out.println(myInt);
    }

    public void incremetOperators() {
        int myInt = 5;
        myInt++;
        System.out.println(myInt);
    }

    // Compound operators
    public void shortcutOperators() {
        int myInt = 5;
        System.out.println(myInt);
        myInt += 3; // myInt = myInt + 3;
        System.out.println(myInt);
    }

    public int pemdasExample() {
        // PEMDAS:
        // Paranthesis
        // Exponents
        // Mulitplication
        // Division
        // Addition
        // Subtraction
        return 5 * (2 + 1);
    }

    public void modulus() {
        int x = 7;
        int y = 15;

        System.out.println(x % 3);
        System.out.println(y % 3);
    }

}
