package org.advent2023.day7;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestSolverShould {

    @Test
    void calculate_the_solution_for_puzzle_a() {

        List<String> input = List.of(
                "32T3K 765",
                "T55J5 684",
                "KK677 28",
                "KTJJT 220",
                "QQQJA 483");

        MatcherAssert.assertThat(Solver.solvePuzzleA(input), equalTo(6440.0));
    }

    @Test
    void calculate_the_solution_for_puzzle_b() {

        List<String> input = List.of(
                "32T3K 765",
                "T55J5 684",
                "KK677 28",
                "KTJJT 220",
                "QQQJA 483");

        MatcherAssert.assertThat(Solver.solvePuzzleB(input), equalTo(5905.0));
    }
}
