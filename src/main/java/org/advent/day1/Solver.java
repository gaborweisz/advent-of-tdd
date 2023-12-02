package org.advent.day1;

import util.FileReader;

import java.util.List;

/**
 * Solution for day 1: https://adventofcode.com/2023/day/1
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rowsa = f.readFileAndConvertToStringArray("puzzleinput_day1.txt");
        List<String> rowsb = f.readFileAndConvertToStringArray("puzzleinput_day1.txt");
        System.out.println("Solution for day 1 / a : "  + solvePuzzleA(rowsa));
        System.out.println("Solution for day 1 / b : "  + solvePuzzleB(rowsb));
    }

    public static int solvePuzzleA(List<String> rows)  {
        int sumDigit = 0;
        for (String row :  rows) {
            sumDigit +=  Calibrator.getCalibrationValue(row);
        }
        return sumDigit;
    }

    public static int solvePuzzleB(List<String> rows)  {
        int sumDigit = 0;
        for (String row :  rows) {
            sumDigit +=  Calibrator.getCalibrationValueText(row);
        }
        return sumDigit;
    }
}
