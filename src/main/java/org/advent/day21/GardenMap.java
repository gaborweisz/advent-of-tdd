package org.advent.day21;

import util.ListUtil;
import util.MatrixUtil;
import util.Pair;

import java.util.List;

public class GardenMap {

    char[][] map;

    public GardenMap(List<String> input) {
        map = ListUtil.convertToCharArrayMatrix(input);
    }

    /**
     * Finds the number of reachable plots from the start position after given number of iterations
     * @param iterations the number of iterations
     * @return the start position
     */
    int findReachablePlots(int iterations) {
        char[][] map = MatrixUtil.copyMatrix(this.map);
        for (int i = 0; i < iterations; i++) {
            map = findReachablePlots(map);
        }

        return countReachable(map);
    }

    private int countReachable(char[][] map) {
        int count = 0;
        for (char[] row : map) {
            for (char c : row) {
                if (c == 'O') {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Finds the reachable plots from the current state of the garden map
     *
     * @param currentMap the garden map current state
     * @return the garden map with reachable plots marked with 'O'
     */

    char[][] findReachablePlots(char[][] currentMap) {

        char[][] newMap = MatrixUtil.copyMatrix(currentMap);

        for (int i = 0; i < currentMap.length; i++) {
            char[] row = currentMap[i];
            for (int j= 0; j < row.length; j++) {
                if (row[j] == 'S' || row[j] == 'O') {
                    markReachable(newMap, i, j);
                }
            }
        }

        return newMap;
    }

    private void markReachable(char[][] newMap, int i, int j) {
        newMap[i][j] = '.';
        if (i > 0 && newMap[i - 1][j] != '#') {
            newMap[i - 1][j] = 'O';
        }
        if (i < newMap.length - 1 && newMap[i + 1][j] != '#' ) {
            newMap[i + 1][j] = 'O';
        }
        if (j > 0 && newMap[i][j - 1] != '#') {
            newMap[i][j - 1] = 'O';
        }
        if (j < newMap[i].length - 1 && newMap[i][j + 1] != '#') {
            newMap[i][j + 1] = 'O';
        }
    }

    /**
     * Finds the start position
     *
     * @return x,y
     */
    Pair<Integer> findStart() {
        for (int y = 0; y < map.length; y++) {
            char[] row = map[y];
            for (int x = 0; x < row.length; x++) {
                if (row[x] == 'S') {
                    return new Pair<>(x, y);
                }
            }
        }
        return null;
    }
}
