package org.advent2025.day1;

import util.FileReader;

import java.util.List;

public class SolverPart2 {
    int MAX_VALUE = 99;
    int MIN_VALUE = 0;
    int START_VALUE = 50;

    public static void main(String[] args) {
        var f = new FileReader();
        List<String> rows = f.readFileAndConvertToStringArray("puzzleinput_2025_day1.txt");

        System.out.println("Solution for day 2025 / day 1 / a : " + new SolverPart2().solvePuzzle(rows));
    }

    class RotationResult {
        int newValue;
        int hitZero;

        public RotationResult(int newValue, int hitZero) {
            this.newValue = newValue;
            this.hitZero = hitZero;
        }
    }

    int solvePuzzle(List<String> rows) {
        int value = START_VALUE;
        int hitZeroCount = 0;

        for (String row : rows) {
            RotationResult result = rotate(value, row);
            hitZeroCount += result.hitZero;
            value = result.newValue;
            if (value == 0) {
                hitZeroCount++;
            }
        }

        return hitZeroCount;
    }

    RotationResult rotate(int currentAmount, String rotation) {
        String direction = rotation.substring(0, 1);
        int rotateAmount = Integer.parseInt(rotation.substring(1));

        if ("R".equals(direction)) {
            return rotateRight(currentAmount, rotateAmount);
        } else if ("L".equals(direction)) {
            return rotateLeft(currentAmount, rotateAmount);
        }

        return null;
    }

    RotationResult rotateRight(int currentAmount, int rotateAmount) {
        int amountTilMax = MAX_VALUE - currentAmount;

        if (rotateAmount <= amountTilMax) {
            return new RotationResult(currentAmount + rotateAmount, 0);
        } else if (rotateAmount <= MAX_VALUE) {
            int remaining = rotateAmount - amountTilMax;
            int newValue = MIN_VALUE + remaining - 1;
            int hitZero = (newValue == 0) ? 0 : 1;
            return new RotationResult(newValue, hitZero);
        } else {
            int fullRotations = rotateAmount / (MAX_VALUE + 1);
            int remaining = rotateAmount - (fullRotations * (MAX_VALUE + 1));
            RotationResult result = rotateRight(currentAmount, remaining);
            return new RotationResult(result.newValue, fullRotations + result.hitZero);
        }
    }

    RotationResult rotateLeft(int currentAmount, int rotateAmount) {
        int amountTilMin = currentAmount - MIN_VALUE;

        if (rotateAmount <= amountTilMin) {
            return new RotationResult(currentAmount - rotateAmount, 0);
        } else if (rotateAmount <= MAX_VALUE) {
            int remaining = rotateAmount - amountTilMin;
            int newValue = MAX_VALUE - remaining + 1;
            int hitZero = (currentAmount == 0) ? 0 : 1;
            return new RotationResult(newValue, hitZero);
        } else {
            int fullRotations = rotateAmount / (MAX_VALUE + 1);
            int remaining = rotateAmount - (fullRotations * (MAX_VALUE + 1));
            RotationResult result = rotateLeft(currentAmount, remaining);
            return new RotationResult(result.newValue, fullRotations + result.hitZero);
        }
    }


}
