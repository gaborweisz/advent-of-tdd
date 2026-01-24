package org.advent2025.day5;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestSolverPart1 {


    /**
     * Given teh following imput :
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
     * The solutions should be 3
     */

    @Test
    void test_solvePuzzle() {
        SolverPart1 solverPart1 = new SolverPart1();

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

        MatcherAssert.assertThat(solverPart1.solvePuzzle(input), equalTo(3));
    }
}
