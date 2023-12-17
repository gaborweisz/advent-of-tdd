package org.advent.day16;

import java.util.List;

public interface Tile {

    List<Direction> getOutDirections(Direction inboundDirection);

    char getID();

    boolean isLit();

    void lit();
}
