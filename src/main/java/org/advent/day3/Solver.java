package org.advent.day3;

import util.FileReader;

import java.util.List;

/**
 * Solution for day 3: https://adventofcode.com/2023/day/3
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_day3.txt");
        System.out.println("Solution for day 3 / a : " + solvePuzzleA(rows));
        System.out.println("Solution for day 3 / b : " + solvePuzzleB(rows));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param rows input
     * @return solution
     */
    public static int solvePuzzleA(List<String> rows) {

        Engine engine = new Engine(rows);
        engine.parseParts();

        return engine.parts.stream().filter(p -> p.valid).mapToInt(p -> p.number).sum();
    }

    /**
     * Calculates the solution for puzzle b
     *
     * @param rows input
     * @return solution
     */
    public static int solvePuzzleB(List<String> rows) {

        Engine engine = new Engine(rows);
        engine.parseParts();
        engine.parseGears();

        return engine.gears.values().stream().filter(p -> p.size() == 2).mapToInt(p -> p.stream().mapToInt(part -> part.number).reduce(1, (a, b) -> a * b)).sum();
    }
}
