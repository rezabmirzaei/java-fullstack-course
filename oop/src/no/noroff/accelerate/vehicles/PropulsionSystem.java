package no.noroff.accelerate.vehicles;

// Interface representing a propulsion system for vehicles
// Like combustion/steam/electric engines, nuclear/wind propulsion, etc
public interface PropulsionSystem {

    void ignite();

    boolean isRunning();

    float getEffect();

}
