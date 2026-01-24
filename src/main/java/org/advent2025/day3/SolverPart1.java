package org.advent2025.day3;

import util.FileReader;

import java.util.List;

public class SolverPart1 {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day3.txt");

        System.out.println("Solution for day 2025 / day 3 / a : " + new SolverPart1().solvePuzzle(rows));
    }

    long solvePuzzle(List<String> rows) {

        long totalVoltageOutput = 0;
        for (String row : rows) {
            totalVoltageOutput += getVoltageOutput(row);
        }

        return totalVoltageOutput;
    }

    long getVoltageOutput(String row) {
        long maxVoltage = 0;
        for (int i = 0; i < row.length() - 1; i++) {
            char c = row.charAt(i);
            for (int j = i + 1; j < row.length(); j++) {
                char d = row.charAt(j);
                long voltage = Long.parseLong(String.valueOf(c) + d);
                if (voltage > maxVoltage) {
                    maxVoltage = voltage;
                }
            }
        }
        return maxVoltage;
    }

}
