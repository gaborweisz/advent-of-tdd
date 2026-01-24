package org.advent2025.day7;

import util.FileReader;
import util.MatrixUtil;

import java.util.List;

public class SolverPart1 {

    static class SplitCounter {
        int count = 0;

        void increment() {
            count++;
        }
    }

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day7.txt");

        System.out.println("Solution for day 2025 / day 7 / a : " + new SolverPart1().solvePuzzle(rows));
    }

    public long solvePuzzle(List<String> input) {
        char[][] matrix = MatrixUtil.convertStringListToMatrix(input);
        int startCol = findStartingPosition(matrix);
        SplitCounter splits = new SplitCounter();
        countSplit(matrix, 0, startCol, splits);
        MatrixUtil.printMatrix(matrix);

        System.out.println("number of # : " + MatrixUtil.countField(matrix, '#'));
        return splits.count;
    }

    int findStartingPosition(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S') {
                    return col;
                }
            }
        }
        return -1;
    }

    int countSplit(char[][] matrix, int startRow, int startCol, SplitCounter splitsSoFar) {

        for (int row = startRow; row < matrix.length; row++) {

            if (matrix[row][startCol] == '^') {
                splitsSoFar.increment();
                matrix[row][startCol] = '#';
                if (startCol > 0) {
                    // Can split to the left
                    countSplit(matrix, row + 1, startCol - 1, splitsSoFar);
                }
                if (startCol < matrix[row].length - 1 && row < matrix.length - 1) {
                    // Can split to the right
                    return countSplit(matrix, row + 1, startCol + 1, splitsSoFar);
                }
            } else if (matrix[row][startCol] == '#') {
                return 0;
            } else {
                matrix[row][startCol] = '|';
            }
        }

        //System.out.println("startCol = " + startCol + "Number of splits so far: " + splitsSoFar.count);
        //MatrixUtil.printMatrix(matrix);
        return 1;
    }


}
