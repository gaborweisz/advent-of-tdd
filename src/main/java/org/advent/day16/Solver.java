package org.advent.day16;

import org.advent.day14.ReflectorDish;
import org.advent.day15.Boxes;
import org.advent.day15.HashMaker;
import util.FileReader;
import util.ListUtil;
import util.MatrixUtil;

import java.util.List;

/**
 * Solution for https://adventofcode.com/2023/day/16
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_day16.txt");
        System.out.printf("Solution for day 16 / a : %d\n" , solvePuzzleA(rows));
        System.out.printf("Solution for day 16 / b : %d\n" , solvePuzzleB(rows));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param rows input
     * @return solution
     */
    public static int solvePuzzleA(List<String> rows) {

        MirrorField f = new MirrorField(rows);

        return  f.countEnergized(0,0, Direction.EAST);
    }

    /**
     * Calculates the solution for puzzle b
     *
     * @param rows input
     * @return solution
     */
    public static int  solvePuzzleB(List<String> rows) {

        MirrorField f = new MirrorField(rows);

        return f.findMaximumEnergy(rows);
    }
}
