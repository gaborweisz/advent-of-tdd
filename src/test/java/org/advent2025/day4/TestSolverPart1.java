package org.advent2025.day4;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestSolverPart1 {


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
        SolverPart1 solverPart1 = new SolverPart1();

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

        MatcherAssert.assertThat(solverPart1.solvePuzzle(input), equalTo(13));
    }
}
