public class Colour {

    float red;
    float green;
    float blue;

    public Colour(float red, float green, float blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        if (red > 1.0F || green > 1.0F || blue > 1.0F) {
            throw new IllegalArgumentException("RGB params must all be below 1.0F");
        }
    }
}
