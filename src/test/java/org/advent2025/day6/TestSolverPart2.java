package org.advent2025.day6;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import util.MatrixUtil;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestSolverPart2 {


    /**
     * Given teh following input :
     * 123 328  51 64
     *  45 64  387 23
     *   6 98  215 314
     * *   +   *   +
     *
     * The solutions should be 3263827
     */

    @Test
    void test_solvePuzzle() {
        SolverPart2 solverPart2 = new SolverPart2();

        List<String> input = List.of(
            "123 328  51 64 " ,
            " 45 64  387 23 " ,
            "  6 98  215 314" ,
            "*   +   *   +  "
        );

        MatcherAssert.assertThat(solverPart2.solvePuzzle(input), equalTo(3263827L));
    }

    void test_parseNumberFromMatrixColumn() {
        SolverPart2 solverPart2 = new SolverPart2();

        List<String> input = List.of(
            "123 328  51 64 " ,
            " 45 64  387 23 " ,
            "  6 98  215 314" ,
            "*   +   *   +  "
        );

        char[][] numbers = MatrixUtil.convertStringListToMatrix(input);

        MatcherAssert.assertThat(solverPart2.parseNumberFromMatrixColumn(numbers, 14), equalTo(4));
        MatcherAssert.assertThat(solverPart2.parseNumberFromMatrixColumn(numbers, 13), equalTo(431));
        MatcherAssert.assertThat(solverPart2.parseNumberFromMatrixColumn(numbers, 12), equalTo(623));

        MatcherAssert.assertThat(solverPart2.parseNumberFromMatrixColumn(numbers, 11), equalTo(-1));
        MatcherAssert.assertThat(solverPart2.parseNumberFromMatrixColumn(numbers, 10), equalTo(175));
        MatcherAssert.assertThat(solverPart2.parseNumberFromMatrixColumn(numbers, 9), equalTo(581));
        MatcherAssert.assertThat(solverPart2.parseNumberFromMatrixColumn(numbers, 8), equalTo(32));

    }
}
