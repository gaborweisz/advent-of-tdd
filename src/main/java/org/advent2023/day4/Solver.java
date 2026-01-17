package org.advent2023.day4;

import util.FileReader;

import java.util.List;

/**
 * Solution for day 4: https://adventofcode.com/2023/day/4
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_day4.txt");
        System.out.printf("Solution for day 4 / a : %.0f\n", solvePuzzleA(rows));
        System.out.printf("Solution for day 4 / b : %.0f\n", solvePuzzleB(rows));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param rows input
     * @return solution
     */
    public static double solvePuzzleA(List<String> rows) {

        return rows.stream().map(Card::parseCard).mapToDouble(Card::calculatePoints).sum();
    }

    /**
     * Calculates the solution for puzzle b
     *
     * @param rows input
     * @return solution
     */
    public static double  solvePuzzleB(List<String> rows) {

        Deck deck = new Deck(rows);
        deck.calculateCopies();
        return deck.calculateCards();
    }
}
