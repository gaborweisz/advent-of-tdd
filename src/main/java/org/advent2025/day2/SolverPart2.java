package org.advent2025.day2;

import util.FileReader;

public class SolverPart2 {


    public static void main(String[] args) {
        var f = new FileReader();
        String ranges = f.readFileAndConvertToString("puzzleinput_2025_day2.txt");

        System.out.println("Solution for day 2025 / day 2 / b : " + new SolverPart2().solvePuzzle(ranges));
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
     * an ID is invalid if it is made only of some sequence of digits repeated at least twice. So, 12341234 (1234 two times), 123123123 (123 three times), 1212121212 (12 five times), and 1111111 (1 seven times) are all invalid IDs.
     *
     * @param id
     * @return true if the id is valid, false if invalid
     */
    boolean isIdValid(long id) {
        String idStr = Long.toString(id);
        for (int i = 2; i <= idStr.length(); i++) {
            if (idStr.length() % i != 0) {
                continue;
            }

            String part = idStr.substring(0, idStr.length() / i);
            StringBuilder sb = new StringBuilder();
            sb.append(part.repeat(i));

            if (sb.toString().equals(idStr)) {
                return false;
            }
        }

        return true;
    }


}
