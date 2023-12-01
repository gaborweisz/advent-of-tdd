package org.advent.day1;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestSolverShould {

    @Test
    void calculate_the_sum_of_the_digits_a() {

        List<String> input = List.of(
                "1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet");

        MatcherAssert.assertThat(Solver.solvePuzzleA(input), equalTo(142));
    }

    @Test
    void calculate_the_sum_of_the_digits_b() {

        List<String> input = List.of(
                "two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen");

        MatcherAssert.assertThat(Solver.solvePuzzleB(input), equalTo(281));
    }
}
