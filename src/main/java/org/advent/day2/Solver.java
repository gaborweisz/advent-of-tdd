package org.advent.day2;

import util.FileReader;

import java.util.List;

/**
 * Solution for day 2: https://adventofcode.com/2023/day/2
 */
public class Solver {

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_day2.txt");
        System.out.printf("Solution for day 2 / a : %d\n", solvePuzzleA(rows, 12,13,14));
        System.out.printf("Solution for day 2 / b : %d\n", solvePuzzleB(rows));
    }

    /**
     * Calculates the solution for puzzle a
     * @param rows  input
     * @param red number of red cubes
     * @param green number of green cubes
     * @param blue number of blue cubes
     * @return solution
     */
    public static int solvePuzzleA(List<String> rows, int red, int green, int blue)  {

        int sumGameId = 0;
        for (String row : rows) {
            Game game = Game.parse(row);
            if(game.isGamePossible(red, green, blue)){
                sumGameId += game.id;
            }
        }
        return sumGameId;
    }

    /**
     * Calculates the solution for puzzle b
     * @param rows input
     * @return solution
     */
    public static int solvePuzzleB(List<String> rows)  {

        int sumPowers = 0;
        for (String row : rows) {
            Game game = Game.parse(row);
            game.calculateFewestCubesNeeded();
            sumPowers += game.powerOfTheFewestCubesNeeded();
        }
        return sumPowers;
    }
}
