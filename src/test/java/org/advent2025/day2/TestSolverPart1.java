package org.advent2025.day2;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestSolverPart1 {


    @Test
    void test_solve_puzzle_a() {
        org.advent2025.day2.SolverPart1 solverPart1 = new SolverPart1();
        String ranges = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124";

        MatcherAssert.assertThat(solverPart1.solvePuzzle(ranges), equalTo(1227775554L));
    }

    @Test
    void test_get_ranges() {
        org.advent2025.day2.SolverPart1 solverPart1 = new SolverPart1();
        String rangesStr = "11-22,95-115,998-1012";

        List<Range> ranges = SolverUtil.getRanges(rangesStr);

        MatcherAssert.assertThat(ranges.size(), equalTo(3));
        MatcherAssert.assertThat(ranges.get(0).start, equalTo(11L));
        MatcherAssert.assertThat(ranges.get(0).end, equalTo(22L));
        MatcherAssert.assertThat(ranges.get(1).start, equalTo(95L));
        MatcherAssert.assertThat(ranges.get(1).end, equalTo(115L));
        MatcherAssert.assertThat(ranges.get(2).start, equalTo(998L));
        MatcherAssert.assertThat(ranges.get(2).end, equalTo(1012L));
    }

    @Test
    void test_isIdValid() {
        org.advent2025.day2.SolverPart1 solverPart1 = new SolverPart1();

        // invalid IDs
        MatcherAssert.assertThat(solverPart1.isIdValid(55L), equalTo(false));
        MatcherAssert.assertThat(solverPart1.isIdValid(6464L), equalTo(false));
        MatcherAssert.assertThat(solverPart1.isIdValid(123123L), equalTo(false));

        // valid IDs
        MatcherAssert.assertThat(solverPart1.isIdValid(5L), equalTo(true));
        MatcherAssert.assertThat(solverPart1.isIdValid(101L), equalTo(true));
        MatcherAssert.assertThat(solverPart1.isIdValid(123124L), equalTo(true));
    }
}
