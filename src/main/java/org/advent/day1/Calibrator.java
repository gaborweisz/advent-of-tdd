package org.advent.day1;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Calibrator implements solution for the puzzle https://adventofcode.com/2023/day/1
 */
public class Calibrator {


    public static final List<Character> DIGIT_ARRAY = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
    public static final Map<String, String> NUMBER_MAP = new LinkedHashMap<>();

    static {
        NUMBER_MAP.put("1", "1");
        NUMBER_MAP.put("2", "2");
        NUMBER_MAP.put("3", "3");
        NUMBER_MAP.put("4", "4");
        NUMBER_MAP.put("5", "5");
        NUMBER_MAP.put("6", "6");
        NUMBER_MAP.put("7", "7");
        NUMBER_MAP.put("8", "8");
        NUMBER_MAP.put("9", "9");
        NUMBER_MAP.put("one", "1");
        NUMBER_MAP.put("two", "2");
        NUMBER_MAP.put("three", "3");
        NUMBER_MAP.put("four", "4");
        NUMBER_MAP.put("five", "5");
        NUMBER_MAP.put("six", "6");
        NUMBER_MAP.put("seven", "7");
        NUMBER_MAP.put("eight", "8");
        NUMBER_MAP.put("nine", "9");
    }

    /**
     * Gets the calibration value based on document line ignoring number in text
     *
     * @return calibration value
     */
    public static int getCalibrationValue(String line) {

        char dFirst = getFirstDigit(line);
        char dLast = getLastDigit(line);

        return Integer.parseInt(Character.toString(dFirst) + Character.toString(dLast));
    }

    /**
     * Gets the calibration value based on document line including number in text
     *
     * @param line
     * @return
     */
    public static int getCalibrationValueText(String line) {

        String dFirst = getFirstNumber(line);
        String dLast = getLastNumber(line);

        return Integer.parseInt(dFirst + dLast);
    }

    /**
     * Returns the first numeric character of the string
     *
     * @param line
     */
    public static char getFirstDigit(String line) {
        for (char c : line.toCharArray()) {
            if (DIGIT_ARRAY.contains(c)) {
                return c;
            }
        }

        return 'a';
    }


    /**
     * Returns the last numeric character of the string
     *
     * @param line
     * @return last numeric character
     */
    public static char getLastDigit(String line) {
        var cArray = line.toCharArray();
        for (int i = cArray.length - 1; i >= 0; i--) {
            char c = cArray[i];
            if (DIGIT_ARRAY.contains(c)) {
                return c;
            }
        }
        return 'a';
    }

    /**
     * Returns the first digit either written as text or in numeric format
     *
     * @param line text line to be processed
     * @return first number found or empty string if none found
     */
    public static String getFirstNumber(String line) {

        int minPos = Integer.MAX_VALUE;
        String firstNumber = "";
        for (Map.Entry<String, String> entry : NUMBER_MAP.entrySet()) {
            int pos = line.indexOf(entry.getKey());
            if (pos < minPos && pos > -1) {
                minPos = pos;
                firstNumber = entry.getValue();
            }
        }

        return firstNumber;
    }

    /**
     * Returns the last digit either written as text or in numeric format
     *
     * @param line text line to be processed
     * @return last number found or empty string if none found
     */
    public static String getLastNumber(String line) {

        String lastNumber = "";

        for (int i = 0; i < line.length(); i++) {
            String subLine = line.substring(i, line.length());
            int maxPos = Integer.MIN_VALUE;
            for (Map.Entry<String, String> entry : NUMBER_MAP.entrySet()) {
                int pos = subLine.indexOf(entry.getKey());
                if (pos > maxPos && pos != -1) {
                    maxPos = pos;
                    lastNumber = entry.getValue();
                }
            }
        }

        return lastNumber;
    }

}
