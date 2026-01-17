package org.advent2023.day10;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestSolverPart1Should {

    @Test
    void calculate_the_solution_for_puzzle_a_case_1() {

        List<String> input = List.of(
                ".....",
                ".S-7.",
                ".|.|.",
                ".L-J.",
                ".....");

        MatcherAssert.assertThat(Solver.solvePuzzleA(input), equalTo(4.0));

    }

    @Test
    void calculate_the_solution_for_puzzle_a_case_2() {

        List<String> input = List.of(
                "..F7.",
                ".FJ|.",
                "SJ.L7",
                "|F--J",
                "LJ...");

        MatcherAssert.assertThat(Solver.solvePuzzleA(input), equalTo(8.0));

    }

    @Test
    void calculate_the_solution_for_puzzle_b_case_1() {

        List<String> input = List.of(
                "...........",
                ".S-------7.",
                ".|F-----7|.",
                ".||.....||.",
                ".||.....||.",
                ".|L-7.F-J|.",
                ".|..|.|..|.",
                ".L--J.L--J.",
                "...........");

        MatcherAssert.assertThat(Solver.solvePuzzleB(input), equalTo(4.0));
    }

    @Test
    void calculate_the_solution_for_puzzle_b_case_2() {

        List<String> input = List.of(
                "..........",
                ".S------7.",
                ".|F----7|.",
                ".||....||.",
                ".||....||.",
                ".|L-7F-J|.",
                ".|..||..|.",
                ".L--JL--J.",
                "....... ..");

        MatcherAssert.assertThat(Solver.solvePuzzleB(input), equalTo(4.0));
    }

    @Test
    void calculate_the_solution_for_puzzle_b_case_3() {

        List<String> input = List.of(
                ".F----7F7F7F7F-7....",
                ".|F--7||||||||FJ....",
                ".||.FJ||||||||L7....",
                "FJL7L7LJLJ||LJ.L-7..",
                "L--J.L7...LJS7F-7L7.",
                "....F-J..F7FJ|L7L7L7",
                "....L7.F7||L7|.L7L7|",
                ".....|FJLJ|FJ|F7|.LJ",
                "....FJL-7.||.||||...",
                "....L---J.LJ.LJLJ...");


        MatcherAssert.assertThat(Solver.solvePuzzleB(input), equalTo(8.0));
    }

    @Test
    void calculate_the_solution_for_puzzle_b_case_4() {

        List<String> input = List.of(
                "FF7FSF7F7F7F7F7F---7",
                "L|LJ||||||||||||F--J",
                "FL-7LJLJ||||||LJL-77",
                "F--JF--7||LJLJ7F7FJ-",
                "L---JF-JLJ.||-FJLJJ7",
                "|F|F-JF---7F7-L7L|7|",
                "|FFJF7L7F-JF7|JL---7",
                "7-L-JL7||F7|L7F-7F7|",
                "L.L7LFJ|||||FJL7||LJ",
                "L7JLJL-JLJLJL--JLJ.L");


        MatcherAssert.assertThat(Solver.solvePuzzleB(input), equalTo(10.0));
    }
}
