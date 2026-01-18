package org.advent2025.day2;

import util.FileReader;

public class SolverPart1 {


    public static void main(String[] args) {
        var f = new FileReader();
        String ranges = f.readFileAndConvertToString("puzzleinput_2025_day2.txt");

        System.out.println("Solution for day 2025 / day 2 / a : " + new SolverPart1().solvePuzzle(ranges));
    }

    public long solvePuzzle(String ranges) {
        long sumInvalidIds = 0;

        for (Range range : SolverUtil.getRanges(ranges)) {
            for (long id = range.start; id <= range.end; id++) {
                if (!isIdValid(id)) {
                    sumInvalidIds += id;
                }
            }
        }

        return sumInvalidIds;
    }


    /**
     * invalid IDs is made only of some sequence of digits repeated twice. So, 55 (5 twice), 6464 (64 twice), and 123123 (123 twice) would all be invalid IDs.
     * None of the numbers have leading zeroes; 0101 isn't an ID at all. (101 is a valid ID that you would ignore.)
     *
     * @param id
     * @return true if the id is valid, false if invalid
     */
    boolean isIdValid(long id) {
        String idStr = Long.toString(id);
        int len = idStr.length();
        if (len % 2 != 0) {
            return true;
        }

        String firstHalf = idStr.substring(0, len / 2);
        String secondHalf = idStr.substring(len / 2);
        if (firstHalf.equals(secondHalf)) {
            return false;
        }

        return true;
    }


}
