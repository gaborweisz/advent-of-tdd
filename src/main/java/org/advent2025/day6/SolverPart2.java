package org.advent2025.day6;

import util.FileReader;
import util.MatrixUtil;

import java.util.Arrays;
import java.util.List;

public class SolverPart2 {


    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day6.txt");

        System.out.println("Solution for day 2025 / day 6 / b : " + new SolverPart2().solvePuzzle(rows));
    }

    long solvePuzzle(List<String> rows) {

        long total = 0;
        char[][] numbers = MatrixUtil.convertStringListToMatrix(rows);
        char[] operations = parseOperations(rows);
        int operationIndex = operations.length - 1;

        MatrixUtil.printMatrix(numbers);

        long sum = 0;
        long mul = 1;

        StringBuilder builder = new StringBuilder();

        for (int colIndex = numbers[0].length - 1; colIndex >= 0; colIndex--) {
            int number = parseNumberFromMatrixColumn(numbers, colIndex);
            char operation = operations[operationIndex];
            builder.append(number).append(operation);
            if (operation == '+') {
                sum += number == -1 ? 0 : number;
            } else if (operation == '*') {
                mul *= number == -1 ? 1 : number;
            }
            
            if (number == -1 || colIndex == 0) {
                total += operation == '+' ? sum : mul;
                builder.append(" = ").append(operation == '+' ? sum : mul).append("\n");
                System.out.print(builder);
                builder.setLength(0);
                sum = 0;
                mul = 1;
                operationIndex--;
            }
        }

        return total;
    }

    int parseNumberFromMatrixColumn(char[][] numbers, int colIndex) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numbers.length - 1; row++) {
            sb.append(numbers[row][colIndex]);
        }

        try {
            return Integer.parseInt(sb.toString().strip());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    char[] parseOperations(List<String> rows) {
        String[] parts = Arrays.stream(rows.get(rows.size() - 1).split(" ")).filter(s -> !s.isBlank()).toArray(String[]::new);
        char[] ops = new char[parts.length];

        for (int i = 0; i < parts.length; i++) {
            ops[i] = parts[i].charAt(0);
        }
        return ops;
    }

}
