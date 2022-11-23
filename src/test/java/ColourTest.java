import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColourTest {
    @Test
    void testColourConstructor() {
        Colour colour = new Colour(1.0F, 1.0F, 1.0F);
    }

    @Test
    void testParamUpperRangeException() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colour colour = new Colour(1.1F, 1.0F, 1.0F);
        });
        Assertions.assertEquals("RGB params must all be below 1.0F", exception.getMessage());
    }
}