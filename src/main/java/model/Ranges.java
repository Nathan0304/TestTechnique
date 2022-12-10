package model;

import java.util.Objects;

public class Ranges {
    private final int lowerBound;
    private final int upperBound;
    private final char label;

    public Ranges(int lowerBound, int upperBound, char label) {
        if(upperBound<lowerBound){
            throw new ArithmeticException("La limite superieure doit etre superieur a la borne inferieure");
        }
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
        return lowerBound == ranges.lowerBound && upperBound == ranges.upperBound && label == ranges.label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lowerBound, upperBound, label);
    }

    public boolean isInInterval(int item){
        return item>=this.lowerBound && item<this.upperBound;
    }
}
