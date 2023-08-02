import no.noroff.accelerate.vehicles.Boat;
import no.noroff.accelerate.vehicles.Car;
import no.noroff.accelerate.vehicles.CombustionEngine;
import no.noroff.accelerate.vehicles.PropulsionSystem;
import no.noroff.accelerate.vehicles.Vehicle;
import no.noroff.accelerate.vehicles.WarpEngine;

public class Dealership {

    public static void main(String[] args) {

        PropulsionSystem carEngine = new WarpEngine(300.0f);
        Car car = new Car("Toyota", "Camry", carEngine);
        car.start();
        car.accelerate();
        car.move();

        PropulsionSystem boatEngine = new CombustionEngine(200.0f);
        Vehicle boat = new Boat("SeaRay", "Sundancer", boatEngine);
        boat.start();
        boat.accelerate();
        boat.move();

    }

}
