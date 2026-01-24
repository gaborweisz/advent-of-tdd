package org.advent2025.day5;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestSolverPart2 {


    /**
     * Given teh following input :
     * 3-5
     * 10-14
     * 16-20
     * 12-18
     *
     * 1
     * 5
     * 8
     * 11
     * 17
     * 32
     *
     * The solutions should be 14
     */

    @Test
    void test_solvePuzzle() {
        SolverPart2 solverPart2 = new SolverPart2();

        List<String> input = List.of(
                "3-5",
                "10-14",
                "16-20",
                "12-18",
                "",
                "1",
                "5",
                "8",
                "11",
                "17",
                "32"
        );

        MatcherAssert.assertThat(solverPart2.solvePuzzle(input), equalTo(14));
    }
}
