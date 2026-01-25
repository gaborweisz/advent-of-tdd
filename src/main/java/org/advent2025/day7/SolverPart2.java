package org.advent2025.day7;

import util.FileReader;
import util.MatrixUtil;

import java.util.List;

public class SolverPart2 {

    static class SplitCounter {
        int count = 0;

        void increment() {
            count++;
        }
    }

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day7.txt");

        System.out.println("Solution for day 2025 / day 7 / b : " + new SolverPart2().solvePuzzle(rows));
    }

    public long solvePuzzle(List<String> input) {
        char[][] matrix = MatrixUtil.convertStringListToMatrix(input);
        int startCol = findStartingPosition(matrix);
        SplitCounter splits = new SplitCounter();
        countSplit(matrix, 0, startCol, splits);
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

    /**
     * Counts the number of splits in the matrix starting from the given position.
     * Nice visualization of the matrix is done by marking the path with '|' and splits with '#'.
     * It is too slow for large inputs, but works for the example input.
     * @param matrix
     * @param startRow
     * @param startCol
     * @param splitsSoFar
     * @return
     */
    int countSplit(char[][] matrix, int startRow, int startCol, SplitCounter splitsSoFar) {

        char[][] copyMatrix = MatrixUtil.copyMatrix(matrix);
        for (int row = startRow; row < matrix.length; row++) {

            if (copyMatrix[row][startCol] == '^') {
                copyMatrix[row][startCol] = '#';
                if (startCol > 0) {
                    // Can split to the left
                    countSplit(copyMatrix, row + 1, startCol - 1, splitsSoFar);
                }
                if (startCol < matrix[row].length - 1 && row < matrix.length - 1) {
                    // Can split to the right
                    return countSplit(copyMatrix, row + 1, startCol + 1, splitsSoFar);
                }
            } else if (copyMatrix[row][startCol] == '#') {
                return 0;
            } else {
                copyMatrix[row][startCol] = '|';
            }
        }

        splitsSoFar.increment();
        if (splitsSoFar.count % 10000 == 0) {
            System.out.println("startCol = " + startCol + "Number of splits so far: " + splitsSoFar.count);
            MatrixUtil.printMatrix(matrix);
        }
        return 1;
    }


}
