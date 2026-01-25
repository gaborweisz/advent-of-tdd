package org.advent2025.day7;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestSolverPart2 {


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
     * The solutions should be 40
     */

    @Test
    void test_solvePuzzle() {
        SolverPart2 solverPart2 = new SolverPart2();

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

        MatcherAssert.assertThat(solverPart2.solvePuzzle(input), equalTo(40L));
    }
}
