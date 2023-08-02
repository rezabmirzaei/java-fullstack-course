package no.noroff.accelerate.vehicles;

public abstract class Vehicle implements Drivable {
    
    private String make;
    private String model;

    // Example of composition
    private PropulsionSystem propulsionSystem;

    // Constructor with dependency injection of PropulsionSystem
    public Vehicle(String make, String model, PropulsionSystem propulsionSystem) {
        this.make = make;
        this.model = model;
        this.propulsionSystem = propulsionSystem;
    }

    // Common method for all vehicles
    public void move() {
        System.out.println(String.format("%s/%s is moving with an effect of %s.", make, model, propulsionSystem.getEffect()));
    }

    // Common method for all vehicles to ignite the propulsion system
    public void ignitePropulsionSystem() {
        propulsionSystem.ignite();
    }

    // Common method for all vehicles to check if the propulsion system is running
    public boolean isPropulsionSystemRunning() {
        return propulsionSystem.isRunning();
    }

    // Abstract method to be implemented by child classes to accelerate the vehicle
    public abstract void accelerate();
}