package org.advent2023.day10;

import util.FileReader;

import java.util.List;

/**
 * Solution for https://adventofcode.com/2023/day/10
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2023_day10.txt");
        System.out.printf("Solution for day 10 / a : %.0f \n" , solvePuzzleA(rows));
        System.out.printf("Solution for day 10 / b : %.0f \n" , solvePuzzleB(rows));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param rows input
     * @return solution
     */
    public static double solvePuzzleA(List<String> rows) {

        PipeCrawler pipeCrawler = new PipeCrawler(rows);
        return pipeCrawler.crawlTillTheEnd();
    }

    /**
     * Calculates the solution for puzzle b
     *
     * @param rows input
     * @return solution
     */
    public static double  solvePuzzleB(List<String> rows) {

        PipeCrawler pipeCrawler = new PipeCrawler(rows);
        pipeCrawler.crawlTillTheEnd();
        pipeCrawler.doublePileOnlyMap();

        double result = pipeCrawler.countEnclosedArea();
        pipeCrawler.printMap();
        return result;
    }
}
