package org.advent2025.day4;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestSolverPart2 {


    /**
     * Given the input:
     * ..@@.@@@@.
     * @@@.@.@.@@
     * @@@@@.@.@@
     * @.@@@@..@.
     * @@.@@@@.@@
     * .@@@@@@@.@
     * .@.@.@.@@@
     * @.@@@.@@@@
     * .@@@@@@@@.
     * @.@.@@@.@.
     * then the result should be 13
     */

    @Test
    void test_solvePuzzle() {
        SolverPart2 solverPart2 = new SolverPart2();

        List<String> input = List.of(
                "..@@.@@@@.",
                "@@@.@.@.@@",
                "@@@@@.@.@@",
                "@.@@@@..@.",
                "@@.@@@@.@@",
                ".@@@@@@@.@",
                ".@.@.@.@@@",
                "@.@@@.@@@@",
                ".@@@@@@@@.",
                "@.@.@@@.@."
        );

        MatcherAssert.assertThat(solverPart2.solvePuzzle(input), equalTo(43));
    }
}
