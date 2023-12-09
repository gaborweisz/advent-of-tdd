package org.advent.day5;

import util.FileReader;

import java.util.List;

/**
 * Solution for day 5: https://adventofcode.com/2023/day/5
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_day5.txt");
        System.out.printf("Solution for day 5 / a : %.0f \n" , solvePuzzleA(rows));
        System.out.printf("Solution for day 5 / b : %.0f \n" , solvePuzzleB(rows));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param rows input
     * @return solution
     */
    public static double solvePuzzleA(List<String> rows) {

        Almanac almanac = new Almanac(rows);
        return almanac.getLowestLocationNumber();
    }

    /**
     * Calculates the solution for puzzle b
     *
     * @param rows input
     * @return solution
     */
    public static double  solvePuzzleB(List<String> rows) {

        Almanac almanac = new Almanac(rows);
        return almanac.getLowestLocationNumberFromSeedRanges();
    }
}
