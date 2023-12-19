package org.advent.day12;

import java.util.ArrayList;
import java.util.List;

public class ConditionRecord {

    List<ConditionRow> conditionRows = new ArrayList<>();

    public ConditionRecord(List<String> rows) {
        for (String row : rows) {
            conditionRows.add(new ConditionRow(row));
        }
    }

    /**
     * Calculates the solution for puzzle a
     *
     * @return solution
     */
    public int calculateArrangements() {
        int arrangements = 0    ;
        for (ConditionRow conditionRow : conditionRows) {
            arrangements += conditionRow.calculateArrangements();
        }

        return arrangements;
    }
}
