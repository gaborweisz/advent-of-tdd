package org.advent2023.day10;

import util.ListUtil;
import util.MatrixUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PipeCrawler {

    /**
     * Represents the pipes and the relative movement in i and j direction for each pipe assuming we go clockwise
     * <p>
     * | is a vertical pipe connecting north and south.
     * - is a horizontal pipe connecting east and west.
     * L is a 90-degree bend connecting north and east.
     * J is a 90-degree bend connecting north and west.
     * 7 is a 90-degree bend connecting south and west.
     * F is a 90-degree bend connecting south and east.
     * . is ground; there is no pipe in this tile.
     * S is the starting position of the animal; there is a pipe on this tile, but your sketch doesn't show what shape the pipe has.
     * <p>
     * ".....",
     * ".S-7.",
     * ".|.|.",
     * ".L-J.",
     * "....."
     */

    Map<Direction, Direction> direction_up_down = new HashMap<>();

    {
        direction_up_down.put(Direction.UP, Direction.UP);
        direction_up_down.put(Direction.DOWN, Direction.DOWN);
    }

    Map<Direction, Direction> direction_left_right = new HashMap<>();

    {
        direction_left_right.put(Direction.LEFT, Direction.LEFT);
        direction_left_right.put(Direction.RIGHT, Direction.RIGHT);
    }

    Map<Direction, Direction> direction_up_right = new HashMap<>();

    {
        direction_up_right.put(Direction.LEFT, Direction.UP);
        direction_up_right.put(Direction.DOWN, Direction.RIGHT);
    }

    Map<Direction, Direction> direction_up_left = new HashMap<>();

    {
        direction_up_left.put(Direction.RIGHT, Direction.UP);
        direction_up_left.put(Direction.DOWN, Direction.LEFT);
    }

    Map<Direction, Direction> direction_down_right = new HashMap<>();

    {
        direction_down_right.put(Direction.LEFT, Direction.DOWN);
        direction_down_right.put(Direction.UP, Direction.RIGHT);
    }

    Map<Direction, Direction> direction_down_left = new HashMap<>();

    {
        direction_down_left.put(Direction.RIGHT, Direction.DOWN);
        direction_down_left.put(Direction.UP, Direction.LEFT);
    }


    List<Character> connect_down = List.of('7', 'F', 'S');
    List<Character> connect_up = List.of('J', 'L', 'S');
    List<Character> connect_left = List.of('7', 'J', 'S');
    List<Character> connect_right = List.of('L', 'F', 'S');

    Map<Character, Tile> tileMap = new HashMap<>();

    {
        tileMap.put('S', new Tile('S', Direction.NONE, 0, 0, Direction.NONE, 0, 0, null));  // start position
        tileMap.put('|', new Tile('|', Direction.UP, -1, 0, Direction.DOWN, 1, 0, direction_up_down)); // up and down pipe
        tileMap.put('-', new Tile('-', Direction.LEFT, 0, -1, Direction.RIGHT, 0, 1, direction_left_right)); // left and right pipe
        tileMap.put('L', new Tile('L', Direction.UP, -1, 0, Direction.RIGHT, 0, 1, direction_up_right)); // up and right pipe
        tileMap.put('J', new Tile('J', Direction.UP, -1, 0, Direction.LEFT, 0, -1, direction_up_left)); // up and left pipe
        tileMap.put('F', new Tile('F', Direction.DOWN, 1, 0, Direction.RIGHT, 0, 1, direction_down_right)); // down and right pipe
        tileMap.put('7', new Tile('7', Direction.DOWN, 1, 0, Direction.LEFT, 0, -1, direction_down_left)); // down and left pipe

    }

    char[][] pipeMap;
    char[][] pipeOnlyMap; // map that only contains the pipes
    char[][] doublePileOnlyMap; // map that only contains the pipes
    int posI;
    int posJ;
    Direction direction;

    public PipeCrawler(List<String> lines) {
        pipeMap = ListUtil.convertToCharArrayMatrix(lines);
        initPipeOnlyMap();
        findStartPosition();
    }

    /**
     * Find the start position and set the direction
     */
    public void findStartPosition() {
        for (int i = 0; i < pipeMap.length; i++) {
            for (int j = 0; j < pipeMap[i].length; j++) {
                if (pipeMap[i][j] == 'S') {

                    if (i > 0 && (pipeMap[i - 1][j] == '7' || pipeMap[i - 1][j] == '|')) {
                        posI = i - 1; // start with the tile above the start position
                        posJ = j;
                        direction = Direction.UP;
                    } else if (j < pipeMap[i].length - 1 && (pipeMap[i][j + 1] == '-' || pipeMap[i][j + 1] == 'J' || pipeMap[i][j + 1] == '7')) {
                        posI = i; // start with the tile right from the start position
                        posJ = j + 1;
                        direction = Direction.RIGHT;
                    } else if (i < pipeMap.length - 1 && (pipeMap[i + 1][j] == 'L' || pipeMap[i + 1][j] == '|')) {
                        posI = i + 1; // start with the tile below the start position
                        posJ = j;
                        direction = Direction.DOWN;
                    } else if (j > 0 && (pipeMap[i][j - 1] == '-' || pipeMap[i][j - 1] == 'L' || pipeMap[i][j - 1] == 'F')) {
                        posI = i; // start with the tile left from the start position
                        posJ = j - 1;
                        direction = Direction.LEFT;
                    } else {
                        throw new RuntimeException("Could not find start position");
                    }
                    return;
                }
            }
        }
    }

    /**
     * Initializes the pipe only map with dots
     */
    void initPipeOnlyMap() {
        pipeOnlyMap = new char[pipeMap.length][pipeMap[0].length];
        for (int i = 0; i < pipeMap.length; i++) {
            for (int j = 0; j < pipeMap[i].length; j++) {
                pipeOnlyMap[i][j] = '.';
            }
        }
    }

    /**
     * Crawls the pipe till the end and returns the number of steps
     *
     * @return number of steps (solution a)
     */
    public double crawlTillTheEnd() {
        Direction previousDirection = direction;
        double counter = 0;

        while (true) {
            Tile currentTile = tileMap.get(pipeMap[posI][posJ]);
            if (currentTile.pipeType == 'S') {
                //we need the farthest point from start position
                pipeOnlyMap[posI][posJ] = pipeMap[posI][posJ];
                return counter % 2 == 0 ? counter / 2 : (counter + 1) / 2;
            }
            counter++;
            pipeOnlyMap[posI][posJ] = pipeMap[posI][posJ];
            direction = currentTile.getNextDirection(previousDirection, posI, posJ);
            this.posI = currentTile.getI(direction, posI, posJ);
            this.posJ = currentTile.getJ(direction, posI, posJ);

            previousDirection = direction;
        }
    }


    /**
     * Creates a double sized map that will allow us to fill the gaps between the pipes
     */
    public void doublePileOnlyMap() {
        doublePileOnlyMap = MatrixUtil.doubleMatrix(pipeOnlyMap);

        //fill the gaps with pipes
        for (int i = 0; i < doublePileOnlyMap.length ; i++) {
            for (int j = 0; j < doublePileOnlyMap[i].length; j++) {
                if (doublePileOnlyMap[i][j] == '|') {
                    if (i > 0 && doublePileOnlyMap[i - 1][j] == '.') {
                        doublePileOnlyMap[i - 1][j] = '|';
                    }
                    if (i < doublePileOnlyMap.length - 1 && doublePileOnlyMap[i + 1][j] == '.') {
                        doublePileOnlyMap[i + 1][j] = '|';
                    }

                }
                if (doublePileOnlyMap[i][j] == '-') {

                    if (j > 0 && doublePileOnlyMap[i][j - 1] == '.') {
                        doublePileOnlyMap[i][j - 1] = '-';
                    }
                    if (j < doublePileOnlyMap[i].length - 1 && doublePileOnlyMap[i][j + 1] == '.') {
                        doublePileOnlyMap[i][j + 1] = '-';
                    }
                }
                if (connect_up.contains(doublePileOnlyMap[i][j])) {
                    //F 7 < -- connect down
                    //| | < -- insert the pipe up
                    //L J < -- connect up
                    if (i > 2 && doublePileOnlyMap[i - 1][j] == '.' && connect_down.contains(doublePileOnlyMap[i - 2][j])) {
                        doublePileOnlyMap[i - 1][j] = '|';
                    }
                }
                if (connect_down.contains(doublePileOnlyMap[i][j])) {
                    //F 7 < -- connect down
                    //| | < -- insert the pipe dow
                    //L J < -- connect up
                    if (i < doublePileOnlyMap.length -2  && doublePileOnlyMap[i + 1][j] == '.' && connect_up.contains(doublePileOnlyMap[i + 2][j])) {
                        doublePileOnlyMap[i + 1][j] = '|';
                    }
                }
                if (connect_left.contains(doublePileOnlyMap[i][j])) {
                    //connect right   connect left
                    //F      -        7 < -- adds pipe to the left
                    //L      -        J
                    if (j > 2 && doublePileOnlyMap[i][j-1] == '.' && connect_right.contains(doublePileOnlyMap[i][j-2])) {
                        doublePileOnlyMap[i][j - 1] = '-';
                    }
                }
                if (connect_right.contains(doublePileOnlyMap[i][j])) {
                    //connect right   connect left
                    //F      -        7 < -- adds pipe to the right
                    //L      -        J
                    if (j < doublePileOnlyMap[i].length -2  && doublePileOnlyMap[i][j+1] == '.' && connect_left.contains(doublePileOnlyMap[i][j+2])) {
                        doublePileOnlyMap[i][j + 1] = '-';
                    }
                }


            }
        }

        MatrixUtil.printMatrix(doublePileOnlyMap);
    }

    /**
     * @return true if the tile is enclosed by pipes
     */
    public double countEnclosedArea() {

        excludeDisclosedAreaFromTheEdges();
        findTheOriginalGaps();
        return countEnclosed();
    }

    /**
     * Finds the enclosed area from the original (not duplicated) map
     */
    private void findTheOriginalGaps() {
        for (int i = 0; i < doublePileOnlyMap.length; i+=2) {
            for (int j = 0; j < doublePileOnlyMap[i].length; j+=2) {
                if (doublePileOnlyMap[i][j] == '.') {
                    doublePileOnlyMap[i][j] = 'X';
                }
            }
        }
    }


    /**
     * Goes through the edges of the map and starts marking the disclosed areas
     */
    private void excludeDisclosedAreaFromTheEdges() {
        for (int i = 0; i < doublePileOnlyMap.length; i++) {
            markDisclosedStatus(i, 0);
            markDisclosedStatus(i, doublePileOnlyMap[i].length - 1);
        }

        for (int j = 0; j < doublePileOnlyMap[0].length; j++) {
            markDisclosedStatus(0, j);
            markDisclosedStatus(doublePileOnlyMap.length - 1, j);
        }
    }

    /**
     * Recursively marks the disclosed areas
     */
    public void markDisclosedStatus(int i, int j) {
        if (i < 0 || i >= doublePileOnlyMap.length || j < 0 || j >= doublePileOnlyMap[i].length) {
            return;
        }
        if (doublePileOnlyMap[i][j] == '.' || doublePileOnlyMap[i][j] == 'I') {
            if (disclosed(i, j)) {
                doublePileOnlyMap[i][j] = 'O';
            } else {
                doublePileOnlyMap[i][j] = '.';
            }
            markDisclosedStatus(i, j - 1);
            markDisclosedStatus(i - 1, j);
            markDisclosedStatus(i, j + 1);
            markDisclosedStatus(i + 1, j);
        }
    }


    /**
     * @return true if the tile is not enclosed by pipes
     */
    public boolean disclosed(int i, int j) {

        if (i == 0 || i == doublePileOnlyMap.length - 1 || j == 0 || j == doublePileOnlyMap[i].length - 1) {
            // if we are on the edge of the map, we are not enclosed
            return true;
        }

        if (doublePileOnlyMap[i - 1][j] == 'O' || doublePileOnlyMap[i + 1][j] == 'O' || doublePileOnlyMap[i][j - 1] == 'O' || doublePileOnlyMap[i][j + 1] == 'O') {
            // if we are next to a not enclosed tile, we are not enclosed
            return true;
        }

        return false;

    }

    /**
     * @return the number of enclosed tiles
     */
    public double countEnclosed() {
        double counter = 0;
        for (char[] chars : doublePileOnlyMap) {
            for (char aChar : chars) {
                if (aChar == 'X') {
                    counter++;
                }
            }
        }
        return counter ;
    }

    /**
     * Prints the map
     */
    void printMap() {
        for (char[] chars : doublePileOnlyMap) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

}

