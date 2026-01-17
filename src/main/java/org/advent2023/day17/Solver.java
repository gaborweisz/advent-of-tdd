package org.advent2023.day17;


import util.FileReader;

import java.util.List;

/**
 * Solution for https://adventofcode.com/2023/day/17
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_day17.txt");
        System.out.printf("Solution for day 17 / a : %d\n" , solvePuzzleA(rows));
        System.out.printf("Solution for day 17 / b : %d\n" , solvePuzzleB(rows));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param rows input
     * @return solution
     */
    public static int solvePuzzleA(List<String> rows) {

        //1129  too high
        //1116 too high
        //1096 too high
        //1075 not right
        //1078 not right
        //1055 not right
        PathFinder pathFinder = new PathFinder(rows);
        pathFinder.findPath();
        return  pathFinder.calculateTotalHeat();
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
