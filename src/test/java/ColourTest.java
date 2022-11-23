import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ColourTest {
    /**
     * Test method that checks that an IllegalArgumentException is raised when any of the rgb params are greater than 1.0F.
     */
    @Test
    void test3ParamUpperRangeException() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colour colourWithRedGreaterThanOne = new Colour(1.1F, 1.0F, 1.0F);
        });
        Assertions.assertEquals("RGB params must all be equal to or less than 1.0F", exception.getMessage());
    }

    /**
     * Test method that checks that an IllegalArgumentException is raised when any of the rgb params are less than 1.0F.
     */
    @Test
    void test3ParamLowerRangeException() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
           Colour colourWithRedLessThanZero = new Colour(-0.1F, 0.0F, 0.0F);
        });
        Assertions.assertEquals("RGB params must all be equal to or greater than 0.F", exception.getMessage());
    }

    @Test
    void testHexColourConstructor() {
        Colour colour = new Colour("FFFFFF");
    }

    @Test
    void testHexInputTooShortException() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colour colourWithRedLessThanZero = new Colour("FF");
        });
    }
}