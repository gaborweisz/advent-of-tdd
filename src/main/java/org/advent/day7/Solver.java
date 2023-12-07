package org.advent.day7;

import org.advent.day5.Almanac;
import util.FileReader;

import java.util.List;

/**
 * Solution for https://adventofcode.com/2023/day/7
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_day7.txt");
        System.out.printf("Solution for day 7 / a : %.0f //n" , solvePuzzleA(rows));
        System.out.printf("Solution for day 7 / b : %.0f //n" , solvePuzzleB(rows));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param rows input
     * @return solution
     */
    public static double solvePuzzleA(List<String> rows) {

        Deck deck = new Deck(rows);
        return deck.calculateWinning();
    }

    /**
     * Calculates the solution for puzzle b
     *
     * @param rows input
     * @return solution
     */
    public static double  solvePuzzleB(List<String> rows) {

        JokerDeck deck = new JokerDeck(rows);
        return deck.calculateWinning();
    }
}
