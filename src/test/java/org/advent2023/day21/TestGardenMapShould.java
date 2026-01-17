package org.advent2023.day21;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import util.ListUtil;
import util.MatrixUtil;
import util.Pair;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestGardenMapShould {

    @Test
    void find_the_start_position() {

        List<String> input = List.of(
                "...........",
                ".....###.#.",
                ".###.##..#.",
                "..#.#...#..",
                "....#.#....",
                ".##..S####.",
                ".##..#...#.",
                ".......##..",
                ".##.#.####.",
                ".##..##.##.",
                "...........");

        GardenMap map = new GardenMap(input);
        Pair<Integer> start = map.findStart();

        MatcherAssert.assertThat(start.getFirst(), equalTo(5));
        MatcherAssert.assertThat(start.getSecond(), equalTo(5));

    }


    @Test
    void find_the_the_reachable_position() {

        List<String> input = List.of(
                "...........",
                ".....###.#.",
                ".###.##..#.",
                "..#.#...#..",
                "....#.#....",
                ".##..S####.",
                ".##..#...#.",
                ".......##..",
                ".##.#.####.",
                ".##..##.##.",
                "...........");

        List<String> expected_1 = List.of(
                "...........",
                ".....###.#.",
                ".###.##..#.",
                "..#.#...#..",
                "....#O#....",
                ".##.O.####.",
                ".##..#...#.",
                ".......##..",
                ".##.#.####.",
                ".##..##.##.",
                "...........");

        List<String> expected_2 = List.of(
                "...........",
                ".....###.#.",
                ".###.##..#.",
                "..#.#O..#..",
                "....#.#....",
                ".##O.O####.",
                ".##.O#...#.",
                ".......##..",
                ".##.#.####.",
                ".##..##.##.",
                "...........");

        List<String> expected_3 = List.of(
                "...........",
                ".....###.#.",
                ".###.##..#.",
                "..#.#.O.#..",
                "...O#O#....",
                ".##.O.####.",
                ".##O.#...#.",
                "....O..##..",
                ".##.#.####.",
                ".##..##.##.",
                "...........");

        List<String> expected_6 = List.of(
                "...........",
                ".....###.#.",
                ".###.##.O#.",
                ".O#O#O.O#..",
                "O.O.#.#.O..",
                ".##O.O####.",
                ".##.O#O..#.",
                ".O.O.O.##..",
                ".##.#.####.",
                ".##O.##.##.",
                "...........");

        GardenMap map = new GardenMap(input);

        char[][] expected1 = ListUtil.convertToCharArrayMatrix(expected_1);
        char[][] expected2 = ListUtil.convertToCharArrayMatrix(expected_2);
        char[][] expected3 = ListUtil.convertToCharArrayMatrix(expected_3);
        char[][] expected6 = ListUtil.convertToCharArrayMatrix(expected_6);

        char[][] reachable1 = map.findReachablePlots(map.map);
        char[][] reachable2 = map.findReachablePlots(reachable1);
        char[][] reachable3 = map.findReachablePlots(reachable2);
        char[][] reachable4 = map.findReachablePlots(reachable3);
        char[][] reachable5 = map.findReachablePlots(reachable4);
        char[][] reachable6 = map.findReachablePlots(reachable5);

        System.out.println("======================");
        MatrixUtil.printMatrix(reachable1);
        System.out.println("======================");
        MatrixUtil.printMatrix(reachable2);
        System.out.println("======================");
        MatrixUtil.printMatrix(reachable3);
        System.out.println("======================");
        MatrixUtil.printMatrix(reachable4);
        System.out.println("======================");
        MatrixUtil.printMatrix(reachable5);
        System.out.println("======================");
        MatrixUtil.printMatrix(reachable6);

        MatcherAssert.assertThat(MatrixUtil.areEqual(reachable1, expected1), equalTo(true));
        MatcherAssert.assertThat(MatrixUtil.areEqual(reachable2, expected2), equalTo(true));
        MatcherAssert.assertThat(MatrixUtil.areEqual(reachable3, expected3), equalTo(true));
        MatcherAssert.assertThat(MatrixUtil.areEqual(reachable6, expected6), equalTo(true));

    }
}
