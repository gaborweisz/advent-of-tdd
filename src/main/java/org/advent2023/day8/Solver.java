package org.advent2023.day8;

import util.FileReader;

import java.util.List;

/**
 * Solution for https://adventofcode.com/2023/day/8
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_day8.txt");
        System.out.printf("Solution for day 8 / a : %.0f \n" , solvePuzzleA(rows));
        System.out.printf("Solution for day 8 / b : %.0f \n" , solvePuzzleB(rows));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param rows input
     * @return solution
     */
    public static double solvePuzzleA(List<String> rows) {

        DesertMap map = new DesertMap(rows);
        return map.findPath();
    }

    /**
     * Calculates the solution for puzzle b
     *
     * @param rows input
     * @return solution
     */
    public static double  solvePuzzleB(List<String> rows) {

        DesertMap map = new DesertMap(rows);
        return map.findMultiPathQuick();
    }
}
