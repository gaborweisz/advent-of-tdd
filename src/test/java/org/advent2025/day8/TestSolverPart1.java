package org.advent2025.day8;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestSolverPart1 {


    /**
     * Given teh following input :
     * 162,817,812
     * 57,618,57
     * 906,360,560
     * 592,479,940
     * 352,342,300
     * 466,668,158
     * 542,29,236
     * 431,825,988
     * 739,650,466
     * 52,470,668
     * 216,146,977
     * 819,987,18
     * 117,168,530
     * 805,96,715
     * 346,949,466
     * 970,615,88
     * 941,993,340
     * 862,61,35
     * 984,92,344
     * 425,690,689
     * The solutions should be 50
     */

    @Test
    void test_solvePuzzle() {
        SolverPart1 solverPart1 = new SolverPart1();

        List<String> input = List.of(
                "162,817,812",
                "57,618,57",
                "906,360,560",
                "592,479,940",
                "352,342,300",
                "466,668,158",
                "542,29,236",
                "431,825,988",
                "739,650,466",
                "52,470,668",
                "216,146,977",
                "819,987,18",
                "117,168,530",
                "805,96,715",
                "346,949,466",
                "970,615,88",
                "941,993,340",
                "862,61,35",
                "984,92,344",
                "425,690,689"
        );

        MatcherAssert.assertThat(solverPart1.solvePuzzle(input, 10), equalTo(40.0));
    }
}
