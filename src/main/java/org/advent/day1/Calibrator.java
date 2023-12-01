package org.advent.day1;

import java.util.HashMap;
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
        NUMBER_MAP.put("nine","9");
        NUMBER_MAP.put("five","5");
        NUMBER_MAP.put("two","2");
        NUMBER_MAP.put("one","1");
        NUMBER_MAP.put("eight","8");
        NUMBER_MAP.put("three","3");
        NUMBER_MAP.put("four","4");
        NUMBER_MAP.put("six","6");
        NUMBER_MAP.put("seven","7");
    }

    /**
     * Gets the calibration value based on document line
     *
     * @return calibration value
     */
    public static int getCalibrationValue(String line) {

        char dFirst = getFirstDigit(line);
        char dLast = getLastDigit(line);

        return Integer.parseInt(Character.toString(dFirst) + Character.toString(dLast));
    }

    /**
     * ets the calibration value based on document line
     * @param line
     * @return
     */
    public static int getCalibrationValueText(String line) {

        String newLine= replaceFirstTextToDigit(line);

        char dFirst = getFirstDigit(newLine);
        char dLast = getLastDigit(newLine);

        return Integer.parseInt(Character.toString(dFirst) + Character.toString(dLast));
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
     * Replaces the first digit written as text with numeric digits
     * @param line
     * @return the line with numeric digits only
     */
    public static String replaceFirstTextToDigit(String line) {

        String newLine = line;
        int minPos = Integer.MAX_VALUE;
        String firstText = "";
        for (Map.Entry<String, String> entry : NUMBER_MAP.entrySet()) {
            int pos = line.indexOf(entry.getKey());
            if (pos < minPos && pos > -1) {
                minPos = pos;
                firstText = entry.getKey();
            }
        }

        if (minPos < Integer.MAX_VALUE) {
            newLine = newLine.replace(firstText, NUMBER_MAP.get(firstText));
        }
        return newLine;
    }

}
