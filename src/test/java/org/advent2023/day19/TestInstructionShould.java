package org.advent2023.day19;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestInstructionShould {

    @Test
    void process_part1() {

        Part part = Part.parse("{x=787,m=2655,a=1222,s=2876}");
        Instruction instruction = new Instruction("a<2006:qkq");

        MatcherAssert.assertThat(instruction.processPart(part), equalTo("qkq"));
    }

    @Test
    void process_part2() {

        Part part = Part.parse("{x=787,m=2655,a=1222,s=2876}");
        Instruction instruction = new Instruction("m>2090:A");

        MatcherAssert.assertThat(instruction.processPart(part), equalTo("A"));
    }

    @Test
    void process_part3() {

        Part part = Part.parse("{x=787,m=2655,a=1222,s=2876}");
        Instruction instruction = new Instruction("rfg");

        MatcherAssert.assertThat(instruction.processPart(part), equalTo("rfg"));
    }

    @Test
    void process_part4() {

        Part part = Part.parse("{x=787,m=2655,a=1222,s=2876}");
        Instruction instruction = new Instruction("m>9999:abc");

        MatcherAssert.assertThat(instruction.processPart(part), equalTo(null));
    }

}
