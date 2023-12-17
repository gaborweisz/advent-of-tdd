package org.advent.day16;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestSolverShould {

    @Test
    void calculate_the_solution_for_puzzle_a() {

        List<String> input = List.of(
                ".|...\\...." ,
                "|.-.\\....." ,
                ".....|-..." ,
                "........|." ,
                ".........." ,
                ".........\\" ,
                "..../.\\\\.." ,
                ".-.-/..|.." ,
                ".|....-|.\\" ,
                "..//.|....");

        MatcherAssert.assertThat(Solver.solvePuzzleA(input), equalTo(46));

    }

    @Test
    void calculate_the_solution_for_puzzle_b() {

        List<String> input = List.of(
                ".|...\\...." ,
                "|.-.\\....." ,
                ".....|-..." ,
                "........|." ,
                ".........." ,
                ".........\\" ,
                "..../.\\\\.." ,
                ".-.-/..|.." ,
                ".|....-|.\\" ,
                "..//.|....");

        MatcherAssert.assertThat(Solver.solvePuzzleB(input), equalTo(51));

    }



}
