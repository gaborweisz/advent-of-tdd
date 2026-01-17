package org.advent2025.day1;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestSolverPart2 {


    @Test
    void test_rotate_right() {
        SolverPart2 solverPart2 = new SolverPart2();
        MatcherAssert.assertThat(solverPart2.rotate(0, "R1").newValue, equalTo(1));
        MatcherAssert.assertThat(solverPart2.rotate(0, "R99").newValue, equalTo(99));
        MatcherAssert.assertThat(solverPart2.rotate(0, "R100").newValue, equalTo(0));
        MatcherAssert.assertThat(solverPart2.rotate(0, "R101").newValue, equalTo(1));
        MatcherAssert.assertThat(solverPart2.rotate(0, "R199").newValue, equalTo(99));
        MatcherAssert.assertThat(solverPart2.rotate(0, "R299").newValue, equalTo(99));
    }

    @Test
    void test_rotate_left() {
        SolverPart2 solverPart2 = new SolverPart2();
        MatcherAssert.assertThat(solverPart2.rotate(0, "L1").newValue, equalTo(99));
        MatcherAssert.assertThat(solverPart2.rotate(0, "L99").newValue, equalTo(1));
        MatcherAssert.assertThat(solverPart2.rotate(0, "L100").newValue, equalTo(0));
        MatcherAssert.assertThat(solverPart2.rotate(0, "L101").newValue, equalTo(99));
        MatcherAssert.assertThat(solverPart2.rotate(0, "L199").newValue, equalTo(1));
        MatcherAssert.assertThat(solverPart2.rotate(0, "L299").newValue, equalTo(1));
    }

    @Test
    void test_rotate_from_puzzle_new_value() {
        SolverPart2 solverPart2 = new SolverPart2();
        MatcherAssert.assertThat(solverPart2.rotate(50, "L68").newValue, equalTo(82));
        MatcherAssert.assertThat(solverPart2.rotate(82, "L30").newValue, equalTo(52));
        MatcherAssert.assertThat(solverPart2.rotate(52, "R48").newValue, equalTo(0));
        MatcherAssert.assertThat(solverPart2.rotate(0, "L5").newValue, equalTo(95));
        MatcherAssert.assertThat(solverPart2.rotate(95, "R60").newValue, equalTo(55));
        MatcherAssert.assertThat(solverPart2.rotate(55, "L55").newValue, equalTo(0));
        MatcherAssert.assertThat(solverPart2.rotate(0, "L1").newValue, equalTo(99));
        MatcherAssert.assertThat(solverPart2.rotate(99, "L99").newValue, equalTo(0));
        MatcherAssert.assertThat(solverPart2.rotate(0, "R14").newValue, equalTo(14));
        MatcherAssert.assertThat(solverPart2.rotate(14, "L82").newValue, equalTo(32));
    }

    @Test
    void test_rotate_from_puzzle_hitZero() {
        SolverPart2 solverPart2 = new SolverPart2();
        MatcherAssert.assertThat(solverPart2.rotate(50, "L68").hitZero, equalTo(1));
        MatcherAssert.assertThat(solverPart2.rotate(82, "L30").hitZero, equalTo(0));
        MatcherAssert.assertThat(solverPart2.rotate(52, "R48").hitZero, equalTo(0));
        MatcherAssert.assertThat(solverPart2.rotate(0, "L5").hitZero, equalTo(0));
        MatcherAssert.assertThat(solverPart2.rotate(95, "R60").hitZero, equalTo(1));
        MatcherAssert.assertThat(solverPart2.rotate(55, "L55").hitZero, equalTo(0));
        MatcherAssert.assertThat(solverPart2.rotate(0, "L1").hitZero, equalTo(0));
        MatcherAssert.assertThat(solverPart2.rotate(99, "L99").hitZero, equalTo(0));
        MatcherAssert.assertThat(solverPart2.rotate(0, "R14").hitZero, equalTo(0));
        MatcherAssert.assertThat(solverPart2.rotate(14, "L82").hitZero, equalTo(1));
    }

    @Test
    void test_solve_puzzle_b() {
        SolverPart2 solverPart2 = new SolverPart2();
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

        MatcherAssert.assertThat(solverPart2.solvePuzzle(input), equalTo(6));
    }

}
