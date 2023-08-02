package no.noroff.accelerate.vehicles;

// Like combustion/steam/electric engines, nuclear/wind propulsion, etc

public interface PropulsionSystem {

    void ignite();

    boolean isRunning();

    float getEffect();

}
