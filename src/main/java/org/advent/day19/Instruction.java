package org.advent.day19;

/**
 * Instruction
 * a<2006:qkq
 * m>2090:A
 * rfg
 */

public class Instruction {

    String instruction;

    public Instruction(String instruction) {
        this.instruction = instruction;
    }


    /**
     * Process a part
     * e.g. a<2006:qkq
     *
     * @param part part to process
     * @return new instruction id if condition is true, null otherwise; new instruction can be A - accepted, R rejected or the id of the next workflow
     */

    String processPart(Part part) {
        if (instruction.contains(":")) {
            return processCondition(part);
        } else {
            return instruction;
        }
    }

    /**
     * Process a condition
     * e.g. a<2006:qkq
     *
     * @param part condition to process
     * @return instruction id if condition is true, null otherwise
     */
    private String processCondition(Part part) {
        String[] parts = instruction.split(":");
        String condition = parts[0];
        String instructionId = parts[1];

        String[] conditionParts = condition.split("[<>]");
        String partId = conditionParts[0];
        int conditionValue = Integer.parseInt(conditionParts[1]);
        int partValue = part.get(partId);

        if (condition.contains("<")) {
            if (partValue < conditionValue) {
                return instructionId;
            }
        } else {
            if (partValue > conditionValue) {
                return instructionId;
            }
        }

        return null;
    }


}
