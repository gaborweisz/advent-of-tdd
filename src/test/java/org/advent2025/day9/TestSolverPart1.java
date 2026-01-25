package org.advent2025.day9;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestSolverPart1 {


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
        SolverPart1 solverPart1 = new SolverPart1();

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

        MatcherAssert.assertThat(solverPart1.solvePuzzle(input), equalTo(50L));
    }
}
