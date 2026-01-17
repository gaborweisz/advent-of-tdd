package org.advent2023.day6;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestSolverPart1Should {

    @Test
    void calculate_the_solution_for_puzzle_a() {

        //Time:      7  15   30
        //Distance:  9  40  200

        List<Boat> input = List.of(
                new Boat(7, 9),
                new Boat(15, 40),
                new Boat(30, 200));

        MatcherAssert.assertThat(Solver.solvePuzzleA(input), equalTo(288.0));
    }

    @Test
    void calculate_the_solution_for_puzzle_b() {

        //Time:      71530
        //Distance:  940200


        MatcherAssert.assertThat(Solver.solvePuzzleB(new Boat(71530, 940200)), equalTo(71503.0));
    }

}
