package org.advent.day10;

import java.util.Map;

public class Tile {

    char pipeType;

    Direction direction1; //current direction
    Direction direction2; //other possible direction
    Map<Direction, Direction> directionMap; // map of current direction to the next direction (i.e. turn of teh pipe

    int di1; // delta i - move in direction1
    int dj1; // delta j - move in direction1
    int di2; // delta i - move in direction2
    int dj2; // delta j - move in direction2



    public Tile(char pipeType, Direction direction1, int di1, int dj1, Direction direction2, int di2, int dj2, Map<Direction, Direction> directionMap){
        this.pipeType = pipeType;
        this.direction1 = direction1;
        this.direction2 = direction2;
        this.directionMap = directionMap;
        this.di1 = di1;
        this.dj1 = dj1;
        this.di2 = di2;
        this.dj2 = dj2;
    }

    int getI(Direction direction, int i, int j) {
        if (direction == direction1) {
            return i + di1;
        } else if (direction == direction2) {
            return i + di2;
        } else {
            throw new RuntimeException("Unknown direction: " + direction);
        }
    }

    int getJ(Direction direction, int i, int j) {
        if (direction == direction1) {
            return j + dj1;
        } else if (direction == direction2) {
            return j + dj2;
        } else {
            throw new RuntimeException("Unknown direction: " + direction);
        }
    }

    Direction getNextDirection(Direction direction, int i, int j) {
        return directionMap.get(direction);
    }
}
