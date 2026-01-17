package org.advent2023.day16;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestMirrorFieldShould {

    @Test
    void parse_the_input() {

        List<String> input = List.of(
                ".|...\\...." ,
                "|.-.\\....." ,
                ".....|-..." ,
                "........|." ,
                ".........." ,
                ".........\\" ,
                "..../.\\\\.." ,
                ".-.-/..|.." ,
                ".|....-|.\\" ,
                "..//.|....");

        MirrorField mirrorField = new MirrorField(input);

        MatcherAssert.assertThat(mirrorField.field.length, equalTo(10));
        MatcherAssert.assertThat(mirrorField.field[0].length, equalTo(10));
        MatcherAssert.assertThat(mirrorField.getTile(0, 0).getID(), equalTo(new EmptySpace().getID()));
        MatcherAssert.assertThat(mirrorField.getTile(0, 1).getID(), equalTo(new VerticalSplitter().getID()));
        MatcherAssert.assertThat(mirrorField.getTile(0, 2).getID(), equalTo(new EmptySpace().getID()));
        MatcherAssert.assertThat(mirrorField.getTile(0, 3).getID(), equalTo(new EmptySpace().getID()));
        MatcherAssert.assertThat(mirrorField.getTile(0, 4).getID(), equalTo(new EmptySpace().getID()));
        MatcherAssert.assertThat(mirrorField.getTile(0, 5).getID(), equalTo(new LeftMirror().getID()));

    }
}
