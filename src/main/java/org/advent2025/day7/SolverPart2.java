package org.advent2025.day7;

import util.FileReader;
import util.MatrixUtil;

import java.util.Arrays;
import java.util.List;

public class SolverPart2 {
    

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day7.txt");

        System.out.println("Solution for day 2025 / day 7 / b : " + new SolverPart2().solvePuzzle(rows));
    }

    public long solvePuzzle(List<String> input) {
        char[][] matrix = MatrixUtil.convertStringListToMatrix(input);
        int startCol = findStartingPosition(matrix);
        return countSplit(matrix, startCol);
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
    
    long countSplit(char[][] matrix, int startCol) {
        long[][] splitCount = new long[matrix.length][matrix[0].length];
        for (int col = 0; col < matrix[0].length; col++) {
            splitCount[matrix.length-1][col] = 1;
        }
        
        for (int row = matrix.length - 1; row > 0; row--) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == '^') {
                   splitCount[row-1][col] =  splitCount[row+1][col-1] + splitCount[row+1][col+1];
                } else if (matrix[row][col] == '.' && row < matrix.length -1) {
                    splitCount[row-1][col] = splitCount[row+1][col];
                }
            }
        }

        int startPos = findStartingPosition(matrix);
        return splitCount[1][startPos] ;
    }
    
    


}
