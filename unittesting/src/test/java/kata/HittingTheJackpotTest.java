package kata;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import no.noroff.accelerate.kata.HittingTheJackpot;

public class HittingTheJackpotTest {

    @Test
    public void testJackpot_got_jackpot() {
        HittingTheJackpot htjp = new HittingTheJackpot();
        assertTrue(htjp.jackpot(new String[] { "@", "@", "@", "@" }));
    }

    @Test
    public void testJackpot_null_input_exception() {
        HittingTheJackpot htjp = new HittingTheJackpot();
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            htjp.jackpot(null);
        });
    }

}
