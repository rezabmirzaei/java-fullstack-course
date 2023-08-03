package no.noroff.accelerate;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
    }

    public String convertToUppercase(String strToConvert) {
        return strToConvert.toUpperCase();
    }

    public void someMethod(String s) {
        try {
            s = s.toUpperCase();
        } catch (NullPointerException npe) {
            System.err.println(npe.getLocalizedMessage());
        }
    }

}
