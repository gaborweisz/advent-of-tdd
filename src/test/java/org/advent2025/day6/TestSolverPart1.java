package org.advent2025.day6;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestSolverPart1 {


    /**
     * Given teh following input :
     * 123 328  51 64
     *  45 64  387 23
     *   6 98  215 314
     * *   +   *   +
     *
     * The solutions should be 4277556
     */

    @Test
    void test_solvePuzzle() {
        SolverPart1 solverPart1 = new SolverPart1();

        List<String> input = List.of(
                "123 328  51 64",
                " 45 64  387 23",
                "  6 98  215 314",
                "*   +   *   +"
        );

        MatcherAssert.assertThat(solverPart1.solvePuzzle(input), equalTo(4277556L));
    }
}
