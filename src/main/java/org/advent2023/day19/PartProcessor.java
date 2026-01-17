package org.advent2023.day19;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartProcessor {

    List<Part> parts = new java.util.ArrayList<>();
    Map<String , Workflow> workflows = new HashMap<>();

    public PartProcessor(List<String> input) {
        parse(input);
    }

    void process() {

        for (Part part : parts) {

            Workflow workflow = workflows.get("in");
            while (part.state == Part.State.NONE) {
                for (Instruction instruction : workflow.instructions) {
                    String result = instruction.processPart(part);

                    if (result != null) {
                        if (result.equals("A")) {
                            part.state = Part.State.ACCEPTED;
                            break;
                        } else if (result.equals("R")) {
                            part.state = Part.State.REJECTED;
                            break;
                        } else {
                            //continue with next workflow
                            workflow = workflows.get(result);
                            break;
                        }
                    }
                }
            }
        }

    }

    private void parse(List<String> input) {
        boolean isPart = false;
        for (String line : input) {
            if (line.isBlank()) {
                isPart = true;
                continue;
            }
            if (isPart) {
                parts.add(Part.parse(line));
            } else {
                Workflow workflow = Workflow.parse(line);
                workflows.put(workflow.id, workflow);
            }
        }
    }

}
