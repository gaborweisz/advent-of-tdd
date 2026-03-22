package org.advent2025.day9;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestSolverPart12 {


    /**
     * Given teh following input :
     * 7,1
     * 11,1
     * 11,7
     * 9,7
     * 9,5
     * 2,5
     * 2,3
     * 7,3
     * The solutions should be 50
     */

    @Test
    void test_solvePuzzle() {
        SolverPart2 solverPart2 = new SolverPart2();

        List<String> input = List.of(
                "7,1",
                "11,1",
                "11,7",
                "9,7",
                "9,5",
                "2,5",
                "2,3",
                "7,3"
        );

        MatcherAssert.assertThat(solverPart2.solvePuzzle(input), equalTo(24L));
    }
}
