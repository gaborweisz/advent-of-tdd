package util;

import java.util.List;

public class MathUtil {

    /**
     * Calculate Least Common Multiple (LCM) of a list of doubles
     */
    public static double calculateLCM(List<Double> list) {
        double[] array = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return calculateLCM(array);
    }

    /**
     * Calculate Least Common Multiple (LCM) of an array of doubles
     */
    public static double calculateLCM(double[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Input array is empty or null");
        }

        double lcm = array[0];
        for (int i = 1; i < array.length; i++) {
            lcm = calculateLCM(lcm, array[i]);
        }

        return lcm;
    }

    /**
     * Calculate Least Common Multiple (LCM) of two doubles
     */
    private static double calculateLCM(double a, double b) {
        return (Math.abs(a * b) / calculateGCD(a, b));
    }

    /**
     * Calculate Greatest Common Divisor (GCD) of two doubles
     */
    private static double calculateGCD(double a, double b) {
        while (b > 0) {
            double temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
