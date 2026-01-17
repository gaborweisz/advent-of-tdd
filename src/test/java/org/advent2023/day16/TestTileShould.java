package org.advent2023.day16;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestTileShould {

    @Test
    void go_to_the_direction_in_case_of_empty_space() {

        //
        Tile emptySpace = new EmptySpace();

        MatcherAssert.assertThat(emptySpace.getOutDirections(Direction.NORTH), equalTo(List.of(Direction.NORTH)));
        MatcherAssert.assertThat(emptySpace.getOutDirections(Direction.EAST), equalTo(List.of(Direction.EAST)));
        MatcherAssert.assertThat(emptySpace.getOutDirections(Direction.SOUTH), equalTo(List.of(Direction.SOUTH)));
        MatcherAssert.assertThat(emptySpace.getOutDirections(Direction.WEST), equalTo(List.of(Direction.WEST)));
    }

    @Test
    void go_to_the_direction_in_case_of_left_mirror() {

        // \
        Tile mirror = new LeftMirror();

        MatcherAssert.assertThat(mirror.getOutDirections(Direction.NORTH), equalTo(List.of(Direction.WEST)));
        MatcherAssert.assertThat(mirror.getOutDirections(Direction.EAST), equalTo(List.of(Direction.SOUTH)));
        MatcherAssert.assertThat(mirror.getOutDirections(Direction.SOUTH), equalTo(List.of(Direction.EAST)));
        MatcherAssert.assertThat(mirror.getOutDirections(Direction.WEST), equalTo(List.of(Direction.NORTH)));


    }

    @Test
    void go_to_the_direction_in_case_of_right_mirror() {

        // /
        Tile mirror = new RightMirror();

        MatcherAssert.assertThat(mirror.getOutDirections(Direction.NORTH), equalTo(List.of(Direction.EAST)));
        MatcherAssert.assertThat(mirror.getOutDirections(Direction.EAST), equalTo(List.of(Direction.NORTH)));
        MatcherAssert.assertThat(mirror.getOutDirections(Direction.SOUTH), equalTo(List.of(Direction.WEST)));
        MatcherAssert.assertThat(mirror.getOutDirections(Direction.WEST), equalTo(List.of(Direction.SOUTH)));
    }

    @Test
    void go_to_the_direction_in_case_of_horizontal_splitter() {

        // -
        Tile mirror = new HorizontalSplitter();

        MatcherAssert.assertThat(mirror.getOutDirections(Direction.NORTH), equalTo(List.of(Direction.EAST, Direction.WEST)));
        MatcherAssert.assertThat(mirror.getOutDirections(Direction.EAST), equalTo(List.of(Direction.EAST)));
        MatcherAssert.assertThat(mirror.getOutDirections(Direction.SOUTH), equalTo(List.of(Direction.EAST, Direction.WEST)));
        MatcherAssert.assertThat(mirror.getOutDirections(Direction.WEST), equalTo(List.of(Direction.WEST)));
    }

    @Test
    void go_to_the_direction_in_case_of_vertical_splitter() {

        // |
        Tile mirror = new VerticalSplitter();

        MatcherAssert.assertThat(mirror.getOutDirections(Direction.NORTH), equalTo(List.of(Direction.NORTH)));
        MatcherAssert.assertThat(mirror.getOutDirections(Direction.EAST), equalTo(List.of(Direction.NORTH, Direction.SOUTH)));
        MatcherAssert.assertThat(mirror.getOutDirections(Direction.SOUTH), equalTo(List.of(Direction.SOUTH)));
        MatcherAssert.assertThat(mirror.getOutDirections(Direction.WEST), equalTo(List.of(Direction.NORTH, Direction.SOUTH)));
    }
}
