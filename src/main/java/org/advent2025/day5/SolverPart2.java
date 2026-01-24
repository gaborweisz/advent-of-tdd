package org.advent2025.day5;

import util.FileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolverPart2 {

    static class IDRange implements Comparable <IDRange> {
        @Override
        public int compareTo(IDRange idRange) {
            return Long.compare(this.start, idRange.start);
        }

        long start;
        long end;

        IDRange(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day5.txt");

        System.out.println("Solution for day 2025 / day 5 / a : " + new SolverPart2().solvePuzzle(rows));
    }

    long solvePuzzle(List<String> rows) {

        List<IDRange> distinctRanges = squashRanges(parseRows(rows));
        long fresh = 0;

        for (IDRange range : distinctRanges) {
            fresh += (range.end - range.start + 1);
        }

        return fresh;
    }

    List<IDRange> parseRows(List<String> rows) {

        List<IDRange> idRanges = new ArrayList<>();

        for (String row : rows) {
            if (row.contains("-")) {
                String[] parts = row.split("-");
                long start = Long.parseLong(parts[0]);
                long end = Long.parseLong(parts[1]);
                idRanges.add(new IDRange(start, end));
            }
        }

        Collections.sort(idRanges);
        return idRanges;
    }

    List<IDRange> squashRanges(List<IDRange> ranges) {
        List<IDRange> squashed = new ArrayList<>();

        IDRange current = ranges.get(0);

        for (int i = 1; i < ranges.size(); i++) {
            IDRange next = ranges.get(i);

            if (current.end >= next.start - 1) {
                current.end = Math.max(current.end, next.end);
            } else {
                squashed.add(current);
                current = next;
            }
        }

        squashed.add(current);
        return squashed;
    }


}
