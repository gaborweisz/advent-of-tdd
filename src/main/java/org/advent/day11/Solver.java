package org.advent.day11;


import util.FileReader;
import java.util.List;

/**
 * Solution for https://adventofcode.com/2023/day/11
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_day11.txt");
        System.out.printf("Solution for day 11 / a : %.0f \n" , solvePuzzleA(rows));
        System.out.printf("Solution for day 11 / b : %.0f \n" , solvePuzzleB(rows));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param rows input
     * @return solution
     */
    public static double solvePuzzleA(List<String> rows) {

        Observatory o = new Observatory(rows);
        return o.calculateTheSumDistancesOfAllGalaxyPairs(1);
    }

    /**
     * Calculates the solution for puzzle b
     *
     * @param rows input
     * @return solution
     */
    public static double  solvePuzzleB(List<String> rows) {

        Observatory o = new Observatory(rows);
        return o.calculateTheSumDistancesOfAllGalaxyPairs(1000000);
    }
}
