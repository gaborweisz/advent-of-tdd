package org.advent.day2;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestGameSetShould {

    @Test
    void parse_a_game_and_create_game_set() {

        String input1 = " 3 blue, 4 red";
        String input2 = " 1 red, 2 green, 6 blue";
        String input3 = " 2 green";

        GameSet gameSet1 = GameSet.parse(input1);

        MatcherAssert.assertThat(gameSet1.red, equalTo(4));
        MatcherAssert.assertThat(gameSet1.green, equalTo(0));
        MatcherAssert.assertThat(gameSet1.blue, equalTo(3));

        GameSet gameSet2 = GameSet.parse(input2);

        MatcherAssert.assertThat(gameSet2.red, equalTo(1));
        MatcherAssert.assertThat(gameSet2.green, equalTo(2));
        MatcherAssert.assertThat(gameSet2.blue, equalTo(6));

        GameSet gameSet3 = GameSet.parse(input3);

        MatcherAssert.assertThat(gameSet3.red, equalTo(0));
        MatcherAssert.assertThat(gameSet3.green, equalTo(2));
        MatcherAssert.assertThat(gameSet3.blue, equalTo(0));
    }
}
