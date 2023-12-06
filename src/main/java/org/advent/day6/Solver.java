package org.advent.day6;


import java.util.List;

/**
 * Solution for day 6: https://adventofcode.com/2023/day/6
 * <p>
 * Time:        48     93     85     95
 * Distance:   296   1928   1236   1391
 */
public class Solver {

    public static void main(String[] args) {
        List<Boat> boats = List.of(
                new Boat(48, 296),
                new Boat(93, 1928),
                new Boat(85, 1236),
                new Boat(95, 1391)
        );

        System.out.printf("Solution for day 6 / a : %.0f //n", solvePuzzleA(boats));
        System.out.printf("Solution for day 6 / b : %.0f//n", solvePuzzleB(new Boat(48938595.0, 296192812361391.0)));
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @param boats input
     * @return solution
     */
    public static double solvePuzzleA(List<Boat> boats) {


        return boats.stream().mapToInt(b -> b.numberOfWaysToBeatTheRecord().intValue()).reduce(1, Math::multiplyExact);
    }

    /**
     * Calculates the solution for puzzle b
     *
     * @param boat input
     * @return solution
     */
    public static double solvePuzzleB(Boat boat) {

        return boat.numberOfWaysToBeatTheRecord();
    }
}
