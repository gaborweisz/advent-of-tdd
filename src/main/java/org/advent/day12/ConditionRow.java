package org.advent.day12;

import java.util.*;

public class ConditionRow {

    String condition;
    int rowLength;
    List<DamagedSpring> damagedSprings = new ArrayList<>();
    List<List<DamagedSpring>> damagedSpringLists = new ArrayList<>();
    Set<String> variations = new HashSet<>();

    public ConditionRow(String conditionRow, int fold) {
        parseConditionRowAndFold(conditionRow, fold);
        calculateVariations();
    }

    public ConditionRow(String conditionRow) {
        parseConditionRow(conditionRow);
        calculateVariations();
    }

    /**
     * Calculates arrangements for this row
     *
     * @return number of arrangements
     */
    public int calculateArrangements() {
        for (List<DamagedSpring> damagedSpringList : damagedSpringLists) {
            String pattern = getVariationPattern(damagedSpringList);
            if (matchVariationPattern(pattern)) {
                variations.add(pattern);
            }
        }

        ArrayList<String> arrayList = new ArrayList<>(variations);
        Collections.sort(arrayList);

        printDetails(arrayList);
        return variations.size();
    }

    private void printDetails(ArrayList<String> arrayList) {
        System.out.print("Variations: " + variations.size() + " - ");
        for (DamagedSpring d : damagedSprings) {
            System.out.print(d.length + ",");
        }
        System.out.println();
        System.out.println(condition);
        System.out.println("---------------------------");
        for (String pattern : arrayList) {
            System.out.println(pattern);
        }
        System.out.println("\n\n-========================");
    }

    /**
     * Compares the condition with the pattern
     *
     * @param pattern pattern to compare
     * @return true if condition matches pattern
     */
    public boolean matchVariationPattern(String pattern) {

        for (int i = 0; i < pattern.length(); i++) {
            if (condition.charAt(i) == '#') {
                if (pattern.charAt(i) != '#') {
                    return false;
                }
            }

            if (condition.charAt(i) == '.') {
                if (pattern.charAt(i) != '.') {
                    return false;
                }
            }
        }

        if (condition.length() > pattern.length()) {
            String sub = condition.substring(pattern.length());
            return !sub.contains("#");
        }

        return true;
    }

    /**
     * Creates a pattern based on the arrangement of the damaged springs
     *
     * @param damagedSpringList
     * @return patter in string format
     */
    private String getVariationPattern(List<DamagedSpring> damagedSpringList) {
        StringBuilder pattern = new StringBuilder();
        int shift = 1;
        for (DamagedSpring damagedSpring : damagedSpringList) {
            pattern.append(".".repeat(damagedSpring.position - shift)).append("#".repeat(damagedSpring.length));
            shift = pattern.length() + 1;
        }
        return pattern.toString();
    }

    /**
     * Calculates all possible arrangements for this row
     */
    public void calculateVariations() {
        damagedSpringLists.add(damagedSprings);
        nextArrangement(damagedSprings);
    }


    /**
     * Recursive method to calculate all possible arrangements
     *
     * @param currentDamagedSprings current arrangement
     */
    public void nextArrangement(List<DamagedSpring> currentDamagedSprings) {

        for (int i = currentDamagedSprings.size() - 1; i >= 0; i--) {

            DamagedSpring damagedSpring = currentDamagedSprings.get(i);
            List<DamagedSpring> shiftedDamagedSprings = shiftPositions(currentDamagedSprings, damagedSpring.position);

            int length = calculateLength(shiftedDamagedSprings);

            if (length > this.rowLength) {
                return;
            } else {
                damagedSpringLists.add(shiftedDamagedSprings);
                nextArrangement(shiftedDamagedSprings);
            }
        }
    }

    /**
     * Calculates the length of the row based on the last damaged spring
     *
     * @param damagedSprings damaged springs
     * @return length of row
     */
    public int calculateLength(List<DamagedSpring> damagedSprings) {
        DamagedSpring lastDamagedSpring = damagedSprings.get(damagedSprings.size() - 1);

        return lastDamagedSpring.position + lastDamagedSpring.length - 1;
    }

    /**
     * Shifts the positions of the damaged springs by 1 starting from the given position
     *
     * @param damagedSprings damaged springs to shift
     * @param position       tp start to shift
     * @return shifted damaged springs
     */
    public List<DamagedSpring> shiftPositions(List<DamagedSpring> damagedSprings, int position) {
        List<DamagedSpring> shiftedDamagedSprings = new ArrayList<>();
        for (DamagedSpring damagedSpring : damagedSprings) {
            if (damagedSpring.position >= position) {
                shiftedDamagedSprings.add(new DamagedSpring(damagedSpring.position + 1, damagedSpring.length));
            } else {
                shiftedDamagedSprings.add(new DamagedSpring(damagedSpring.position, damagedSpring.length));
            }
        }
        return shiftedDamagedSprings;

    }

    /**
     * Parses the input row
     *
     * @param conditionRow input row
     */
    private void parseConditionRow(String conditionRow) {

        String[] parts = conditionRow.split(" ");
        this.condition = parts[0];
        this.rowLength = condition.length();
        String[] damagedSpringsString = parts[1].split(",");
        int pos = 1;
        for (String damagedSpringString : damagedSpringsString) {
            int length = Integer.parseInt(damagedSpringString);
            this.damagedSprings.add(new DamagedSpring(pos, length));
            pos += length + 1;
        }
    }

    /**
     * Parses the input row
     *
     * @param conditionRow input row
     */
    private void parseConditionRowAndFold(String conditionRow, int numOfFolding) {

        String[] parts = conditionRow.split(" ");
        this.condition = fold(numOfFolding, parts[0], "?");
        this.rowLength = condition.length();
        String damagedSpringsStringFolded = fold(5, parts[1], ",");
        String[] damagedSpringsStrings = damagedSpringsStringFolded.split(",");

        int pos = 1;
        for (String damagedSpringString : damagedSpringsStrings) {
            int length = Integer.parseInt(damagedSpringString);
            this.damagedSprings.add(new DamagedSpring(pos, length));
            pos += length + 1;
        }
    }

    private String fold(int numOfFolding, String conditionUnfolded, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < numOfFolding - 1; j++) {
            sb.append(conditionUnfolded);
            sb.append(separator);
        }
        sb.append(conditionUnfolded);
        return sb.toString();
    }

}
