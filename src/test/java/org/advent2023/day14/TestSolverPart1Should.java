package org.advent2023.day14;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestSolverPart1Should {

    @Test
    void calculate_the_solution_for_puzzle_a() {

        List<String> input = List.of(
                "O....#...." ,
                "O.OO#....#" ,
                ".....##..." ,
                "OO.#O....O" ,
                ".O.....O#." ,
                "O.#..O.#.#" ,
                "..O..#O..O" ,
                ".......O.." ,
                "#....###.." ,
                "#OO..#....");

        MatcherAssert.assertThat(Solver.solvePuzzleA(input), equalTo(136.0));

    }

    @Test
    void calculate_the_solution_for_puzzle_b() {

        List<String> input = List.of(
                "O....#...." ,
                "O.OO#....#" ,
                ".....##..." ,
                "OO.#O....O" ,
                ".O.....O#." ,
                "O.#..O.#.#" ,
                "..O..#O..O" ,
                ".......O.." ,
                "#....###.." ,
                "#OO..#....");

        MatcherAssert.assertThat(Solver.solvePuzzleB(input), equalTo(64.0));

    }



}
