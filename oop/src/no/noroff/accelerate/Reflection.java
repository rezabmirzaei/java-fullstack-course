package no.noroff.accelerate;

import java.lang.reflect.Modifier;

import no.noroff.accelerate.vehicles.Car;

public class Reflection {

    @SuppressWarnings("all")
    public static void example() {
        Class obj = Car.class;

        // Get name of the class
        String name = obj.getName();
        System.out.println("Name: " + name);

        // Get the access modifier of the class
        int modifier = obj.getModifiers();

        // Convert the access modifier to string
        String mod = Modifier.toString(modifier);
        System.out.println("Modifier: " + mod);

        // Get the superclass of BMX (obj)
        Class superClass = obj.getSuperclass();
        System.out.println("Superclass: " + superClass.getName());
    }

}
