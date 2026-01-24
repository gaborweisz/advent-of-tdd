package org.advent2025.day4;

import util.FileReader;
import util.MatrixUtil;

import java.util.List;

public class SolverPart1 {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day4.txt");

        System.out.println("Solution for day 2025 / day 4 / a : " + new SolverPart1().solvePuzzle(rows));
    }

    int solvePuzzle(List<String> rows) {
        char[][] grid = MatrixUtil.convertStringListToMatrix(rows);

        return countMovableRolls(grid);
    }

    int countMovableRolls(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '@' && MatrixUtil.countAdjacentChars(grid, '@', i, j) <= 3) {
                    count++;
                }
            }
        }

        return count;
    }

}
