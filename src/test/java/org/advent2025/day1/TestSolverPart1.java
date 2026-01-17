package org.advent2025.day1;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestSolverPart1 {


    @Test
    void test_rotate_right() {
        SolverPart1 solverPart1 = new SolverPart1();
        MatcherAssert.assertThat(solverPart1.rotate(0, "R1"), equalTo(1));
        MatcherAssert.assertThat(solverPart1.rotate(0, "R99"), equalTo(99));
        MatcherAssert.assertThat(solverPart1.rotate(0, "R100"), equalTo(0));
        MatcherAssert.assertThat(solverPart1.rotate(0, "R101"), equalTo(1));
        MatcherAssert.assertThat(solverPart1.rotate(0, "R199"), equalTo(99));
        MatcherAssert.assertThat(solverPart1.rotate(0, "R299"), equalTo(99));
    }

    @Test
    void test_rotate_left() {
        SolverPart1 solverPart1 = new SolverPart1();
        MatcherAssert.assertThat(solverPart1.rotate(0, "L1"), equalTo(99));
        MatcherAssert.assertThat(solverPart1.rotate(0, "L99"), equalTo(1));
        MatcherAssert.assertThat(solverPart1.rotate(0, "L100"), equalTo(0));
        MatcherAssert.assertThat(solverPart1.rotate(0, "L101"), equalTo(99));
        MatcherAssert.assertThat(solverPart1.rotate(0, "L199"), equalTo(1));
        MatcherAssert.assertThat(solverPart1.rotate(0, "L299"), equalTo(1));
    }

    @Test
    void test_rotate_from_puzzle() {
        SolverPart1 solverPart1 = new SolverPart1();
        MatcherAssert.assertThat(solverPart1.rotate(50, "L68"), equalTo(82));
        MatcherAssert.assertThat(solverPart1.rotate(82, "L30"), equalTo(52));
        MatcherAssert.assertThat(solverPart1.rotate(52, "R48"), equalTo(0));
        MatcherAssert.assertThat(solverPart1.rotate(0, "L5"), equalTo(95));
        MatcherAssert.assertThat(solverPart1.rotate(95, "R60"), equalTo(55));
        MatcherAssert.assertThat(solverPart1.rotate(55, "L55"), equalTo(0));
        MatcherAssert.assertThat(solverPart1.rotate(0, "L1"), equalTo(99));
        MatcherAssert.assertThat(solverPart1.rotate(99, "L99"), equalTo(0));
        MatcherAssert.assertThat(solverPart1.rotate(0, "R14"), equalTo(14));
        MatcherAssert.assertThat(solverPart1.rotate(14, "L82"), equalTo(32));
    }

    @Test
    void test_solve_puzzle_a() {
        SolverPart1 solverPart1 = new SolverPart1();
        List<String> input = List.of("L68",
                "L30",
                "R48",
                "L5",
                "R60",
                "L55",
                "L1",
                "L99",
                "R14",
                "L82");

        MatcherAssert.assertThat(solverPart1.solvePuzzle(input), equalTo(3));
    }

}
