package org.advent.day16;

import java.util.List;
import java.util.Map;

public class HorizontalSplitter implements Tile {

    Character id = '-';
    boolean lit = false;

    Map<Direction, List<Direction>> directionMap = Map.of(
            Direction.NORTH, List.of(Direction.EAST, Direction.WEST),
            Direction.EAST, List.of(Direction.EAST),
            Direction.SOUTH, List.of(Direction.EAST, Direction.WEST),
            Direction.WEST, List.of(Direction.WEST)
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
