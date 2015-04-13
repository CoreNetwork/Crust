package us.core_network.crust.util;

/**
 * contains a min and max value
 */
public class Bounds {
    private int lower, upper;

    public Bounds(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public int getLower() {
        return lower;
    }

    public int getUpper() {
        return upper;
    }

    public boolean isBetween(int val) {
        return (val >= getLower() && val <= getUpper());
    }
}
