package no.noroff.accelerate.vehicles;

// Car inherits all traits from superclass (parent) Vehicle
public class Car extends Vehicle {

    // Constructor for Car class, calling the constructor of the parent class using the "super" keyword
    public Car(String make, String model, PropulsionSystem propulsionSystem) {
        super(make, model, propulsionSystem);
    }

    // Polymorphism: overriding parent class's "start()"
    @Override
    public void start() {
        System.out.println("Car is starting.");
        ignitePropulsionSystem();
    }

    @Override
    public void accelerate() {
        // Could e.g. use effect from propulsion;
        // multiplied by some internal factor like weight, traction;
        // to determine how to accelerate
        if (isPropulsionSystemRunning()) {
            System.out.println("Car is accelerating.");
        } else {
            System.out.println("Car cannot accelerate. Propulsion system is not running.");
        }
    }
}
