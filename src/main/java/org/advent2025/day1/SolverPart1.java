package org.advent2025.day1;

import util.FileReader;

import java.util.List;

public class SolverPart1 {
    int MAX_VALUE = 99;
    int MIN_VALUE = 0;
    int START_VALUE = 50;

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day1.txt");

        System.out.println("Solution for day 2025 / day 1 / a : " + new SolverPart1().solvePuzzle(rows));
    }

    int solvePuzzle(List<String> rows) {
        int value = START_VALUE;
        int hitZeroCount = 0;

        for (String row : rows) {
            value = rotate(value, row);
            if (value == 0) {
                hitZeroCount++;
            }
        }

        return hitZeroCount;
    }

    int rotate(int currentAmount, String rotation) {
        String direction = rotation.substring(0, 1);
        int rotateAmount = Integer.parseInt(rotation.substring(1));

        if ("R".equals(direction)) {
            return rotateRight(currentAmount, rotateAmount);
        } else if ("L".equals(direction)) {
            return rotateLeft(currentAmount, rotateAmount);
        }

        return 0;
    }

    int rotateRight(int currentAmount, int rotateAmount) {
        int amountTilMax = MAX_VALUE - currentAmount;

        if (rotateAmount <= amountTilMax) {
            return currentAmount + rotateAmount;
        } else if (rotateAmount <= MAX_VALUE) {
            int remaining = rotateAmount - amountTilMax;
            return MIN_VALUE + remaining - 1;
        } else {
            int fullRotations = rotateAmount / (MAX_VALUE + 1);
            int remaining = rotateAmount - (fullRotations * (MAX_VALUE + 1));
            return rotateRight(currentAmount, remaining);
        }
    }

    int rotateLeft(int currentAmount, int rotateAmount) {
        int amountTilMin = currentAmount - MIN_VALUE;

        if (rotateAmount <= amountTilMin) {
            return currentAmount - rotateAmount;
        } else if (rotateAmount <= MAX_VALUE) {
            int remaining = rotateAmount - amountTilMin;
            return MAX_VALUE - remaining + 1;
        } else {
            int fullRotations = rotateAmount / (MAX_VALUE + 1);
            int remaining = rotateAmount - (fullRotations * (MAX_VALUE + 1));
            return rotateLeft(currentAmount, remaining);
        }
    }


}
