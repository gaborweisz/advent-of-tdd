package org.advent2023.day16;

import java.util.List;
import java.util.Map;

public class LeftMirror implements Tile {

    Character id = '\\';
    boolean lit = false;

    Map<Direction, List<Direction>> directionMap = Map.of(
            Direction.NORTH, List.of(Direction.WEST),
            Direction.EAST, List.of(Direction.SOUTH),
            Direction.SOUTH, List.of(Direction.EAST),
            Direction.WEST, List.of(Direction.NORTH)
    );

    @Override
    public List<Direction> getOutDirections(Direction inboundDirection) {
        return directionMap.get(inboundDirection);
    }

    @Override
    public char getID() {
        return id;
    }

    @Override
    public boolean isLit() {
        return lit;
    }

    @Override
    public void lit() {
        this.lit = true;
    }
}
