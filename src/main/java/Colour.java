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

    public Colour(String rgbInHex) {
        validateRGBHex(rgbInHex);
        parseRGBHexString(rgbInHex);
    }

    public void parseRGBHexString(String rgbInHex) {
        List<String> rgbValues = Arrays.asList(rgbInHex.split("(?<=\\G.{2})")); // Borrowed from: https://stackoverflow.com/questions/4788596/split-string-into-several-two-character-strings
        Long redInteger = Long.parseLong(rgbValues.get(0), 16);
        Long greenInteger = Long.parseLong(rgbValues.get(1), 16);
        Long blueInteger = Long.parseLong(rgbValues.get(2), 16);
        this.red = (float) (redInteger.intValue()) / 255.0F;
        this.green = (float) (greenInteger.intValue() / 255.0F);
        this.blue = (float) (blueInteger.intValue()) / 255.0F;
    }

    public float getRed() {
        return this.red;
    }

    public float getGreen() {
        return this.green;
    }

    public float getBlue() {
        return this.blue;
    }

    public void setRed(float r) {
        if (!validateRGBBeforeSet(r)) {
            throw new IllegalArgumentException();
        }
        this.red = r;
    }

    public void setGreen(float g) {
        if (!validateRGBBeforeSet(g)) {
            throw  new IllegalArgumentException();
        }
        this.green = g;
    }

    public void setBlue(float b) {
        if (!validateRGBBeforeSet(b)) {
            throw new IllegalArgumentException();
        }
        this.blue = b;
    }

    public boolean validateRGBBeforeSet(float rgbValue) {
        if (rgbValue > 1.0F || rgbValue < 0.0F) {
            return false;
        }
        return true;
    }

    /**
     * Method that throws an exception if a String is not valid 24-bit RGB represented in hex.
     *
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

    @Override
    public boolean equals(Object otherObject) {
        Colour otherColour = (Colour) otherObject;
        return ((this.red == otherColour.red) && (this.green == otherColour.green) && (this.blue == otherColour.blue));
    }
}
