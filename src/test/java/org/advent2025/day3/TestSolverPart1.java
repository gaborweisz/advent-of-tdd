package org.advent2025.day3;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestSolverPart1 {


    /**
     * Given the input:
     * 987654321111111
     * 811111111111119
     * 234234234234278
     * 818181911112111
     * then the result should be 357
     */
    @Test
    void test_solvePuzzle() {
        SolverPart1 solverPart1 = new SolverPart1();
        var input = List.of(
                "987654321111111",
                "811111111111119",
                "234234234234278",
                "818181911112111"
        );
        MatcherAssert.assertThat(solverPart1.solvePuzzle(input), equalTo(357L));
    }
}
