package org.advent.day11;

import org.junit.jupiter.api.Test;
import org.hamcrest.MatcherAssert;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestSolverShould {

    @Test
    void calculate_the_solution_for_puzzle_a() {

        List<String> input = List.of(
                "...#......",
                ".......#..",
                "#.........",
                "..........",
                "......#...",
                ".#........",
                ".........#",
                "..........",
                ".......#..",
                "#...#.....");

        MatcherAssert.assertThat(Solver.solvePuzzleA(input), equalTo(374.0));

    }

}
