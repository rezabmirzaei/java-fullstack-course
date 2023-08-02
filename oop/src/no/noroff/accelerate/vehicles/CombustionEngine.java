package no.noroff.accelerate.vehicles;

public class CombustionEngine implements PropulsionSystem {

    private boolean isRunning;
    private float effect;

    // Power measure scale? Horse powers?

    public CombustionEngine(float effect) {
        this.effect = effect;
    }

    @Override
    public void ignite() {
        System.out.println("Combustion engine is ignited.");
        isRunning = true;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public float getEffect() {
        return effect;
    }
}
