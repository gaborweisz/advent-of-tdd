package org.advent2023.day5;

/**
 * Represents a range from the map
 *
 * For example :
 * 50 98 2
 */
public class Range {
    double destinationRange;
    double sourceRange;
    double rangeLength;

    public Range(String row) {

        //e.g. "50 98 2"
        String[] parts = row.split(" ");
        this.destinationRange = Double.parseDouble(parts[0]);
        this.sourceRange = Double.parseDouble(parts[1]);
        this.rangeLength = Double.parseDouble(parts[2]);
    }
}
