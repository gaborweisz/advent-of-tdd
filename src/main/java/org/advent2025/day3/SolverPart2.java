package org.advent2025.day3;

import util.FileReader;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SolverPart2 {


    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day3.txt");

        System.out.println("Solution for day 2025 / day 3 / ab: " + new SolverPart2().solvePuzzle(rows));
    }

    long solvePuzzle(List<String> rows) {

        long totalVoltageOutput = 0;
        for (String row : rows) {
            long rowVoltage = getLargestVoltage(row, 11);
            totalVoltageOutput += rowVoltage;
        }

        return totalVoltageOutput;
    }


    long getLargestVoltage(String sequence, int length_to_skip) {

        StringBuilder maxVoltageBuilder = new StringBuilder();

        while (length_to_skip >= 0) {

            boolean foundDigit = false;
            for (int digit = 9; digit > 0; digit--) {
                for (int i = 0; i < sequence.length() - length_to_skip; i++) {
                    int currentDigit = Integer.parseInt(sequence.substring(i, i + 1));
                    if (currentDigit == digit) {
                        maxVoltageBuilder.append(digit);
                        sequence = sequence.substring(i + 1);
                        length_to_skip--;
                        foundDigit = true;
                        break;
                    }
                }
                if (foundDigit) {
                    break;
                }
            }
        }
        return Long.parseLong(maxVoltageBuilder.toString());
    }
}


