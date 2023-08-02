import no.noroff.accelerate.StringManipulation;

public class App {

    public static void main(String[] args) throws Exception {

        StringManipulation strMan = new StringManipulation();
        strMan.stringEquality();

        // RecursiveCountdown.countDownFrom(10);

        // Operators operators = new Operators();
        // // operators.basicOperators();
        // // operators.incremetOperators();
        // operators.shortcutOperators();
        // System.out.println(operators.pemdasExample());

        // logicalOperators();

        // System.out.println(Calculator.sum(1, 2f));
        // // System.out.println("\n" + Integer.MAX_VALUE);

        // // Exception handling
        // try {
        //     System.out.println(Calculator.sum(Integer.MAX_VALUE, Integer.MAX_VALUE));
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }

        // // Scope example
        // // int a = x;
    }

    public static void locallyScopedVarExample() {
        final int x = 5;
        System.out.println(x);
    }

    public static void logicalOperators() {
        int a = 4;
        String b = "b";

        if (!(a < 5) && b.equals("b")) {
            System.out.println("True!!!");
        } else {
            System.out.println("False!!!");
        }
    }

}
