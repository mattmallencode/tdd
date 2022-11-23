import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class ColourTest {
    /**
     * Test method that checks that an IllegalArgumentException is raised when any of the rgb params for the 3 param constructor are greater than 1.0F.
     */
    @Test
    void testUpperFloatValidation() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colour colourWithRedGreaterThanOne = new Colour(1.1F, 1.0F, 1.0F);
        });
        Assertions.assertEquals("RGB params must all be equal to or less than 1.0F", exception.getMessage());
    }

    /**
     * Test method that checks that an IllegalArgumentException is raised when any of the rgb params for the 3 param constructor are less than 1.0F.
     */
    @Test
    void testLowerFloatValidation() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
           Colour colourWithRedLessThanZero = new Colour(-0.1F, 0.0F, 0.0F);
        });
        Assertions.assertEquals("RGB params must all be equal to or greater than 0.F", exception.getMessage());
    }

    /**
     * Test method that checks that if a string passed to the single param constructor isn't of length 6, an exception is raised.
     */
    @Test
    void testHexLengthValidation() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colour hexColourNot6Chars = new Colour("FF");
        });
        Assertions.assertEquals("RGB param in hex must be 6 chars long!", exception.getMessage());
    }


    /**
     * Test method that checks that if valid hex is passed to the single param constructor, no exception is raised.
     */
    @Test
    void testHexCharacterValidation() {
        List<String> validTestCases = Arrays.asList("63A80E", "ACA340", "4BD35C");
        for (int i = 0; i < validTestCases.size(); i++){
            final String testCase = validTestCases.get(i);
            Assertions.assertDoesNotThrow(() -> new Colour(testCase));
        }
    }

    /**
     * Test method that checks if invalid hex is passed to the single param constructor, an exception is raised.
     */
    @Test
    void testHexCharacterInvalidation() {
        List<String> invalidTestCases = Arrays.asList("//////", "::::::", "@@@@@@", "[[[[[[", "aaaaaa");
        for (int i = 0; i < invalidTestCases.size(); i++){
            final String testCase = invalidTestCases.get(i);
            Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Colour hexColourNot6Chars = new Colour(testCase);
            });
            Assertions.assertEquals("That is not valid hex! Hex characters are 0-9 (inclusive) A-F (UPPER inclusive).", exception.getMessage());
        }
    }

    @Test
    void testColourComparison() {
        Colour firstColour = new Colour(1.0F, 1.0F, 1.0F);
        Colour secondColour = new Colour(1.0F, 1.0F, 1.0F);
        Assertions.assertEquals(firstColour, secondColour);
        firstColour.red = 0.8F;
    }
}