package org.advent2023.day16;

import java.util.List;

public interface Tile {

    List<Direction> getOutDirections(Direction inboundDirection);

    char getID();

    boolean isLit();

    void lit();
}
