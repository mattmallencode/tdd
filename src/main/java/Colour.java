import java.util.Arrays;
import java.util.List;
public class Colour {
    private float red;
    private float green;
    private float blue;
    /**
     * Constructor for a representation of colour.
     * @param red - the amount of red in the colour from 0.0F to 1.0F inclusive.
     * @param green - the amount of green in the colour from 0.0F to 1.0F inclusive.
     * @param blue - the amount of blue in the colour from 0.0F to 1.0F inclusive.
     */
    public Colour(float red, float green, float blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        if (red > 1.0F || green > 1.0F || blue > 1.0F) {
            throw new IllegalArgumentException("RGB params must all be equal to or less than 1.0F");
        }
        if (red < 0.F || green < 0.F || blue < 0.F) {
            throw new IllegalArgumentException("RGB params must all be equal to or greater than 0.F");
        }
    }
    /**
     * Constructor for a representation of colour.
     * @param rgbInHex - string of 6 hex characters representing colour, first 2 characters represent BLUE, second 2 characters represent GREEN, last 2 characters represent RED.
     */
    public Colour(String rgbInHex) {
        validateRGBHex(rgbInHex);
        parseRGBHexThenSet(rgbInHex);
    }
    /**
     * Method to parse a 6 character rgb hex string and then set the corresponding red, green, and blue attributes.
     * @param rgbInHex - a 6 character hex string representing RGB: first 2 characters represent BLUE, second 2 characters represent GREEN, last 2 characters represent RED.
     */
    public void parseRGBHexThenSet(String rgbInHex) {
        List<String> rgbValues = Arrays.asList(rgbInHex.split("(?<=\\G.{2})")); // Borrowed from: https://stackoverflow.com/questions/4788596/split-string-into-several-two-character-strings
        Long redInteger = Long.parseLong(rgbValues.get(2), 16);
        Long greenInteger = Long.parseLong(rgbValues.get(1), 16);
        Long blueInteger = Long.parseLong(rgbValues.get(0), 16);
        this.setRed((float) (redInteger.intValue()) / 255.0F);
        this.setGreen((float) (greenInteger.intValue() / 255.0F));
        this.setBlue((float) (blueInteger.intValue()) / 255.0F);
    }
    /**
     * Getter for the red attribute.
     * @return the red value of this colour.
     */
    public float getRed() {
        return this.red;
    }
    /**
     * Getter for the green attribute.
     * @return the blue value of this colour.
     */
    public float getGreen() {
        return this.green;
    }
    /**
     * Getter for the blue attribute.
     * @return the blue value.
     */
    public float getBlue() {
        return this.blue;
    }
    /**
     * Setter for the red attribute. Validates the value before setting.
     * @param r - the new red value.
     */
    public void setRed(float r) {
        if (!validateRGBBeforeSet(r)) {
            throw new IllegalArgumentException("RGB params must all be equal to or less than 1.0F");
        }
        this.red = r;
    }
    /**
     * Setter for the green attribute. Validates the value before setting.
     * @param g - the new green value.
     */
    public void setGreen(float g) {
        if (!validateRGBBeforeSet(g)) {
            throw  new IllegalArgumentException("RGB params must all be equal to or less than 1.0F");
        }
        this.green = g;
    }
    /**
     * Setter for the blue attribute. Validates the value before setting.
     * @param b - the new blue value.
     */
    public void setBlue(float b) {
        if (!validateRGBBeforeSet(b)) {
            throw  new IllegalArgumentException("RGB params must all be equal to or less than 1.0F");
        }
        this.blue = b;
    }
    /**
     * Setter for the colour attributes.
     * @param rgbInHex - a 6 character hex string representing RGB: first 2 characters represent BLUE, second 2 characters represent GREEN, last 2 characters represent RED.
     */
    public void setRGB(String rgbInHex) {
        validateRGBHex(rgbInHex);
        parseRGBHexThenSet(rgbInHex);
    }
    /**
     * Method that validates an R, G or B float value before it is set.
     * @param rgbValue - a value for red, green, or blue from 0 to 1.0.
     * @return true/false of whether the value falls within the valid range.
     */
    public boolean validateRGBBeforeSet(float rgbValue) {
        if (rgbValue > 1.0F || rgbValue < 0.0F) {
            return false;
        }
        return true;
    }
    /**
     * Method that throws an exception if a String is not valid 24-bit RGB represented in hex.
     * @param rgbInHex - a string of 6 hex characters representing RGB values.
     */
    public void validateRGBHex(String rgbInHex) {
        if (rgbInHex.length() != 6) {
            throw new IllegalArgumentException("RGB param in hex must be 6 chars long!");
        }
        for (int i = 0; i < rgbInHex.length(); i++) {
            char character = rgbInHex.charAt(i);
            if ((character < '0' || character > '9') && (character < 'A' || character > 'F')) {
                throw new IllegalArgumentException("That is not valid hex! Hex characters are 0-9 (inclusive) A-F (UPPER inclusive).");
            }
        }
    }
    /**
     * Method that overrides the equals method of this class.
     * @param otherObject - the other instance of colour we're comparing against.
     * @return true/false of whether that the instances have equal colour attributes e.g. red1=red2, green1=green2, blue1=blue2.
     */
    @Override
    public boolean equals(Object otherObject) {
        Colour otherColour = (Colour) otherObject;
        return ((this.red == otherColour.red) && (this.green == otherColour.green) && (this.blue == otherColour.blue));
    }
}
