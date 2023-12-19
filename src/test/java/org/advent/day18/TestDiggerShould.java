package org.advent.day18;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import util.ListUtil;
import util.MatrixUtil;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestDiggerShould {

    @Test
    void parse_the_dig_plan() {

        List<String> input = List.of(
                "R 6 (#70c710)",
                "D 5 (#0dc571)",
                "L 2 (#5713f0)",
                "D 2 (#d2c081)",
                "R 2 (#59c680)",
                "D 2 (#411b91)",
                "L 5 (#8ceee2)",
                "U 2 (#caa173)",
                "L 1 (#1b58a2)",
                "U 2 (#caa171)",
                "R 2 (#7807d2)",
                "U 3 (#a77fa3)",
                "L 2 (#015232)",
                "U 2 (#7a21e3)");

        Digger digger = new Digger(input, 10, 10);

        MatcherAssert.assertThat(digger.steps.size(), equalTo(14));
        MatcherAssert.assertThat(digger.steps.get(0).direction, equalTo('R'));
        MatcherAssert.assertThat(digger.steps.get(0).steps, equalTo(6));
        MatcherAssert.assertThat(digger.steps.get(0).rgb, equalTo("#70c710"));
        MatcherAssert.assertThat(digger.steps.get(13).direction, equalTo('U'));
        MatcherAssert.assertThat(digger.steps.get(13).steps, equalTo(2));
        MatcherAssert.assertThat(digger.steps.get(13).rgb, equalTo("#7a21e3"));

    }


    @Test
    void execute_the_dig_plan() {

        List<String> input = List.of(
                "R 6 (#70c710)",
                "D 5 (#0dc571)",
                "L 2 (#5713f0)",
                "D 2 (#d2c081)",
                "R 2 (#59c680)",
                "D 2 (#411b91)",
                "L 5 (#8ceee2)",
                "U 2 (#caa173)",
                "L 1 (#1b58a2)",
                "U 2 (#caa171)",
                "R 2 (#7807d2)",
                "U 3 (#a77fa3)",
                "L 2 (#015232)",
                "U 2 (#7a21e3)");

        List<String> expectedResult = List.of(
                "#######",
                "#.....#",
                "###...#",
                "..#...#",
                "..#...#",
                "###.###",
                "#...#..",
                "##..###",
                ".#....#",
                ".######");

        Digger digger = new Digger(input, 10, 7);
        digger.digPerimeter(0,0);
        char[][] result = MatrixUtil.cutMatrix(digger.field, 0, 0, 9, 6);
        char[][] expected = ListUtil.convertToCharArrayMatrix(expectedResult);
        MatrixUtil.printMatrix(result);
        System.out.println("**************");
        MatrixUtil.printMatrix(expected);

        MatcherAssert.assertThat(MatrixUtil.areEqual(result, expected), equalTo(true));
    }

    @Test
    void dig_all() {

        List<String> input = List.of(
                "R 6 (#70c710)",
                "D 5 (#0dc571)",
                "L 2 (#5713f0)",
                "D 2 (#d2c081)",
                "R 2 (#59c680)",
                "D 2 (#411b91)",
                "L 5 (#8ceee2)",
                "U 2 (#caa173)",
                "L 1 (#1b58a2)",
                "U 2 (#caa171)",
                "R 2 (#7807d2)",
                "U 3 (#a77fa3)",
                "L 2 (#015232)",
                "U 2 (#7a21e3)");

        List<String> expectedResult = List.of(
                "#######",
                "#######",
                "#######",
                "..#####",
                "..#####",
                "#######",
                "#####..",
                "#######",
                ".######",
                ".######");

        Digger digger = new Digger(input, 10, 7);
        digger.digPerimeter(0,0);
        digger.digAll(4,4);
        char[][] result = MatrixUtil.cutMatrix(digger.field, 0, 0, 9, 6);
        char[][] expected = ListUtil.convertToCharArrayMatrix(expectedResult);
        MatrixUtil.printMatrix(result);

        MatcherAssert.assertThat(MatrixUtil.areEqual(result, expected), equalTo(true));
    }

    @Test
    void dig_calculate_size() {

        List<String> input = List.of(
                "R 6 (#70c710)",
                "D 5 (#0dc571)",
                "L 2 (#5713f0)",
                "D 2 (#d2c081)",
                "R 2 (#59c680)",
                "D 2 (#411b91)",
                "L 5 (#8ceee2)",
                "U 2 (#caa173)",
                "L 1 (#1b58a2)",
                "U 2 (#caa171)",
                "R 2 (#7807d2)",
                "U 3 (#a77fa3)",
                "L 2 (#015232)",
                "U 2 (#7a21e3)");



        Digger digger = new Digger(input, 50, 50);


        MatcherAssert.assertThat(digger.calculateTrenchCapacity(), equalTo(62));
    }
}
