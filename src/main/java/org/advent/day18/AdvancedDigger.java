package org.advent.day18;


import util.MatrixUtil;

import java.util.*;

/**
 * Capable of providing the solution for puzzle b
 */
public class AdvancedDigger {

    List<DigStep> steps = new ArrayList<>();
    Map<Long, List<Position>> positionMap = new HashMap<>();


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

        double size = 0;
        for (List<Position> positionList : positionMap.values()) {
            size += calculateSize(positionList);
        }

        return size;
    }


    private double calculateSize(List<Position> positionList) {

        Collections.sort(positionList);

        double size = 0;
        long lastJ = 0;
        for (int i = 0; i < positionList.size() ; i++) {
            long currentJ = positionList.get(i).j;

            if (currentJ - lastJ == 1) {
                System.out.println("Problem");
            }

            if (positionList.size() % 2 == 0 ) {
                if (i % 2 == 0) {
                    lastJ = currentJ ;
                } else  {
                    size += positionList.get(i).j - lastJ + 1;
                }
            } else {
                size += positionList.get(positionList.size()-1).j - positionList.get(0).j + 1;
                break;
            }

        }
        return size;
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

        addToMap(i, j);
        for (DigStep step : steps) {

            switch (step.direction) {
                case 'R' -> j += step.steps;
                case 'L' -> j -= step.steps;
            }

            if (step.direction == 'U' || step.direction == 'D')
                for (long k = 0; k < step.steps; k++) {
                    switch (step.direction) {
                        case 'U' -> i -= 1;
                        case 'D' -> i += 1;
                    }
                    addToMap(i, j);
                }
        }
    }

    void addToMap(long i, long j) {
        if (positionMap.containsKey(i)) {
            positionMap.get(i).add(new Position(i, j));
        } else {
            List<Position> list = new ArrayList<>();
            list.add(new Position(i, j));
            positionMap.put(i, list);
        }
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

