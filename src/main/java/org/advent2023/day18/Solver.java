package org.advent2023.day18;

import util.FileReader;

import java.util.List;

/**
 * Solution for https://adventofcode.com/2023/day/18
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_day18.txt");
        System.out.printf("Solution for day 18 / a : %d\n" , solvePuzzleA(rows));
        System.out.printf("Solution for day 18 / b : %d\n" , solvePuzzleB(rows));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param rows input
     * @return solution
     */
    public static int solvePuzzleA(List<String> rows) {

        Digger d = new Digger(rows, 1000, 1000);
        return d.calculateTrenchCapacity();
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
