package no.noroff.accelerate.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * I/O streams are for reading/writing bytes for Input/Output, mostly files and network sockets.
 * The new Streams are for functional programming, mostly for processing Collections. 
 */
public class StreamAPIDemo {

    public static void main(String[] args) {
        comparision();
        streamFilter();
        streamMap();
        streamSort();
        streamReduce();
        streamGroup();
    }

    public static void comparision() {
        List<String> weekdays = List.of(
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

        for (int i = 0; i < weekdays.size(); i++) {
            System.out.print(weekdays.get(i).concat(" "));
        }
        System.out.println();

        for (String name : weekdays) {
            System.out.print(name.concat(" "));
        }
        System.out.println();

        weekdays.stream().forEach(name -> System.out.print(name.concat(" ")));
        System.out.println();

        weekdays.stream().forEach(name -> {
            // Use ternary expression instead of if/else below
            name = name.startsWith("T") ? name.toUpperCase() : (name.startsWith("S") ? name.toLowerCase() : name);
            // if (name.startsWith("T")) {
            // name = name.toUpperCase();
            // } else if (name.startsWith("S")) {
            // name = name.toLowerCase();
            // }
            System.out.print(name);
            System.out.print(" ");
        });
        System.out.println();

        // weekdays.stream().forEach(System.out::print);
    }

    public static void streamFilter() {
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
        List<String> filteredFruits = fruits.stream()
                .filter(fruit -> fruit.length() > 5)
                .collect(Collectors.toList());
        System.out.println(filteredFruits); // Output: [banana, orange]
    }

    public static void streamMap() {
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
        List<Integer> fruitLengths = fruits.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(fruitLengths); // Output: [5, 6, 6, 5, 4]
    }

    public static void streamSort() {
        List<Integer> numbers = Arrays.asList(10, 5, 8, 3, 7);
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNumbers); // Output: [3, 5, 7, 8, 10]
    }

    /*
     * Reducing is the process of combining elements of a stream into a single
     * value.
     */
    public static void streamReduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum); // Output: 15 (sum of all elements)
    }

    public static void streamGroup() {
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape", "kiwi", "avacado");
        Map<Character, List<String>> groupedFruits = fruits.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println(groupedFruits);
        // Output: {a=[apple, avacado], b=[banana], g=[grape], k=[kiwi], o=[orange]}
    }

}