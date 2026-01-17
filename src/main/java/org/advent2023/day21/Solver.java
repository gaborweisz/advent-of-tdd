package org.advent2023.day21;

import util.FileReader;

import java.util.List;

/**
 * Solution for https://adventofcode.com/2023/day/21
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_day21.txt");
        System.out.printf("Solution for day 21 / a : %d\n" , solvePuzzleA(rows, 64));
        System.out.printf("Solution for day 21 / b : %d\n" , solvePuzzleB(rows));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param rows input
     * @return solution
     */
    public static int solvePuzzleA(List<String> rows, int iterations) {

        GardenMap map = new GardenMap(rows);
        return map.findReachablePlots(iterations) ;
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
