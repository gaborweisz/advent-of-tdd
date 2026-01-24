package org.advent2025.day5;

import util.FileReader;

import java.util.ArrayList;
import java.util.List;

public class SolverPart1 {

    static class IDRange {
        long start;
        long end;

        IDRange(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    List<IDRange> idRanges = new ArrayList<>();
    List<Long> idsToCheck = new ArrayList<>();

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day5.txt");

        System.out.println("Solution for day 2025 / day 5 / a : " + new SolverPart1().solvePuzzle(rows));
    }

    int solvePuzzle(List<String> rows) {

        parseRows(rows);
        int fresh = 0;

        for (Long id : idsToCheck) {
            for (IDRange range : idRanges) {
                if (id >= range.start && id <= range.end) {
                    fresh++;
                    break;
                }
            }
        }

        return fresh;
    }

    private void parseRows(List<String> rows) {

        for (String row : rows) {
            if (row.contains("-")) {
                String[] parts = row.split("-");
                long start = Long.parseLong(parts[0]);
                long end = Long.parseLong(parts[1]);
                idRanges.add(new IDRange(start, end));
            } else if (!row.isBlank()) {
                idsToCheck.add(Long.parseLong(row));
            }
        }
    }


}
