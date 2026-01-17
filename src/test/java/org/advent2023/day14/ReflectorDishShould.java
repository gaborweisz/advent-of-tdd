package org.advent2023.day14;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import util.ListUtil;
import util.MatrixUtil;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class ReflectorDishShould {


    @Test
    void spin_the_dish_1() {

        List<String> input = List.of(
                "O....#...." ,
                "O.OO#....#" ,
                ".....##..." ,
                "OO.#O....O" ,
                ".O.....O#." ,
                "O.#..O.#.#" ,
                "..O..#O..O" ,
                ".......O.." ,
                "#....###.." ,
                "#OO..#....");

        List<String> expectedResult = List.of(
                ".....#...." ,
                "....#...O#" ,
                "...OO##..." ,
                ".OO#......" ,
                ".....OOO#." ,
                ".O#...O#.#" ,
                "....O#...." ,
                "......OOOO" ,
                "#...O###.." ,
                "#..OO#....");


        char[][] result = ReflectorDish.spin(ListUtil.convertToCharArrayMatrix(input), 1);

        MatcherAssert.assertThat(MatrixUtil.areEqual(result, ListUtil.convertToCharArrayMatrix(expectedResult)), equalTo(true));

    }

    @Test
    void spin_the_dish_2() {

        List<String> input = List.of(
                "O....#...." ,
                "O.OO#....#" ,
                ".....##..." ,
                "OO.#O....O" ,
                ".O.....O#." ,
                "O.#..O.#.#" ,
                "..O..#O..O" ,
                ".......O.." ,
                "#....###.." ,
                "#OO..#....");

        List<String> expectedResult = List.of(
                ".....#...." ,
                "....#...O#" ,
                ".....##..." ,
                "..O#......" ,
                ".....OOO#." ,
                ".O#...O#.#" ,
                "....O#...O" ,
                ".......OOO" ,
                "#..OO###.." ,
                "#.OOO#...O");


        char[][] result = ReflectorDish.spin(ListUtil.convertToCharArrayMatrix(input), 2);

        MatcherAssert.assertThat(MatrixUtil.areEqual(result, ListUtil.convertToCharArrayMatrix(expectedResult)), equalTo(true));

    }


    @Test
    void spin_the_dish_3() {

        List<String> input = List.of(
                "O....#...." ,
                "O.OO#....#" ,
                ".....##..." ,
                "OO.#O....O" ,
                ".O.....O#." ,
                "O.#..O.#.#" ,
                "..O..#O..O" ,
                ".......O.." ,
                "#....###.." ,
                "#OO..#....");

        List<String> expectedResult = List.of(
                ".....#...." ,
                "....#...O#" ,
                ".....##..." ,
                "..O#......" ,
                ".....OOO#." ,
                ".O#...O#.#" ,
                "....O#...O" ,
                ".......OOO" ,
                "#...O###.O" ,
                "#.OOO#...O");


        char[][] result = ReflectorDish.spin(ListUtil.convertToCharArrayMatrix(input), 3);

        MatcherAssert.assertThat(MatrixUtil.areEqual(result, ListUtil.convertToCharArrayMatrix(expectedResult)), equalTo(true));

    }


    @Test
    void spin_the_dish_1000000000() {

        List<String> input = List.of(
                "O....#...." ,
                "O.OO#....#" ,
                ".....##..." ,
                "OO.#O....O" ,
                ".O.....O#." ,
                "O.#..O.#.#" ,
                "..O..#O..O" ,
                ".......O.." ,
                "#....###.." ,
                "#OO..#....");




        char[][] result = ReflectorDish.effectiveSpin(ListUtil.convertToCharArrayMatrix(input), 1000000000);

        MatcherAssert.assertThat(ReflectorDish.calculateLoad(result), equalTo(64.0));

    }


    @Test
    void calculate_the_load() {

        List<String> input = List.of(
                "O....#...." ,
                "O.OO#....#" ,
                ".....##..." ,
                "OO.#O....O" ,
                ".O.....O#." ,
                "O.#..O.#.#" ,
                "..O..#O..O" ,
                ".......O.." ,
                "#....###.." ,
                "#OO..#....");


        char[][] tiltedMatrix = MatrixUtil.tiltNorth(ListUtil.convertToCharArrayMatrix(input));

        MatcherAssert.assertThat(ReflectorDish.calculateLoad(tiltedMatrix), equalTo(136.0));

    }

}
