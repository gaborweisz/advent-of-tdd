package org.advent2025.day2;

import java.util.ArrayList;
import java.util.List;

public class SolverUtil {
    static List<Range> getRanges(String rangesStr) {
        String[] rangesParts = rangesStr.split(",");
        List<Range> ranges = new ArrayList<>();

        for (String rangesPart : rangesParts) {
            String[] bounds = rangesPart.split("-");
            long start = Long.parseLong(bounds[0]);
            long end = Long.parseLong(bounds[1]);
            ranges.add(new Range(start, end));
        }

        return ranges;
    }
}
