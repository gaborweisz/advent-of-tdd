package org.advent.day3;

import org.advent.day3.Solver;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestSolverShould {

    @Test
    void calculate_the_solution_for_puzzle_a() {

        List<String> input = List.of(
                "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598..");

        MatcherAssert.assertThat(Solver.solvePuzzleA(input), equalTo(4361));
    }

    @Test
    void calculate_the_solution_for_puzzle_b() {

        List<String> input = List.of(
                "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598..");

        MatcherAssert.assertThat(Solver.solvePuzzleB(input), equalTo(467835));
    }
}
