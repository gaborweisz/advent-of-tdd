package org.advent.day17;


import util.ListUtil;
import util.MatrixUtil;
import util.Pair;
import util.Pair2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}


public class PathFinder {

    static final double HEAT_WEIGHT = 1;
    static final double  POSITION_WEIGHT = 0.5;
    static final int LEVEL = 20;

    int[][] heatMap;
    int[][] weightedHeatMap;
    char[][] routeMap;
    Pair<Integer> destinationPos;

    Map<Direction, Direction> opposite = new HashMap<>();

    {
        opposite.put(Direction.UP, Direction.DOWN);
        opposite.put(Direction.DOWN, Direction.UP);
        opposite.put(Direction.LEFT, Direction.RIGHT);
        opposite.put(Direction.RIGHT, Direction.LEFT);
    }


    Map<Direction, Direction> next = new HashMap<>();

    {
        next.put(Direction.UP, Direction.RIGHT);
        next.put(Direction.LEFT, Direction.UP);
        next.put(Direction.DOWN, Direction.LEFT);
        next.put(Direction.RIGHT, Direction.DOWN);
    }


    PathFinder(List<String> rows) {
        heatMap = ListUtil.convertToIntArrayMatrix(rows);
        routeMap = new char[heatMap.length][heatMap[0].length];
        MatrixUtil.fillMatrix(routeMap, '.');
        destinationPos = new Pair<>(heatMap.length - 1, heatMap[0].length - 1);
        calculateWeightedHeatMap();

        System.out.println("Heat");
        MatrixUtil.printMatrix(heatMap);


        System.out.println("Weighted");
        MatrixUtil.printMatrix(weightedHeatMap);
    }

    void calculateWeightedHeatMap() {
        weightedHeatMap = new int[heatMap.length][heatMap[0].length];
        for (int i = 0; i < heatMap.length; i++) {
            for (int j = 0; j < heatMap[0].length; j++) {
                int distance = distance(i, j, destinationPos.getFirst(), destinationPos.getSecond());
                weightedHeatMap[i][j] = (int)(heatMap[i][j] * HEAT_WEIGHT) + (int)(distance * POSITION_WEIGHT);
            }
        }
    }

    int calculateTotalHeat() {
        int totalHeat = 0;
        for (int i = 0; i < heatMap.length; i++) {
            for (int j = 0; j < heatMap[0].length; j++) {
                if (routeMap[i][j] == '#') {
                    totalHeat += heatMap[i][j];
                }
            }
        }
        return totalHeat - heatMap[0][0];
    }

    void findPath() {
        int x = 0;
        int y = 0;
        Direction direction = Direction.RIGHT;
        Direction directionBefore = Direction.RIGHT;
        Direction forbiddenDirection = null;
        int stepsInTheSameDirection = 0;

        routeMap[x][y] = '#';

        while (true) {
            Pair2<Direction, Integer> bestRoute = findBestDirectionAndSteps(direction, forbiddenDirection, x, y, LEVEL);

            //System.out.println("Best route: " + bestRoute + " from " + x + "," + y);

            direction = bestRoute.getFirst();

            if (direction == directionBefore) {
                stepsInTheSameDirection++;
                if (stepsInTheSameDirection < 3) {
                    //System.out.println("Same direction " + direction + " taken " + stepsInTheSameDirection + " times");
                } else {
                    //System.out.println("This direction was taken too many times. Change direction.");
                    stepsInTheSameDirection = 0;
                    forbiddenDirection = direction;
                    continue;
                }
            } else {
                stepsInTheSameDirection = 0;
                directionBefore = direction;
                forbiddenDirection = null;
            }
            int steps = bestRoute.getSecond();
            //System.out.printf("Move %s %d steps\n", direction, steps);
            switch (direction) {
                case UP -> x -= steps;
                case DOWN -> x += steps;
                case LEFT -> y -= steps;
                case RIGHT -> y += steps;
            }

            routeMap[x][y] = '#';
            System.out.println("-------------------");
            MatrixUtil.printMatrix(routeMap);
            System.out.println("-------------------");

            if (destinationPos.getFirst() == x && destinationPos.getSecond() == y) {
                break;
            }
        }


        System.out.println("VVVVVVVVVVVVVVVV");
        MatrixUtil.printMatrix(routeMap);
        System.out.println("-------------------");



    }

