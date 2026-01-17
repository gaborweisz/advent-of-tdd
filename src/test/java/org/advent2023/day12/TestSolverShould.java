package org.advent2023.day12;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestSolverShould {

    @Test
    void calculate_the_solution_for_puzzle_a() {

        List<String> input = List.of(
                "???.### 1,1,3,",
                ".??..??...?##. 1,1,3,",
                "?#?#?#?#?#?#?#? 1,3,1,6,",
                "????.#...#... 4,1,1,",
                "????.######..#####. 1,6,5,",
                "?###???????? 3,2,1");

        MatcherAssert.assertThat(Solver.solvePuzzleA(input), equalTo(21));

    }

}
