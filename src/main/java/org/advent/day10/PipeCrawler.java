package org.advent.day10;

import util.ListUtil;

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


    List<Character> bottomborder =  List.of('-', '7', 'F');
    List<Character> topborder = List.of('-', 'J', 'L');
    List<Character> leftborder = List.of('|', 'J');
    List<Character> rightborder = List.of('|', 'F');

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
    int posI;
    int posJ;
    Direction direction;

    public PipeCrawler(List<String> lines) {
        pipeMap = ListUtil.convertToCharArrayMatrix(lines);
        initPipeOnlyMap();
        findStartPosition();
    }

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

    void initPipeOnlyMap() {
        pipeOnlyMap = new char[pipeMap.length][pipeMap[0].length];
        for (int i = 0; i < pipeMap.length; i++) {
            for (int j = 0; j < pipeMap[i].length; j++) {
                pipeOnlyMap[i][j] = '.';
            }
        }
    }

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

    public double crawlTillTheEndAndMarkEnclosedArea() {
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

            markIfEnclosed(posI, posJ, direction);
            this.posI = currentTile.getI(direction, posI, posJ);
            this.posJ = currentTile.getJ(direction, posI, posJ);

            previousDirection = direction;
        }
    }

    public void markIfEnclosed(int i, int j, Direction direction) {

        if (pipeMap[i][j] == '7' && direction == Direction.DOWN && pipeOnlyMap[i+1][j-1] == '.') {
            pipeOnlyMap[i+1][j-1] = 'I';
        }

        if (pipeMap[i][j] == 'J' && direction == Direction.LEFT && pipeOnlyMap[i-1][j-1] == '.') {
            pipeOnlyMap[i-1][j-1] = 'I';
        }

        if (pipeMap[i][j] == 'L' && direction == Direction.UP && pipeOnlyMap[i-1][j+1] == '.') {
            pipeOnlyMap[i-1][j+1] = 'I';
        }

        if (pipeMap[i][j] == 'F' && direction == Direction.RIGHT && pipeOnlyMap[i+1][j+1] == '.')  {
            pipeOnlyMap[i+1][j+1] = 'I';
        }
    }

    /**
     * @return true if the tile is enclosed by pipes
     */
    public double countEnclosedArea() {

        excludeDisclosedAreaFromTheEdges();
        findEnclosedAreas();
        return countEnclosed();
    }

    private void findEnclosedAreas() {
        for (int i = 0; i < pipeOnlyMap.length; i++) {
            for (int j = 0; j < pipeOnlyMap[i].length; j++) {
                if (pipeOnlyMap[i][j] == 'I') {
                    markEnclosedArea(i, j);
                }
            }
        }
    }

    private void excludeDisclosedAreaFromTheEdges() {
        for (int i = 0; i < pipeOnlyMap.length; i++) {
            markDisclosedStatus(i, 0);
            markDisclosedStatus(i, pipeOnlyMap[i].length-1);
        }

        for (int j = 0; j < pipeOnlyMap[0].length; j++) {
            markDisclosedStatus(0, j);
            markDisclosedStatus(pipeOnlyMap.length - 1, j);
        }
    }

    public void markDisclosedStatus(int i, int j) {
        if (i < 0 || i >= pipeOnlyMap.length || j < 0 || j >= pipeOnlyMap[i].length) {
            return;
        }
        if (pipeOnlyMap[i][j] == '.' || pipeOnlyMap[i][j] == 'I' ) {
            if (disclosed(i, j)) {
                pipeOnlyMap[i][j] = 'O';
            } else {
                pipeOnlyMap[i][j] = '.';
            }
            markDisclosedStatus(i - 1, j);
            markDisclosedStatus(i + 1, j);
            markDisclosedStatus(i, j - 1);
            markDisclosedStatus(i, j + 1);
        }
    }

    void markEnclosedArea(int i, int j) {
        if (i < 0 || i >= pipeOnlyMap.length || j < 0 || j >= pipeOnlyMap[i].length) {
            return;
        }
        if (pipeOnlyMap[i][j] == 'I' || pipeOnlyMap[i][j] == '.') {
            pipeOnlyMap[i][j] = 'E';
            markEnclosedArea(i - 1, j);
            markEnclosedArea(i + 1, j);
            markEnclosedArea(i, j - 1);
            markEnclosedArea(i, j + 1);
        }
    }

    public boolean disclosed(int i, int j) {

        if (i == 0 || i == pipeOnlyMap.length - 1 || j == 0 || j == pipeOnlyMap[i].length - 1) {
            // if we are on the edge of the map, we are not enclosed
            return true;
        }

        if (pipeOnlyMap[i - 1][j] == 'O' || pipeOnlyMap[i + 1][j] == 'O' || pipeOnlyMap[i][j -1 ] == 'O' || pipeOnlyMap[i][j + 1] == 'O') {
            // if we are next to a not enclosed tile, we are not enclosed
            return true;
        }

        return false;

    }

    public double countEnclosed() {
        double counter = 0;
        for (char[] chars : pipeOnlyMap) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == 'E') {
                    counter++;
                }
            }
        }
        return counter;
    }

    void printMap() {
        for (char[] chars : pipeOnlyMap) {
            for (int j = 0; j < chars.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

}

