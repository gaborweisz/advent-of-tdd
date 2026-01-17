package org.advent2023.day18;

import util.MatrixUtil;

import java.util.ArrayList;
import java.util.List;

public class Digger {

    List<DigStep> steps = new ArrayList<>();
    char[][] field;


    public Digger(List<String> digPlan, int height, int width) {
        parsePlan(digPlan);
        field = new char[height][width];
        MatrixUtil.fillMatrix(field, '.');
    }

    /**
     * Parses the dig plan and calculates the trench capacity - the sum of the perimeter and the hole. This solves puzzle a
     * @return trench capacity (solution for puzzle a)
     */
    public int calculateTrenchCapacity() {

        digPerimeter(field.length/2, field.length/2);
        int perimeter = MatrixUtil.countField(field, '#');

        digAll(0,0);
        int hole = MatrixUtil.countField(field, '.');

        return perimeter + hole;
    }



    /**
     * Digs the perimeter from start point
     * @param startI start point
     * @param startJ start point
     */
    public void digPerimeter(int startI, int startJ ) {
        int i = startI;
        int j = startJ;
        field[i][j] = '#';
        for (DigStep step : steps) {
            for (int k = 0; k < step.steps; k++) {
                switch (step.direction) {
                    case 'R' -> j++;
                    case 'L' -> j--;
                    case 'U' -> i--;
                    case 'D' -> i++;
                }
                field[i][j] = '#';
            }
        }
    }

    /**
     * Digs all from start point recursively
     * @param i start point
     * @param j start point
     */
    public void digAll(int i, int j ) {
        if (i < 0 || i >= field.length || j < 0 || j >= field[0].length) {
            return;
        }

        if (field[i][j] == '#') {
            return;
        }

        field[i][j] = '#';

        digAll(i-1, j);
        digAll(i+1, j);
        digAll(i, j-1);
        digAll(i, j+1);
    }

    /**
     * Parses the dig plan
     * @param digPlan input of the puzzle
     */
    private void parsePlan(List<String> digPlan) {
        for (String s : digPlan) {

            String[] parts = s.split(" ");
            char direction = parts[0].charAt(0);
            int steps = Integer.parseInt(parts[1]);
            DigStep step = new DigStep(direction, steps);
            this.steps.add(step);
        }
    }
}
