package org.advent2023.day18;


import util.Pair;

import java.util.*;

/**
 * Capable of providing the solution for puzzle b
 */
public class AdvancedDigger {

    List<DigStep> steps = new ArrayList<>();
    List<Position> positions = new ArrayList<>();
    List<Pair<Position>> rectangles = new ArrayList<>();

    public AdvancedDigger(List<String> digPlan) {
        parsePlan(digPlan);
    }

    /**
     * Parses the dig plan and calculates the trench capacity - the sum of the perimeter and the hole. This solves puzzle a
     *
     * @return trench capacity (solution for puzzle a)
     */
    public double calculateTrenchCapacity() {

        digPerimeter(1000000000, 1000000000);
        slice(positions) ;

        double size = 0;
        for (Pair<Position> rect : rectangles) {
            double a = Math.abs(rect.getFirst().i - rect.getSecond().i);
            double b = Math.abs(rect.getFirst().j - rect.getSecond().j);
            size += a * b;
        }

        return size;
    }

    private void slice(List<Position> positions ) {

        if (positions.size() == 0) {
            return;
        }

        List<Position> positionsCopy = new ArrayList<>(positions);
        Collections.sort(positionsCopy);

        //top lef position of rectangle
        Position topLeft =positionsCopy.get(0);

        for (int i = 1; i < positionsCopy.size(); i++) {
            Position pos2 = positionsCopy.get(i);

            if (pos2.j == topLeft.j) {
                //found the bottom left position of rectangle
                for (int j = 1; j < positionsCopy.size(); j++) {
                    Position pos3 = positionsCopy.get(j);

                    if (pos2.i == pos3.i && pos2.j != pos3.j) {
                        //bottom right position of rectangle
                        rectangles.add(new Pair<>(topLeft, pos3));
                        positionsCopy.remove(i);
                        positionsCopy.remove(0);

                        //top right position of rectangle added to positions (if it does not exist)
                        boolean found = false;
                        for (Position pos : positionsCopy) {
                            if (pos.i == topLeft.i && pos.j == pos3.j) {
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            positionsCopy.add(new Position(topLeft.i, pos3.j));
                        }

                        slice(positionsCopy);
                    }
                }
            }
        }
    }


    /**
     * Digs the perimeter from start point
     *
     * @param startI start point
     * @param startJ start point
     */
    public void digPerimeter(long startI, long startJ) {
        long i = startI;
        long j = startJ;

        System.out.println("Start digging, at position: " + i + ", " + j);

        for (DigStep step : steps) {

            switch (step.direction) {
                case 'R' -> j += step.steps;
                case 'L' -> j -= step.steps;
                case 'U' -> i -= step.steps;
                case 'D' -> i += step.steps;
            }
            positions.add(new Position(i, j));
        }

        System.out.println("   - > digging at position: " + i + ", " + j);
    }



    /**
     * Parses the dig plan
     *
     * @param digPlan input of the puzzle
     */
    private void parsePlan(List<String> digPlan) {
        for (String s : digPlan) {
            String[] parts = s.split(" ");
            String step = parts[2].substring(7, 8);
            String hex = parts[2].substring(2, 7);

            // 0 means R, 1 means D, 2 means L, and 3 means U.
            char direction = '.';
            switch (step) {
                case "0" -> direction = 'R';
                case "1" -> direction = 'D';
                case "2" -> direction = 'L';
                case "3" -> direction = 'U';
            }
            int steps = Integer.parseInt(hex, 16);
            DigStep digStep = new DigStep(direction, steps);
            this.steps.add(digStep);
        }
    }

}

