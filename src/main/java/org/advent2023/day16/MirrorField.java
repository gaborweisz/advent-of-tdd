package org.advent2023.day16;

import util.ListUtil;

import java.util.List;

public class MirrorField {

    Tile[][] field;

    public MirrorField(List<String> input) {
        parseInput(input);
    }

    /**
     * Counts the number of energized tiles starting from given position and direction
     * @param startI start position
     * @param startJ start position
     * @param inboundDirection  direction to start
     * @return number of energized tiles
     */
    public int countEnergized(int startI, int startJ, Direction inboundDirection) {
        walkThrough(startI,startJ, inboundDirection);
        int count = 0;
        for (Tile[] tiles : field) {
            for (Tile t : tiles) {
                if (t.isLit()) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Finds the maximum number of energized tiles by trying all possible starting positions from the edges
     * @param input input of the puzzle
     * @return maximum number of energized tiles possible
     */
    public int findMaximumEnergy(List<String> input) {
        int max = 0;
        parseInput(input);

        //left side to EAST and right side to WEST
        for (int i = 0; i < field.length; i++) {

            MirrorField f1 = new MirrorField(input);
            int energy1 = f1.countEnergized(i, 0, Direction.EAST);
            if (energy1 > max) {
                max = energy1;
            }

            MirrorField f2 = new MirrorField(input);
            int energy2 = f2.countEnergized(i, field[i].length-1, Direction.WEST);
            if (energy2 > max) {
                max = energy2;
            }
        }

        // top side to SOUTH and bottom side to NORTH
        for (int j = 0; j < field[0].length; j++) {

            MirrorField f1 = new MirrorField(input);
            int energy1 = f1.countEnergized(0, j, Direction.SOUTH);
            if (energy1 > max) {
                max = energy1;
            }

            MirrorField f2 = new MirrorField(input);
            int energy2 = f2.countEnergized(field.length, j, Direction.NORTH);
            if (energy2 > max) {
                max = energy2;
            }
        }

        return max;
    }

    private void printField(int ix, int jx)  {
        System.out.println("============================" + ix + " " + jx);
        for (Tile[] tiles : field) {
            for (Tile t : tiles) {
                if (t.isLit()) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }


    private void walkThrough(int i, int j, Direction direction) {
        step(i, j, direction);
    }

    private void step(int i, int j, Direction inboundDirection) {
        Tile tile = getTile(i, j);

        if (tile == null || ((tile.getID() =='|' || tile.getID() =='-') && tile.isLit())) {
            return;
        }

        tile.lit();

        for (Direction outDirection : tile.getOutDirections(inboundDirection)) {

            if (outDirection == Direction.SOUTH) {
                step(i+1, j, outDirection);
            } else if (outDirection == Direction.NORTH) {
                step(i-1, j, outDirection);
            } else if (outDirection == Direction.WEST) {
                step(i, j-1, outDirection);
            } else if (outDirection == Direction.EAST) {
                step(i, j+1, outDirection);
            }
        }
    }

    private void parseInput(List<String> input) {

        char[][] inputMatrix = ListUtil.convertToCharArrayMatrix(input);

        field = new Tile[inputMatrix.length][inputMatrix[0].length];

        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[i].length; j++) {
                char c = inputMatrix[i][j];
                if (c == '.') {
                    field[i][j] = new EmptySpace();
                } else if (c == '|') {
                    field[i][j] = new VerticalSplitter();
                } else if (c == '-') {
                    field[i][j] = new HorizontalSplitter();
                } else if (c == '/') {
                    field[i][j] = new RightMirror();
                } else if (c == '\\') {
                    field[i][j] = new LeftMirror();
                } else {
                    throw new RuntimeException("Unknown tile: " + c);
                }
            }
        }
    }

    Tile getTile(int i, int j) {
        if (i < 0 || i >= field.length || j < 0 || j >= field[0].length) {
            return null;
        }
        return field[i][j];
    }
}
