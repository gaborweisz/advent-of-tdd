package org.advent2023.day9;

import util.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class ReportLine {

    List<Long> values;
    Long extrapolatedValue;
    Long extrapolatedFirstValue;

    public ReportLine(String line) {
        parseLine(line);
        extrapolatedValue = ReportLine.calculateExtrapolatedValue(values);
        extrapolatedFirstValue = ReportLine.calculateExtrapolatedFirstValue(values);
    }

    private void parseLine(String line) {
        values = new ArrayList<>();
        String[] split = line.split(" ");
        for (String s : split) {
            values.add(Long.parseLong(s));
        }
    }

    static List<Long> calculateDifference(List<Long> line) {
        List<Long> differences = new ArrayList<>();
        for (int i = 1; i < line.size(); i++) {
            differences.add(line.get(i) - line.get(i - 1));
        }
        return differences;
    }

    static List<List<Long>> calculateDifferenceHierarchy(List<Long> line) {
        List<List<Long>> differences = new ArrayList<>();
        List<Long> lineDifferences = line;
        while (!isAllZero(lineDifferences)) {
            lineDifferences = calculateDifference(lineDifferences);
            differences.add(lineDifferences);
        }
        return differences;
    }

    static boolean isAllZero(List<Long> line) {
        for (Long l : line) {
            if (l != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 10  13  16  21  30  45  68
     *    3   3   5   9  15  -> 23
     *      0   2   4   6  ->  8
     *        2   2   2  ->  2
     *          0   0   0
     * @param differences
     * @return
     */
    static List<List<Long>> extrapolate(List<List<Long>> differences){
        List<List<Long>> extrapolated = ListUtil.copyListOfLists(differences);

        for (int i = extrapolated.size()-1; i > 0; i--) {

            List<Long> diffLine = extrapolated.get(i);
            List<Long> valueLine = extrapolated.get(i-1);
            long diff = diffLine.get(diffLine.size()-1);
            long value = valueLine.get(valueLine.size()-1);
            valueLine.add(value+diff);

        }
        return extrapolated;
    }

    /**
     * 5 <- 10  13  16  21  30  45  68
     *  5 <- 3   3   5   9  15
     *   -2 <- 0   2   4   6
     *     2 <-  2   2   2
     *             0   0
     * @param differences
     * @return
     */
    static List<List<Long>> extrapolateFirst(List<List<Long>> differences){
        List<List<Long>> extrapolated = ListUtil.copyListOfLists(differences);

        for (int i = extrapolated.size()-1; i > 0; i--) {

            List<Long> diffLine = extrapolated.get(i);
            List<Long> valueLine = extrapolated.get(i-1);
            long diff = diffLine.get(0);
            long value = valueLine.get(0);
            valueLine.add(0, value-diff);

        }
        return extrapolated;
    }


    /**
     * Extrapolate the last value of the line
     * @param line
     * @return extrapolated value
     */
    static Long calculateExtrapolatedValue(List<Long> line) {
        List<List<Long>> differenceHierarchy = calculateDifferenceHierarchy(line);
        List<List<Long>> extrapolatedDifferences = extrapolate(differenceHierarchy);

        long lastDiff = extrapolatedDifferences.get(0).get(extrapolatedDifferences.get(0).size()-1);
        long lastValue = line.get(line.size()-1);

        return lastDiff + lastValue;
    }


    /**
     * Extrapolate the fist value of the line
     * @param line
     * @return extrapolated value
     */
    static Long calculateExtrapolatedFirstValue(List<Long> line) {
        List<List<Long>> differenceHierarchy = calculateDifferenceHierarchy(line);
        List<List<Long>> extrapolatedDifferences = extrapolateFirst(differenceHierarchy);

        long lastDiff = extrapolatedDifferences.get(0).get(0);
        long lastValue = line.get(0);

        return lastValue - lastDiff;
    }


}

