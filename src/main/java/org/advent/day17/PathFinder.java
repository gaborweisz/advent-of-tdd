package org.advent.day17;


import util.ListUtil;

import java.util.List;

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

public class PathFinder {

    char[][] heatMap;

    public PathFinder(List<String> rows) {
        heatMap = ListUtil.convertToCharArrayMatrix(rows);
    }

    void findPath() {
        int x = 0;
        int y = 0;
        Direction direction = Direction.RIGHT;


    }

    int move(Direction direction, int i, int j, int level) {

        int sumHeat = 0;

        if (level == 0) {
            return heatMap[i][j];
        }
        switch (direction) {
            case UP:
                if (i==0) {
                    return heatMap[i][j];
                }
                i--;
                break;
            case DOWN:
                if (j==heatMap.length-1) {
                    return heatMap[i][j];
                }
                i++;
                break;
            case LEFT:
                if (j==0) {
                    return heatMap[i][j];
                }
                j--;
                break;
            case RIGHT:
                if (j==heatMap[0].length-1) {
                    return heatMap[i][j];
                }
                j++;
                break;
        }


        // turn right
        switch (direction) {
            case UP:
                sumHeat += move(Direction.RIGHT, i, j, level-1);
                break;
            case DOWN:
                sumHeat += move(Direction.LEFT, i, j, level-1);
                break;
            case LEFT:
                sumHeat += move(Direction.UP, i, j, level-1);
                break;
            case RIGHT:
                move(Direction.DOWN,i, j, level-1);
                break;
        }

        // turn left
        switch (direction) {
            case UP:
                move(Direction.LEFT, i, j, level-1);
                break;
            case DOWN:
                move(Direction.RIGHT, i, j, level-1);
                break;
            case LEFT:
                move(Direction.DOWN, i, j, level-1);
                break;
            case RIGHT:
                move(Direction.UP, i, j, level-1);
                break;
        }

        // go forward
        switch (direction) {
            case UP:
                move(Direction.UP, i, j, level-1);
                break;
            case DOWN:
                move(Direction.DOWN, i, j, level-1);
                break;
            case LEFT:
                move(Direction.LEFT, i, j, level-1);
                break;
            case RIGHT:
                move(Direction.RIGHT, i, j, level-1);
                break;
        }
        return sumHeat;
    }

}
