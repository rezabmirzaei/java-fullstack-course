package no.noroff.accelerate.kata;

public class HittingTheJackpot {
    
    public boolean jackpot(String[] outcome) {
        if (outcome == null) {
            throw new IllegalArgumentException("Outcome cannot be null!");
        }
        if (outcome.length < 1) {
            // TODO Check and potentially throw exception or return false
        }
        String first = outcome[0];
        for (int i = 1; i < outcome.length; i++) {
            if (!first.equals(outcome[i])) {
                return false;
            }
        }
        return true;
    }

}
