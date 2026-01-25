package org.advent2025.day9;

import org.advent2023.day10.Tile;
import util.FileReader;
import util.MatrixUtil;

import java.util.List;

public class SolverPart1 {

    static class Polong {
        long x;
        long y;

        Polong(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day9.txt" );

        System.out.println("Solution for day 2025 / day 9 / a : " + new SolverPart1().solvePuzzle(rows));
    }

    public long  solvePuzzle(List<String> input) {

        List<Polong> polongs = parseInput(input);
        long maxArea = 0;
        
        for (Polong p1 : polongs) {
            for (Polong p2 : polongs) {
                long  area = calculateRectangleArea(p1, p2);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        
        return maxArea;
    }
    
    long calculateRectangleArea(Polong p1, Polong p2) {
        long width = Math.abs(p2.x - p1.x) + 1;
        long height = Math.abs(p2.y - p1.y) + 1;
        //System.out.prlongln("p1: (" + p1.x + "," + p1.y + ") p2: (" + p2.x + "," + p2.y + ") => width: " + width + " height: " + height + " area: " + (width * height));
        return width * height;
    }
    
    List<Polong> parseInput(List<String> input) {
        return input.stream().map(line -> {
            String[] parts = line.split(",");
            long x = Long.parseLong(parts[0]);
            long y = Long.parseLong(parts[1]);
            return new Polong(x, y);
        }).toList();
    }

}
