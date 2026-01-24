package org.advent2025.day3;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestSolverPart2 {


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
        SolverPart2 solverPart2 = new SolverPart2();
        var input = List.of(
                "987654321111111",
                "811111111111119",
                "234234234234278",
                "818181911112111"
        );
        MatcherAssert.assertThat(solverPart2.solvePuzzle(input), equalTo(3121910778619L));
    }

    @Test
    void test_getLargestVoltage() {
        SolverPart2 solverPart2 = new SolverPart2();
        MatcherAssert.assertThat(solverPart2.getLargestVoltage("234234234234278", 11), equalTo(434234234278L));
        MatcherAssert.assertThat(solverPart2.getLargestVoltage("987654321111111", 11), equalTo(987654321111L));
        MatcherAssert.assertThat(solverPart2.getLargestVoltage("811111111111119", 11), equalTo(811111111119L));
        MatcherAssert.assertThat(solverPart2.getLargestVoltage("818181911112111", 11), equalTo(888911112111L));
    }


}


