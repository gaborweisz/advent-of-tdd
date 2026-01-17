package org.advent2023.day9;

import util.FileReader;

import java.util.List;

/**
 * Solution for https://adventofcode.com/2023/day/9
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2023_day9.txt");
        System.out.printf("Solution for day 9 / a : %.0f \n" , solvePuzzleA(rows));
        System.out.printf("Solution for day 9 / b : %.0f \n" , solvePuzzleB(rows));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param rows input
     * @return solution
     */
    public static double solvePuzzleA(List<String> rows) {

        OasisReport oasisReport = new OasisReport(rows);
        return oasisReport.extrapolateLinesAndSum();
    }

    /**
     * Calculates the solution for puzzle b
     *
     * @param rows input
     * @return solution
     */
    public static double  solvePuzzleB(List<String> rows) {
        OasisReport oasisReport = new OasisReport(rows);
        return oasisReport.extrapolateLinesFirstValueAndSum();
    }
}
