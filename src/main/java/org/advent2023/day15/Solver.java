package org.advent2023.day15;

import util.FileReader;

/**
 * Solution for https://adventofcode.com/2023/day/15
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        String input = f.readFileAndConvertToString("puzzleinput_2023_day15.txt");
        System.out.printf("Solution for day 15 / a : %d \n", solvePuzzleA(input));
        System.out.printf("Solution for day 15 / b : %d \n", solvePuzzleB(input));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param input input
     * @return solution
     */
    public static int solvePuzzleA(String input) {

        return HashMaker.sumHashes(input);
    }

    /**
     * Calculates the solution for puzzle b
     *
     * @param input input
     * @return solution
     */
    public static int solvePuzzleB(String input) {

        Boxes boxes = new Boxes();
        return boxes.calculateSumFocusingPower(input);
    }
}
