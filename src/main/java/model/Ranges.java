package main.java.model;

import java.util.Objects;

public class Ranges {
    private int lowerBound;
    private int upperBound;
    private char label;

    public Ranges(int lowerBound, int upperBound, char label) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.label = label;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public char getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ranges ranges = (Ranges) o;

        if (lowerBound != ranges.lowerBound) return false;
        if (upperBound != ranges.upperBound) return false;
        return label == ranges.label;
    }

    @Override
    public int hashCode() {
        int result = lowerBound;
        result = 31 * result + upperBound;
        result = 31 * result + (int) label;
        return result;
    }

    public boolean isInInterval(int item){
        return item>=this.lowerBound && item<this.upperBound;
    }
}
