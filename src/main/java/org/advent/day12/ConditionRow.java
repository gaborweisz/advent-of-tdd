package org.advent.day12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConditionRow {

    String condition;
    int rowLength;
    List<DamagedSpring> damagedSprings = new ArrayList<>();
    List<List<DamagedSpring>> damagedSpringLists = new ArrayList<>();
    Set<String> variations = new HashSet<>();

    public ConditionRow(String conditionRow) {
        parseConditionRow(conditionRow);
        calculateVariations();
    }

    public int calculateArrangements() {
        for (List<DamagedSpring> damagedSpringList : damagedSpringLists) {
            String pattern = getVariationPattern(damagedSpringList);
            if (matchVariationPattern(pattern)) {
                variations.add(pattern);
            }
        }
        return variations.size();
    }

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

        System.out.println("Pattern: " + pattern + " Condition: " + condition);
        return true;
    }

    private String getVariationPattern(List<DamagedSpring> damagedSpringList) {
        StringBuilder pattern = new StringBuilder();
        int shift = 1;
        for (DamagedSpring damagedSpring : damagedSpringList) {
            pattern.append(".".repeat(damagedSpring.position - shift)).append("#".repeat(damagedSpring.length));
            shift = pattern.length() + 1;
        }
        return pattern.toString();
    }

    public void calculateVariations() {

        damagedSpringLists.add(damagedSprings);
        nextArrangement(damagedSprings);

        for (List<DamagedSpring> damagedSpringList : damagedSpringLists) {
            //System.out.println(getVariationPattern(damagedSpringList));
        }
    }

    public List<DamagedSpring> nextArrangement(List<DamagedSpring> currentDamagedSprings) {

        for (int i = currentDamagedSprings.size()-1; i >=0 ;i--) {

            DamagedSpring damagedSpring = currentDamagedSprings.get(i);
            List<DamagedSpring> shiftedDamagedSprings = shiftPositions(currentDamagedSprings, damagedSpring.position);

            int length = calculateLength(shiftedDamagedSprings);

            if (length > this.rowLength) {
                return null;
            } else {
                damagedSpringLists.add(shiftedDamagedSprings);
                nextArrangement(shiftedDamagedSprings);
            }
        }
        return damagedSprings;
    }

    public int calculateLength(List<DamagedSpring> damagedSprings) {
        DamagedSpring lastDamagedSpring = damagedSprings.get(damagedSprings.size() - 1);

        return lastDamagedSpring.position + lastDamagedSpring.length - 1;
    }

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

}
