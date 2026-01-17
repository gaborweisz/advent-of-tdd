package org.advent2023.day12;


import util.FileReader;

import java.util.List;

/**
 * Solution for https://adventofcode.com/2023/day/12
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2023_day12.txt");
        System.out.printf("Solution for day 12 / a : %d \n" , solvePuzzleA(rows));
        System.out.printf("Solution for day 12 / b : %d \n" , solvePuzzleB(rows));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param rows input
     * @return solution
     */
    public static int solvePuzzleA(List<String> rows) {

        ConditionRecord conditionRecord = new ConditionRecord(rows);
        return conditionRecord.calculateArrangements();
    }

    /**
     * Calculates the solution for puzzle b
     *
     * @param rows input
     * @return solution
     */
    public static int solvePuzzleB(List<String> rows) {

        return 0;
    }
}
