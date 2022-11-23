public class Colour {

    float red;
    float green;
    float blue;

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
}
