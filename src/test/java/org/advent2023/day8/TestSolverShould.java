package org.advent2023.day8;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestSolverShould {

    @Test
    void calculate_the_solution_for_puzzle_a() {

        List<String> input1 = List.of(
                "RL",
                "",
                "AAA = (BBB, CCC)",
                "BBB = (DDD, EEE)",
                "CCC = (ZZZ, GGG)",
                "DDD = (DDD, DDD)",
                "EEE = (EEE, EEE)",
                "GGG = (GGG, GGG)",
                "ZZZ = (ZZZ, ZZZ)");

        List<String> input2 = List.of(
                "LLR",
                "",
                "AAA = (BBB, BBB)",
                "BBB = (AAA, ZZZ)",
                "ZZZ = (ZZZ, ZZZ)");

        MatcherAssert.assertThat(Solver.solvePuzzleA(input1), equalTo(2.0));
        MatcherAssert.assertThat(Solver.solvePuzzleA(input2), equalTo(6.0));
    }

    @Test
    void calculate_the_solution_for_puzzle_b() {

        List<String> input = List.of(
                "LR",
                "",
                "11A = (11B, XXX)",
                "11B = (XXX, 11Z)",
                "11Z = (11B, XXX)",
                "22A = (22B, XXX)",
                "22B = (22C, 22C)",
                "22C = (22Z, 22Z)",
                "22Z = (22B, 22B)",
                "XXX = (XXX, XXX)");

        MatcherAssert.assertThat(Solver.solvePuzzleB(input), equalTo(6.0));
    }
}
