package org.advent2023.day11;

import util.ListUtil;
import util.MatrixUtil;

import java.util.ArrayList;
import java.util.List;

public class Observatory {


    char[][]  galaxyMap;
    char EMPTY = '.';
    char GALAXY = '#';
    List<Galaxy> galaxies = new ArrayList<>();
    List<Integer> emptyRowIndexes = new ArrayList<>();
    List<Integer> emptyColIndexes = new ArrayList<>();

    public Observatory(List<String> rows) {
        this.galaxyMap = ListUtil.convertToCharArrayMatrix(rows);
        expand();
        identifyGalaxies();
    }

    /**
     * Expand the galaxy map by adding and empty row or column to each empty rows and columns
     */
    void expand( ) {

        for (int i = 0; i < this.galaxyMap.length; i++) {
            if (MatrixUtil.isRowEmpty(this.galaxyMap, i, EMPTY)) {
                emptyRowIndexes.add(i);
            }
        }
        for (int i = 0; i < this.galaxyMap[0].length; i++) {
            if (MatrixUtil.isColumnEmpty(this.galaxyMap, i, EMPTY)) {
                emptyColIndexes.add(i);
            }
        }
    }

    /**
     * Identify the galaxies in the expanded galaxy map and build a list of galaxies
     */
    void identifyGalaxies() {
        for (int i = 0; i < this.galaxyMap.length; i++) {
            for (int j = 0; j < this.galaxyMap[0].length; j++) {
                if (this.galaxyMap[i][j] == GALAXY) {
                    Galaxy g = new Galaxy(i, j);
                    galaxies.add(g);
                }
            }
        }
    }

    /**
     * Calculate the sum of the distances of all galaxy pairs, also the solution of the puzzle
     * @return solution
     */
    double calculateTheSumDistancesOfAllGalaxyPairs(int expandRatio) {
        double sum = 0;
        if (expandRatio > 1) {
            expandRatio = expandRatio - 1;
        }

        for (int i = 0; i < galaxies.size(); i++) {
            for (int j = i + 1; j < galaxies.size(); j++) {
                Galaxy g1 = galaxies.get(i);
                Galaxy g2 = galaxies.get(j);
                double distance = g1.distanceTo(g2,this, expandRatio);
                sum += distance;
            }
        }
        return sum;
    }
}
