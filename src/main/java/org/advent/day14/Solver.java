package org.advent.day14;


import org.advent.day13.MirrorMap;
import util.FileReader;
import util.ListUtil;
import util.MatrixUtil;

import java.util.List;

/**
 * Solution for https://adventofcode.com/2023/day/14
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_day14.txt");
        System.out.printf("Solution for day 14 / a : %.0f \n" , solvePuzzleA(rows));
        System.out.printf("Solution for day 14 / b : %.0f \n" , solvePuzzleB(rows));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param rows input
     * @return solution
     */
    public static double solvePuzzleA(List<String> rows) {
        return  ReflectorDish.calculateLoad(MatrixUtil.tiltNorth(ListUtil.convertToCharArrayMatrix(rows)));
    }

    /**
     * Calculates the solution for puzzle b
     *
     * @param rows input
     * @return solution
     */
    public static double  solvePuzzleB(List<String> rows) {

        return  ReflectorDish.calculateLoad(ReflectorDish.effectiveSpin(ListUtil.convertToCharArrayMatrix(rows), 1000000000));
    }
}
