package org.advent2025.day7;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestSolverPart1 {


    /**
     * Given teh following input :
     * .......S.......
     * ...............
     * .......^.......
     * ...............
     * ......^.^......
     * ...............
     * .....^.^.^.....
     * ...............
     * ....^.^...^....
     * ...............
     * ...^.^...^.^...
     * ...............
     * ..^...^.....^..
     * ...............
     * .^.^.^.^.^...^.
     * ...............
     * The solutions should be 21
     */

    @Test
    void test_solvePuzzle() {
        SolverPart1 solverPart1 = new SolverPart1();

        List<String> input = List.of(
                ".......S.......",
                    "...............",
                    ".......^.......",
                    "...............",
                    "......^.^......",
                    "...............",
                    ".....^.^.^.....",
                    "...............",
                    "....^.^...^....",
                    "...............",
                    "...^.^...^.^...",
                    "...............",
                    "..^...^.....^..",
                    "...............",
                    ".^.^.^.^.^...^.",
                    "..............."
        );

        MatcherAssert.assertThat(solverPart1.solvePuzzle(input), equalTo(21L));
    }
}
