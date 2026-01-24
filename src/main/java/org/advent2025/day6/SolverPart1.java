package org.advent2025.day6;

import util.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolverPart1 {


    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day6.txt");

        System.out.println("Solution for day 2025 / day 6 / a : " + new SolverPart1().solvePuzzle(rows));
    }

    long solvePuzzle(List<String> rows) {

        long total = 0;
        int[][] numbers = parseNumbers(rows);
        char[] operations = parseOperations(rows);

        for (int opIndex = 0; opIndex < operations.length; opIndex++) {
            char operation = operations[opIndex];
            long sum = 0;
            long mul = 1;
            for (int i = 0; i < numbers.length; i++) {
                int number = numbers[i][opIndex];
                if (operation == '+') {
                    sum += number;
                } else if (operation == '*') {
                    mul *= number;
                }
            }
            total += operation == '+' ? sum : mul;
        }

        return total;
    }

    int[][] parseNumbers(List<String> rows) {
        int[][] numbers = new int[rows.size()-1][];
        for (int i = 0; i < rows.size()-1; i++) {
            String[] parts = Arrays.stream(rows.get(i).split(" ")).filter(s -> !s.isBlank()).toArray(String[]::new);
            numbers[i] = new int[parts.length];
            for (int j = 0; j < parts.length; j++) {
                numbers[i][j] = Integer.parseInt(parts[j]);
            }
        }
        return numbers;
    }

    char[] parseOperations(List<String> rows) {
        String[] parts = Arrays.stream(rows.get(rows.size()-1).split(" ")).filter(s -> !s.isBlank()).toArray(String[]::new);
        char[] ops = new char[parts.length];

        for (int i = 0; i < parts.length; i++) {
            ops[i] = parts[i].charAt(0);
        }
        return ops;
    }




}
