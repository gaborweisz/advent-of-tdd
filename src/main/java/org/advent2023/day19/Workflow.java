package org.advent2023.day19;

import java.util.List;

/**
 * Represents a workflow of instructions
 * e.g.   px{a<2006:qkq,m>2090:A,rfg}
 */
public class Workflow {

    String id;
    List<Instruction> instructions = new java.util.ArrayList<>();

    public Workflow() {
    }

    static Workflow parse(String workflowString) {
        Workflow w = new Workflow();

        workflowString = workflowString.replace("}", "");
        workflowString = workflowString.replace("{", "-");

        String[] parts = workflowString.split("-");
        w.id = parts[0];

        String[] instructionStrings = parts[1].split(",");

        for (String instructionString : instructionStrings) {
            w.instructions.add(new Instruction(instructionString));
        }

        return w;
    }
}
