package org.advent2025.day2;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestSolverPart2 {

    /**
     * From the same example as before:
     * <p>
     * 11-22 still has two invalid IDs, 11 and 22.
     * 95-115 now has two invalid IDs, 99 and 111.
     * 998-1012 now has two invalid IDs, 999 and 1010.
     * 1188511880-1188511890 still has one invalid ID, 1188511885.
     * 222220-222224 still has one invalid ID, 222222.
     * 1698522-1698528 still contains no invalid IDs.
     * 446443-446449 still has one invalid ID, 446446.
     * 38593856-38593862 still has one invalid ID, 38593859.
     * 565653-565659 now has one invalid ID, 565656.
     * 824824821-824824827 now has one invalid ID, 824824824.
     * 2121212118-2121212124 now has one invalid ID, 2121212121.
     * Adding up all the invalid IDs in this example produces 4174379265.
     */
    @Test
    void test_isValid() {
        SolverPart2 solverPart2 = new SolverPart2();

        MatcherAssert.assertThat(solverPart2.isIdValid(11L), equalTo(false));
        MatcherAssert.assertThat(solverPart2.isIdValid(22L), equalTo(false));
        MatcherAssert.assertThat(solverPart2.isIdValid(99L), equalTo(false));
        MatcherAssert.assertThat(solverPart2.isIdValid(111L), equalTo(false));
        MatcherAssert.assertThat(solverPart2.isIdValid(999L), equalTo(false));
        MatcherAssert.assertThat(solverPart2.isIdValid(1010L), equalTo(false));
        MatcherAssert.assertThat(solverPart2.isIdValid(1188511885L), equalTo(false));
        MatcherAssert.assertThat(solverPart2.isIdValid(222222L), equalTo(false));
        MatcherAssert.assertThat(solverPart2.isIdValid(446446L), equalTo(false));
        MatcherAssert.assertThat(solverPart2.isIdValid(38593859L), equalTo(false));
        MatcherAssert.assertThat(solverPart2.isIdValid(565656L), equalTo(false));
        MatcherAssert.assertThat(solverPart2.isIdValid(824824824L), equalTo(false));
        MatcherAssert.assertThat(solverPart2.isIdValid(2121212121L), equalTo(false));
    }

    @Test
    void test_solve_puzzle_b() {
        SolverPart2 solverPart2 = new SolverPart2();
        String ranges = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124";

        MatcherAssert.assertThat(solverPart2.solvePuzzle(ranges), equalTo(4174379265L));
    }

}
