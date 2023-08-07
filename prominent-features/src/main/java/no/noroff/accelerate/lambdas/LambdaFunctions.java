package no.noroff.accelerate.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Lambda functions can make your code more concise,
 * improve readability, and enable functional programming paradigms. 
 */

public class LambdaFunctions {

    public static void main(String[] args) {
        iterateListLambda();
        sortListLambda();
        customLambda();
        filterListLambda();
    }

    public static void iterateListLambda() {
        List<String> names = Arrays.asList("Bob", "Alice", "Charlie");
        names.forEach(name -> System.out.println(name));

        List<String> greetings = Arrays.asList("Hello", "Hi", "Hey");
        greetings.forEach(s -> System.out.println(s + "!"));

    }

    public static void sortListLambda() {
        List<String> names = Arrays.asList("Bob", "Alice", "Charlie");
        names.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println(names);

        List<String> cars = Arrays.asList("BMW", "Toyota", "Audi");
        Comparator<String> descendingOrder = (s1, s2) -> s2.compareTo(s1);
        cars.sort(descendingOrder);
        System.out.println(cars);
    }

    public static void customLambda() {
        CalculatorOperation add = (a, b) -> (Integer) a + (Integer) b;
        CalculatorOperation sub = (a, b) -> (Integer) a - (Integer) b;

        // Prints out ref to our lambda function
        System.out.println(add);

        // Using the lambda functions
        System.out.println(add.perform(2, 4));
        System.out.println(sub.perform(2, 4));
    }

    public static void filterListLambda() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);
    }

}