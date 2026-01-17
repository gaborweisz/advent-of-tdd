package org.advent2023.day15;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestSolverShould {

    @Test
    void calculate_the_solution_for_puzzle_a() {

        String input = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7";

        MatcherAssert.assertThat(Solver.solvePuzzleA(input), equalTo(1320));

    }

    @Test
    void calculate_the_solution_for_puzzle_b() {

        String input = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7";

        MatcherAssert.assertThat(Solver.solvePuzzleB(input), equalTo(145));

    }



}
