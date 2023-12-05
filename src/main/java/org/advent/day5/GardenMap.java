package org.advent.day5;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a map from the almanac
 *
 * For example :
 * seed-to-soil map:
 * 50 98 2
 * 52 50 48
 */
public class GardenMap {

    String name;
    String sourceId;
    String destinationId;
    List<Range> ranges;

    //seed-to-soil map:
    public GardenMap(String row) {
        this.name = row.split(" ")[0];
        this.sourceId = row.split(" ")[0].split("-to-")[0];
        this.destinationId = row.split(" ")[0].split("-to-")[1];
        this.ranges = new ArrayList<>();
    }

    public void addRange(String row) {
        ranges.add(new Range(row));
    }

    public Double getCorrespondingNumber(Double sourceNumber) {
        for (Range range : ranges) {
            if (sourceNumber >= range.sourceRange && sourceNumber <= range.sourceRange + range.rangeLength - 1) {
                double sourceDelta = sourceNumber - range.sourceRange;
                return  range.destinationRange + sourceDelta;
            }
        }
        return sourceNumber;
    }

}
