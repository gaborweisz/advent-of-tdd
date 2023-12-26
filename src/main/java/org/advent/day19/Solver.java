package org.advent.day19;

import util.FileReader;

import java.util.List;

/**
 * Solution for https://adventofcode.com/2023/day/19
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_day19.txt");
        System.out.printf("Solution for day 19 / a : %d\n" , solvePuzzleA(rows));
        System.out.printf("Solution for day 19 / b : %d\n" , solvePuzzleB(rows));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param rows input
     * @return solution
     */
    public static int solvePuzzleA(List<String> rows) {
        PartProcessor partProcessor = new PartProcessor(rows);
        partProcessor.process();

        return partProcessor.parts.stream().filter(p -> p.state == Part.State.ACCEPTED).mapToInt(Part::sum).sum();
    }

    /**
     * Calculates the solution for puzzle b
     *
     * @param rows input
     * @return solution
     */
    public static int  solvePuzzleB(List<String> rows) {

        return 0;
    }
}
