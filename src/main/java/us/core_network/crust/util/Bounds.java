package us.core_network.crust.util;

import java.io.Serializable;

/**
 * contains a min and max value
 */
public class Bounds implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bounds bounds = (Bounds) o;

        if (lower != bounds.lower) return false;
        return upper == bounds.upper;

    }

    @Override
    public int hashCode() {
        int result = lower;
        result = 31 * result + upper;
        return result;
    }
}
