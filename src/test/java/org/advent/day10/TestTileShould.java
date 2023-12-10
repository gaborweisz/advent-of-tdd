package org.advent.day10;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class TestTileShould {

    Map<Direction, Direction> direction_up_down = new HashMap<>();
    {
        direction_up_down.put(Direction.UP, Direction.UP);
        direction_up_down.put(Direction.DOWN, Direction.DOWN);
    }

    Map <Direction, Direction> direction_left_right = new HashMap<>();
    {
        direction_left_right.put(Direction.LEFT, Direction.LEFT);
        direction_left_right.put(Direction.RIGHT, Direction.RIGHT);
    }

    Map <Direction, Direction> direction_up_right = new HashMap<>();
    {
        direction_up_right.put(Direction.LEFT, Direction.UP);
        direction_up_right.put(Direction.DOWN, Direction.RIGHT);
    }

    Map <Direction, Direction> direction_up_left = new HashMap<>();
    {
        direction_up_left.put(Direction.RIGHT, Direction.UP);
        direction_up_left.put(Direction.DOWN, Direction.LEFT);
    }

    Map <Direction, Direction> direction_down_right = new HashMap<>();
    {
        direction_down_right.put(Direction.LEFT, Direction.DOWN);
        direction_down_right.put(Direction.UP, Direction.RIGHT);
    }

    Map <Direction, Direction> direction_down_left = new HashMap<>();
    {
        direction_down_left.put(Direction.RIGHT, Direction.DOWN);
        direction_down_left.put(Direction.UP, Direction.LEFT);
    }

    @Test
    void calculate_the_position_based_on_direction_up_and_down_pipe() {
        Tile tile = new Tile('|', Direction.UP, -1, 0, Direction.DOWN, 1, 0, direction_up_down); // up and down pipe

        MatcherAssert.assertThat(tile.getI(Direction.UP, 1, 1), equalTo(0));
        MatcherAssert.assertThat(tile.getJ(Direction.UP, 1, 1), equalTo(1));

        MatcherAssert.assertThat(tile.getI(Direction.DOWN, 1, 1), equalTo(2));
        MatcherAssert.assertThat(tile.getJ(Direction.DOWN, 1, 1), equalTo(1));

        MatcherAssert.assertThat(tile.getNextDirection(Direction.UP, 1, 1), equalTo(Direction.UP));
        MatcherAssert.assertThat(tile.getNextDirection(Direction.DOWN, 1, 1), equalTo(Direction.DOWN));
    }

    @Test
    void calculate_the_position_based_on_direction_left_and_right_pipe() {
        Tile tile = new Tile('-', Direction.LEFT, 0, -1, Direction.RIGHT, 0, 1,direction_left_right); // left and right pipe

        MatcherAssert.assertThat(tile.getI(Direction.LEFT, 1, 1), equalTo(1));
        MatcherAssert.assertThat(tile.getJ(Direction.LEFT, 1, 1), equalTo(0));

        MatcherAssert.assertThat(tile.getI(Direction.RIGHT, 1, 1), equalTo(1));
        MatcherAssert.assertThat(tile.getJ(Direction.RIGHT, 1, 1), equalTo(2));

        MatcherAssert.assertThat(tile.getNextDirection(Direction.LEFT, 1, 1), equalTo(Direction.LEFT));
        MatcherAssert.assertThat(tile.getNextDirection(Direction.RIGHT, 1, 1), equalTo(Direction.RIGHT));
    }

    @Test
    void calculate_the_position_based_on_direction_up_and_right_pipe() {

        Tile tile = new Tile('L', Direction.UP, -1, 0, Direction.RIGHT, 0, 1,direction_up_right); // up and right pipe

        MatcherAssert.assertThat(tile.getI(Direction.UP, 1, 1), equalTo(0));
        MatcherAssert.assertThat(tile.getJ(Direction.UP, 1, 1), equalTo(1));

        MatcherAssert.assertThat(tile.getI(Direction.RIGHT, 1, 1), equalTo(1));
        MatcherAssert.assertThat(tile.getJ(Direction.RIGHT, 1, 1), equalTo(2));

        MatcherAssert.assertThat(tile.getNextDirection(Direction.LEFT, 1, 1), equalTo(Direction.UP));
        MatcherAssert.assertThat(tile.getNextDirection(Direction.DOWN, 1, 1), equalTo(Direction.RIGHT));
    }

    @Test
    void calculate_the_position_based_on_direction_up_and_left_pipe() {
        Tile tile = new Tile('J', Direction.UP, -1, 0, Direction.LEFT, 0, -1,direction_up_left); // up and left pipe

        MatcherAssert.assertThat(tile.getI(Direction.UP, 1, 1), equalTo(0));
        MatcherAssert.assertThat(tile.getJ(Direction.UP, 1, 1), equalTo(1));

        MatcherAssert.assertThat(tile.getI(Direction.LEFT, 1, 1), equalTo(1));
        MatcherAssert.assertThat(tile.getJ(Direction.LEFT, 1, 1), equalTo(0));

        MatcherAssert.assertThat(tile.getNextDirection(Direction.RIGHT, 1, 1), equalTo(Direction.UP));
        MatcherAssert.assertThat(tile.getNextDirection(Direction.DOWN, 1, 1), equalTo(Direction.LEFT));

    }

    @Test
    void calculate_the_position_based_on_direction_down_and_right_pipe() {
        Tile tile = new Tile('F', Direction.DOWN, 1, 0, Direction.RIGHT, 0, 1,direction_down_right); // down and right pipe

        MatcherAssert.assertThat(tile.getI(Direction.DOWN, 1, 1), equalTo(2));
        MatcherAssert.assertThat(tile.getJ(Direction.DOWN, 1, 1), equalTo(1));

        MatcherAssert.assertThat(tile.getI(Direction.RIGHT, 1, 1), equalTo(1));
        MatcherAssert.assertThat(tile.getJ(Direction.RIGHT, 1, 1), equalTo(2));

        MatcherAssert.assertThat(tile.getNextDirection(Direction.UP, 1, 1), equalTo(Direction.RIGHT));
        MatcherAssert.assertThat(tile.getNextDirection(Direction.LEFT, 1, 1), equalTo(Direction.DOWN));

    }

    @Test
    void calculate_the_position_based_on_direction_down_and_left_pipe() {
        Tile tile = new Tile('7', Direction.DOWN, 1, 0, Direction.RIGHT, 0, -1, direction_down_left); // down and left pipe

        MatcherAssert.assertThat(tile.getI(Direction.DOWN, 1, 1), equalTo(2));
        MatcherAssert.assertThat(tile.getJ(Direction.DOWN, 1, 1), equalTo(1));

        MatcherAssert.assertThat(tile.getI(Direction.RIGHT, 1, 1), equalTo(1));
        MatcherAssert.assertThat(tile.getJ(Direction.RIGHT, 1, 1), equalTo(0));

        MatcherAssert.assertThat(tile.getNextDirection(Direction.RIGHT, 1, 1), equalTo(Direction.DOWN));
        MatcherAssert.assertThat(tile.getNextDirection(Direction.UP, 1, 1), equalTo(Direction.LEFT));

    }

    @Test
    void throw_exception_if_direction_is_incorrect() {
        Tile tile = new Tile('7', Direction.DOWN, 1, 0, Direction.RIGHT, 0, -1, direction_down_right); // down and left pipe

        try {
            tile.getI(Direction.UP, 1, 1);
        } catch (RuntimeException e) {
            MatcherAssert.assertThat(e.getMessage(), equalTo("Unknown direction: UP"));
        }
    }


}
