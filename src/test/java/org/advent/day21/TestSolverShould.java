package org.advent.day21;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestSolverShould {

    @Test
    void calculate_the_solution_for_puzzle_a() {

        List<String> input = List.of(
                "..........." ,
                ".....###.#." ,
                ".###.##..#." ,
                "..#.#...#.." ,
                "....#.#...." ,
                ".##..S####." ,
                ".##..#...#." ,
                ".......##.." ,
                ".##.#.####." ,
                ".##..##.##." ,
                "...........");

        MatcherAssert.assertThat(Solver.solvePuzzleA(input, 6), equalTo(16));

    }


}
