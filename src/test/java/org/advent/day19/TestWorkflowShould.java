package org.advent.day19;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestWorkflowShould {

    @Test
    void process_workflow_string() {

        Workflow workflow = Workflow.parse("px{a<2006:qkq,m>2090:A,rfg}");

        MatcherAssert.assertThat(workflow.id, equalTo("px"));
        MatcherAssert.assertThat(workflow.instructions.get(0).instruction, equalTo("a<2006:qkq"));
        MatcherAssert.assertThat(workflow.instructions.get(1).instruction, equalTo("m>2090:A"));
        MatcherAssert.assertThat(workflow.instructions.get(2).instruction, equalTo("rfg"));
    }
}
