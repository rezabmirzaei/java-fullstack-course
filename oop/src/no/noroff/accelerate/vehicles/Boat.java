package no.noroff.accelerate.vehicles;

public class Boat extends Vehicle {
    
    public Boat(String make, String model, PropulsionSystem propulsionSystem) {
        super(make, model, propulsionSystem);
    }

    @Override
    public void start() {
        System.out.println("Boat is starting.");
        ignitePropulsionSystem();
    }

    @Override
    public void accelerate() {
        if (isPropulsionSystemRunning()) {
            System.out.println("Boat is accelerating.");
        } else {
            System.out.println("Boat cannot accelerate. Propulsion system is not running.");
        }
    }
}
