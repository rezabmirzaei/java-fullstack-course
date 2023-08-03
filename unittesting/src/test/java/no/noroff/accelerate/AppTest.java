package no.noroff.accelerate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testConvertToUppercase_pass() {
        App app = new App();
        String expected = "HELLO";
        // assertTrue(expected.equals(app.convertToUppercase("hello")));
        assertEquals(expected, app.convertToUppercase("hello"), "Not properly converted!");
    }

    @Test
    public void testSomeMethod_noExeptionThrown() {
        App app = new App();
        // Make sure no exception is thrown
        // Nullpoitner exception is handled in method (try/catch)
        assertDoesNotThrow(() -> {
            app.someMethod(null);
        });

    }

}
