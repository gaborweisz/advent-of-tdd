package org.advent2023.day2;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestGameShould {
    @Test
    void parse_a_row_and_create_a_game() {

        String input1 = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        Game game = Game.parse(input1);

        MatcherAssert.assertThat(game.gameSets.size(), equalTo(3));
        MatcherAssert.assertThat(game.id, equalTo(1));
        MatcherAssert.assertThat(game.gameSets.get(0).blue, equalTo(3));
        MatcherAssert.assertThat(game.gameSets.get(0).green, equalTo(0));
        MatcherAssert.assertThat(game.gameSets.get(0).red, equalTo(4));

        MatcherAssert.assertThat(game.gameSets.get(1).blue, equalTo(6));
        MatcherAssert.assertThat(game.gameSets.get(1).green, equalTo(2));
        MatcherAssert.assertThat(game.gameSets.get(1).red, equalTo(1));

        MatcherAssert.assertThat(game.gameSets.get(2).blue, equalTo(0));
        MatcherAssert.assertThat(game.gameSets.get(2).green, equalTo(2));
        MatcherAssert.assertThat(game.gameSets.get(2).red, equalTo(0));
    }

    @Test
    void return_true_if_game_is_possible() {

        String input1 = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        Game game = Game.parse(input1);

        MatcherAssert.assertThat(game.isGamePossible(4, 2, 6), equalTo(true));
    }

    @Test
    void return_true_if_game_is_not_possible() {

        String input1 = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        Game game = Game.parse(input1);

        MatcherAssert.assertThat(game.isGamePossible(4, 2, 5), equalTo(false));
    }

    @Test
    void calculate_the_number_of_cubes_needed() {

        String input1 = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        Game game = Game.parse(input1);
        game.calculateFewestCubesNeeded();

        MatcherAssert.assertThat(game.fewestRed, equalTo(4));
        MatcherAssert.assertThat(game.fewestGreen, equalTo(2));
        MatcherAssert.assertThat(game.fewestBlue, equalTo(6));
    }

    @Test
    void calculate_the_power_of_the_fewest_cubes_needed() {

        String input1 = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        Game game = Game.parse(input1);
        game.calculateFewestCubesNeeded();

        MatcherAssert.assertThat(game.powerOfTheFewestCubesNeeded(), equalTo(48));
    }

}