    Pair2<Direction, Integer> findBestDirectionAndSteps(Direction currentDirection, Direction forbiddenDirection, int startX, int startY, int level) {
        int minHeat = Integer.MAX_VALUE;
        Pair2<Direction, Integer> bestRoute = null;

        for (Direction d : Direction.values()) {
            //System.out.println("Direction analysed :  " + d);
            if (d == opposite.get(currentDirection)) {
                //System.out.println("Skipping as opposit :" + d);
                continue;
            }
            if (d == forbiddenDirection) {
                //System.out.println("Skipping as forbidden :" + d);
                continue;
            }
            if (!isPossible(d, startX, startY, 1)) {
                //System.out.println("Skipping as not possible :" + d);
                continue;
            }
            int heat = move(d, startX, startY, 1, level);

            //System.out.println("Heat: " + heat + " for " + d);
            if (heat < minHeat) {
                minHeat = heat;
                bestRoute = new Pair2<>(d, 1);
            }

        }
        return bestRoute;
    }


    boolean isPossible(Direction direction, int i, int j, int step) {
        switch (direction) {
            case UP:
                if (i - step < 0) {
                    return false;
                }
                break;
            case DOWN:
                if (i + step >= weightedHeatMap.length) {
                    return false;
                }
                break;
            case LEFT:
                if (j - step < 0) {
                    return false;
                }
                break;
            case RIGHT:
                if (j + step >= weightedHeatMap[0].length) {
                    return false;
                }
                break;
        }
        return true;
    }

    int move(Direction direction, int i, int j, int stepsInTheSameDirection, int level) {

        int minHeatFromTheDirection = Integer.MAX_VALUE;
        int heatFromTheDirection;


        if (level == 0) {
            return weightedHeatMap[i][j];
        }


        switch (direction) {
            case UP -> {
                if (i - 1 < 0) {
                    return 10000;
                }
                i -= 1;
            }
            case DOWN -> {
                if (i + 1 >= weightedHeatMap.length) {
                    return 10000;
                }
                i += 1;
            }
            case LEFT -> {
                if (j - 1 < 0) {
                    return 10000;
                }
                j -= 1;
            }
            case RIGHT -> {
                if (j + 1 >= weightedHeatMap[0].length) {
                    return 10000;
                }
                j += 1;
            }
        }

        if (routeMap[i][j] == '#') {
            //already visited
            //System.out.println("Already visited " + i + "," + j);
            return 10000;
        }
        int heatOfThisPos = weightedHeatMap[i][j];

        if (stepsInTheSameDirection <= 3) {
            //can go straight only 3 steps


            // go forward
            heatFromTheDirection = switch (direction) {
                case UP -> move(Direction.UP, i, j, stepsInTheSameDirection + 1, level - 1);
                case DOWN -> move(Direction.DOWN, i, j, stepsInTheSameDirection + 1, level - 1);
                case LEFT -> move(Direction.LEFT, i, j, stepsInTheSameDirection + 1, level - 1);
                case RIGHT -> move(Direction.RIGHT, i, j, stepsInTheSameDirection + 1, level - 1);
            };


            if (heatFromTheDirection < minHeatFromTheDirection) {
                minHeatFromTheDirection = heatFromTheDirection;
            }
        }


        // turn right
        heatFromTheDirection = switch (direction) {
            case RIGHT -> move(Direction.DOWN, i, j, 1, level - 1);
            case DOWN -> move(Direction.LEFT, i, j, 1, level - 1);
            case LEFT -> move(Direction.UP, i, j, 1, level - 1);
            case UP -> move(Direction.RIGHT, i, j, 1, level - 1);
        };

        if (heatFromTheDirection < minHeatFromTheDirection) {
            minHeatFromTheDirection = heatFromTheDirection;
        }

        // turn left
        heatFromTheDirection = switch (direction) {
            case UP -> move(Direction.LEFT, i, j, 1, level - 1);
            case DOWN -> move(Direction.RIGHT, i, j, 1, level - 1);
            case LEFT -> move(Direction.DOWN, i, j, 1, level - 1);
            case RIGHT -> move(Direction.UP, i, j, 1, level - 1);
        };

        if (heatFromTheDirection < minHeatFromTheDirection) {
            minHeatFromTheDirection = heatFromTheDirection;
        }


        return minHeatFromTheDirection + heatOfThisPos;
    }

    int distance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow(Math.abs(x2 - x1),2) + Math.pow(Math.abs(y2 - y1),2));
    }

}
