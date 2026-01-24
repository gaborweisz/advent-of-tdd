package org.advent2025.day4;

import util.FileReader;
import util.MatrixUtil;

import java.util.List;

public class SolverPart2 {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day4.txt");

        System.out.println("Solution for day 2025 / day 4 / b : " + new SolverPart2().solvePuzzle(rows));
    }

    int solvePuzzle(List<String> rows) {
        char[][] grid = MatrixUtil.convertStringListToMatrix(rows);

        return countMovableRolls(grid);
    }

    int countMovableRolls(char[][] grid) {
        int count = 0;
        char[][] gridCopy = MatrixUtil.copyMatrix(grid);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '@' && MatrixUtil.countAdjacentChars(grid, '@', i, j) <= 3) {
                    count++;
                    gridCopy[i][j] = 'x';
                }
            }
        }

        return count == 0 ? 0 : count + countMovableRolls(gridCopy);
    }

}
