import no.noroff.accelerate.vehicles.Boat;
import no.noroff.accelerate.vehicles.Car;
import no.noroff.accelerate.vehicles.CombustionEngine;
import no.noroff.accelerate.vehicles.PropulsionSystem;
import no.noroff.accelerate.vehicles.Vehicle;
import no.noroff.accelerate.vehicles.WarpEngine;

public class Dealership {

    public static void main(String[] args) {

        // Create a car with a WarpEngine propulsion system
        // Refernece propulsion system using the PropulsionSystem interface
        // Car doesn't care about the implementation, it knows that a PropulsionSystem
        // has methods to iginite, get effect etc.
        PropulsionSystem carEngine = new WarpEngine(300.0f);
        Vehicle car = new Car("Toyota", "Camry", carEngine);
        car.start();
        car.accelerate();
        car.move();

        // Create a boat with a CombustionEngine propulsion system
        PropulsionSystem boatEngine = new CombustionEngine(200.0f);
        // Can refernce the boat using it's superclass (parent) because a Boat is a Vehicle
        Vehicle boat = new Boat("SeaRay", "Sundancer", boatEngine);
        boat.start();
        boat.accelerate();
        boat.move();

    }

}
