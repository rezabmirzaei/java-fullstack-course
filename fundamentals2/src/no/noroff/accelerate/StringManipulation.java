package no.noroff.accelerate;

public class StringManipulation {

    public void testConcatination() {
        String myStr1 = "Hello";
        String myStr2 = "World";
        String helloWorld = myStr1.concat(myStr2);
        System.out.println(helloWorld);
    }

    public void testInfoExtraction() {
        String str = "Hello World!";

        // Get single chars by index
        char firstChar = str.charAt(0);
        System.out.println(firstChar); // H
        System.out.println(str.charAt(str.length() - 1));

        // Find position (index)
        System.out.println(str.indexOf("o")); // 4
        System.out.println(str.indexOf("o", 7)); // 7
        System.out.println(str.lastIndexOf("o", 7)); // 7

        // Contains (true/false)
        System.out.println(str.contains("apple"));
        System.out.println(str.contains("Hello"));
        System.out.println(str.toLowerCase().contains("hello"));

    }

    public void stringAlteration() {
        String str = "A string to work with";

        // Substring
        System.out.println(str.substring(2, 8));

        // Repalcement
        System.out.println(str.replace("o", "M"));

        // Case
        System.out.println("hello".toUpperCase());

        // Heads up! Immutable!
        System.out.println(str);

    }

    public void stringEquality() {
        String foo = "Hello";
        String bar = "Hello";
        String baz = new String("Hello");

        // Refernce equality
        System.out.println(foo == bar);
        System.out.println(foo == baz);

        // Value equality
        System.out.println(foo.equals(bar));
        System.out.println(foo.equals(baz));

    }
}
