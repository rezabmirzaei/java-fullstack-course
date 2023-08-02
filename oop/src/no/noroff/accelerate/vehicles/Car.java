package no.noroff.accelerate.vehicles;

public class Car extends Vehicle {
    
    public Car(String make, String model, PropulsionSystem propulsionSystem) {
        super(make, model, propulsionSystem);
    }

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
