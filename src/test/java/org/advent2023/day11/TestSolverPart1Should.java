package org.advent2023.day11;

import org.junit.jupiter.api.Test;
import org.hamcrest.MatcherAssert;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestSolverPart1Should {

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
