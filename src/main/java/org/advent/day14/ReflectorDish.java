package org.advent.day14;

import util.MatrixUtil;
import util.Pair;

import java.util.ArrayList;
import java.util.List;

public class ReflectorDish {


    public static double calculateLoad(char[][] dish) {
        double load = 0;

        for (int j = 0; j < dish[0].length; j++) {
            for (int i = 0; i < dish.length; i++) {
                int weight = dish.length - i;
                if (dish[i][j] == 'O') {
                    load += weight;
                }
            }
        }
        return load;
    }

    public static char[][] effectiveSpin(char[][] dish, int cycles) {
        Pair<Integer> repeat = calculateRepeat(dish, cycles);
        int first = repeat.getFirst();
        int second = repeat.getSecond();
        int cyclesToRepeat = second - first;

        return spin(dish, first + (cycles - first) % cyclesToRepeat);
    }

    public static Pair<Integer> calculateRepeat(char[][] dish, int cycles) {
        char[][] newDish = MatrixUtil.copyMatrix(dish);
        List<char[][]> dishes = new ArrayList<>();

        int index1 = -1;
        int index2 = -2;

        for (int i = 1; i <= cycles; i++) {

            newDish = MatrixUtil.tiltNorth(newDish);
            newDish = MatrixUtil.tiltWest(newDish);
            newDish = MatrixUtil.tiltSouth(newDish);
            newDish = MatrixUtil.tiltEast(newDish);

            int index = containsDish(dishes, newDish);

            if (index > -1) {
                dishes.clear();
                dishes.add(newDish);

                if (index1 == -1) {
                    index1 = i;

                } else {
                    return new Pair(index1, i);
                }
            } else {
                dishes.add(newDish);
            }


        }
        return new Pair(-1, -1);
    }

    public static char[][] spin(char[][] dish, int cycles) {
        char[][] newDish = MatrixUtil.copyMatrix(dish);

        for (int i = 0; i < cycles; i++) {

            newDish = MatrixUtil.tiltNorth(newDish);
            newDish = MatrixUtil.tiltWest(newDish);
            newDish = MatrixUtil.tiltSouth(newDish);
            newDish = MatrixUtil.tiltEast(newDish);
        }

        return newDish;
    }

    public static int containsDish(List<char[][]> dishes, char[][] dish) {
        for (int i = 0; i < dishes.size(); i++) {
            char[][] d = dishes.get(i);
            if (MatrixUtil.areEqual(d, dish)) {
                return i;
            }
        }

        return -1;
    }

    public static int findDish(List<char[][]> dishes, char[][] dish, int startIdx) {
        for (int i = startIdx; i < dishes.size(); i++) {
            char[][] d = dishes.get(i);
            if (MatrixUtil.areEqual(d, dish)) {
                return i;
            }
        }

        return -1;
    }
}
