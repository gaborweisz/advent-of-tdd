package org.advent2025.day9;

import util.FileReader;
import util.MatrixUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolverPart2 {

    static class Tile {
        int x;
        int y;

        Tile(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day9.txt");

        System.out.println("Solution for day 2025 / day 9 / b : " + new SolverPart2().solvePuzzle(rows));
    }

    public long solvePuzzle(List<String> input) {

        System.out.println(Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");

        List<Tile> tiles = parseInput(input);
        int maxX = tiles.stream().mapToInt(t -> t.x).max().orElse(0);
        int maxY = tiles.stream().mapToInt(t -> t.y).max().orElse(0);
        char[][] grid = new char[maxX + 1][maxY + 1];

        System.out.println("Grid size: " + grid.length + "x" + grid[0].length);
        System.out.println("Filling grid with tiles...");
        fillGridWithTiles(grid, tiles);
        //MatrixUtil.printMatrix(grid);
        System.out.println("Filling enclosed areas...");
        fillEnclosedAreas(grid);
        //MatrixUtil.printMatrix(grid);

        System.out.println("Calculating max areas...");
        return calculateMaxArea(tiles, grid);
    }

    void fillGridWithTiles(char[][] grid, List<Tile> tiles) {
        for (Tile tile : tiles) {
            grid[tile.x][tile.y] = '#';
        }
        boolean greenTile = false;

        System.out.println("Vertical fill...");
        for (int row = 0; row < grid.length; row++) {
            if (row % 1000 == 0) {
                System.out.println("Processing row " + row + " / " + grid.length);
            }
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '#') {
                    greenTile = !greenTile;
                }
                if (grid[row][col] != '#' && greenTile) {
                    grid[row][col] = 'X';
                }
            }
        }

        System.out.println("Horizontal fill...");
        for (int col = 0; col < grid[0].length; col++) {
            greenTile = false;
            if (col % 1000 == 0) {
                System.out.println("Processing row " + col + " / " + grid[0].length);
            }
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == '#') {
                    greenTile = !greenTile;
                }
                if (grid[row][col] != '#' && greenTile) {
                    grid[row][col] = 'X';
                }
            }
        }

    }

    void fillEnclosedAreas(char[][] grid) {

        for (int row = 0; row < grid.length; row++) {
            int firstX = findFirstX(grid[row]);
            int lastX = findLastX(grid[row]);
            if (firstX == -1 || lastX == -1) continue; // No 'X' in this row, skip it
            for (int col = firstX; col <= lastX; col++) {
                if (grid[row][col] == '\0') {
                    grid[row][col] = 'X';
                }
            }
        }
    }

    int findFirstX(char[] row) {
        for (int col = 0; col < row.length; col++) {
            if (row[col] != '\0')
                return col;
        }
        return -1;
    }

    int findLastX(char[] row) {
        for (int col = row.length - 1; col >= 0; col--) {
            if (row[col] != '\0')
                return col;
        }
        return -1;
    }


    long calculateMaxArea(List<Tile> tiles, char[][] grid) {
        long maxArea = 0;
        for (int i = 0; i < tiles.size(); i++) {
            for (int j = i + 1; j < tiles.size() - 1; j++) {
                long area = calculateRectangleArea(tiles.get(i), tiles.get(j));
                if (area > maxArea) {
                    boolean valid = isValidRectangle(tiles.get(i), tiles.get(j), grid);
                    System.out.println((area) + " from " + tiles.get(i).x + "," + tiles.get(i).y + " to " + tiles.get(j).x + "," + tiles.get(j).y + ":: valid : " + valid);
                    if (!valid) continue;
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    boolean isValidRectangle(Tile p1, Tile p2, char[][] grid) {

        int minX = Math.min(p1.x, p2.x);
        int maxX = Math.max(p1.x, p2.x);
        int minY = Math.min(p1.y, p2.y);
        int maxY = Math.max(p1.y, p2.y);

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                if (grid[x][y] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    long calculateRectangleArea(Tile p1, Tile p2) {
        long width = Math.abs(p2.x - p1.x) + 1;
        long height = Math.abs(p2.y - p1.y) + 1;
        return width * height;
    }

    List<Tile> parseInput(List<String> input) {
        return input.stream().map(line -> {
            String[] parts = line.split(",");
            int y = Integer.parseInt(parts[0]);
            int x = Integer.parseInt(parts[1]);
            return new Tile(x, y);
        }).toList();
    }

}
