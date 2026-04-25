package org.advent2025.day10;


import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestSolverPart1 {


    /**
     * [.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}
     * [...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}
     * [.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}
     */

    @Test
    void test_solvePuzzle() {
        org.advent2025.day10.SolverPart1 solverPart1 = new SolverPart1();

        List<String> input = List.of(
                "[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7} " ,
                   "[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}" ,
                   "[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}"
        );

        MatcherAssert.assertThat(solverPart1.solvePuzzle(input), equalTo(7));
    }
    
    @Test
    void test_convertToBitmap() {
        org.advent2025.day10.SolverPart1 solverPart1 = new SolverPart1();

        MatcherAssert.assertThat(solverPart1.convertToBitmap("[.##.]"), equalTo(6));
        MatcherAssert.assertThat(solverPart1.convertToBitmap("[...#.]"), equalTo(8));
        MatcherAssert.assertThat(solverPart1.convertToBitmap("[.###.#]"), equalTo(0b101110));
        MatcherAssert.assertThat(solverPart1.convertToBitmap("[#..######.]"), equalTo(0b0111111001));
    }
    
    @Test
    void tets_convertButtonToBitmap() {
        org.advent2025.day10.SolverPart1 solverPart1 = new SolverPart1();

        MatcherAssert.assertThat(solverPart1.convertButtonToBitmap(List.of(3)), equalTo(0b0001000));
        MatcherAssert.assertThat(solverPart1.convertButtonToBitmap(List.of(1,3)), equalTo(0b0001010));
        MatcherAssert.assertThat(solverPart1.convertButtonToBitmap(List.of(0,2)), equalTo(0b000101));
        MatcherAssert.assertThat(solverPart1.convertButtonToBitmap(List.of(0,1,2)), equalTo(0b000111));
        MatcherAssert.assertThat(solverPart1.convertButtonToBitmap(List.of(0,1,2,3,4)), equalTo(0b011111)); 
    }
    
    @Test
    void test_processInput() {
        org.advent2025.day10.SolverPart1 solverPart1 = new SolverPart1();

        List<String> input = List.of(
                 "[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7} " , 
                "[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}",
                "[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}"
        );

        List<SolverPart1.Indicator> indicators = solverPart1.processInput(input);
        MatcherAssert.assertThat(indicators.size(), equalTo(3));
        MatcherAssert.assertThat(indicators.get(0).lights, equalTo(0b0110));
        MatcherAssert.assertThat(indicators.get(1).lights, equalTo(0b01000));
        MatcherAssert.assertThat(indicators.get(2).lights, equalTo(0b101110));
        
        MatcherAssert.assertThat(indicators.get(0).buttons.size(), equalTo(6));
        MatcherAssert.assertThat(indicators.get(0).buttons.get(0), equalTo(3));
        MatcherAssert.assertThat(indicators.get(0).buttons.get(1), equalTo(5));
        MatcherAssert.assertThat(indicators.get(0).buttons.get(2), equalTo(12));
        MatcherAssert.assertThat(indicators.get(0).buttons.get(3), equalTo(4));
        MatcherAssert.assertThat(indicators.get(0).buttons.get(4), equalTo(10));
        MatcherAssert.assertThat(indicators.get(0).buttons.get(5), equalTo(8));
        
    }
    
    @Test
    void test_getIndexes() {
        
        MatcherAssert.assertThat(new org.advent2025.day10.SolverPart1().getIndexes(0b011101), equalTo(List.of(0,2,3,4)));
        MatcherAssert.assertThat(new org.advent2025.day10.SolverPart1().getIndexes(0b001111110), equalTo(List.of(1,2,3,4,5, 6)));
        MatcherAssert.assertThat(new org.advent2025.day10.SolverPart1().getIndexes(0b000000), equalTo(List.of()));
        MatcherAssert.assertThat(new org.advent2025.day10.SolverPart1().getIndexes(0b111111), equalTo(List.of(0,1,2,3,4,5)));
        MatcherAssert.assertThat(new org.advent2025.day10.SolverPart1().getIndexes(6), equalTo(List.of(1,2)));
    }
}
