package no.noroff.accelerate.vehicles;

public class WarpEngine implements PropulsionSystem {

    private boolean isRunning;
    private float effect;

    // Power measure scale? Warp power? Impulse power?

    public WarpEngine(float effect) {
        this.effect = effect;
    }

    @Override
    public void ignite() {
        System.out.println("Warp engine is ignited.");
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
