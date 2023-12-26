package org.advent.day19;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.equalTo;

public class PartProcessorShould {

    @Test
    void process_parts_from_input() {

        List<String> input = List.of(
                "px{a<2006:qkq,m>2090:A,rfg}",
                "pv{a>1716:R,A}",
                "lnx{m>1548:A,A}",
                "rfg{s<537:gd,x>2440:R,A}",
                "qs{s>3448:A,lnx}",
                "qkq{x<1416:A,crn}",
                "crn{x>2662:A,R}",
                "in{s<1351:px,qqz}",
                "qqz{s>2770:qs,m<1801:hdj,R}",
                "gd{a>3333:R,R}",
                "hdj{m>838:A,pv}",
                "",
                "{x=787,m=2655,a=1222,s=2876}",
                "{x=1679,m=44,a=2067,s=496}",
                "{x=2036,m=264,a=79,s=2244}",
                "{x=2461,m=1339,a=466,s=291}",
                "{x=2127,m=1623,a=2188,s=1013}");

        PartProcessor processor = new PartProcessor(input);

        MatcherAssert.assertThat(processor.parts.size(), equalTo(5));

        MatcherAssert.assertThat(processor.parts.get(0).partMap.get("x"), equalTo(787));
        MatcherAssert.assertThat(processor.parts.get(0).partMap.get("m"), equalTo(2655));
        MatcherAssert.assertThat(processor.parts.get(0).partMap.get("a"), equalTo(1222));
        MatcherAssert.assertThat(processor.parts.get(0).partMap.get("s"), equalTo(2876));

        MatcherAssert.assertThat(processor.parts.get(1).partMap.get("x"), equalTo(1679));
        MatcherAssert.assertThat(processor.parts.get(1).partMap.get("m"), equalTo(44));
        MatcherAssert.assertThat(processor.parts.get(1).partMap.get("a"), equalTo(2067));
        MatcherAssert.assertThat(processor.parts.get(1).partMap.get("s"), equalTo(496));

        MatcherAssert.assertThat(processor.parts.get(2).partMap.get("x"), equalTo(2036));
        MatcherAssert.assertThat(processor.parts.get(2).partMap.get("m"), equalTo(264));
        MatcherAssert.assertThat(processor.parts.get(2).partMap.get("a"), equalTo(79));
        MatcherAssert.assertThat(processor.parts.get(2).partMap.get("s"), equalTo(2244));

        MatcherAssert.assertThat(processor.parts.get(3).partMap.get("x"), equalTo(2461));
        MatcherAssert.assertThat(processor.parts.get(3).partMap.get("m"), equalTo(1339));
        MatcherAssert.assertThat(processor.parts.get(3).partMap.get("a"), equalTo(466));
        MatcherAssert.assertThat(processor.parts.get(3).partMap.get("s"), equalTo(291));

        MatcherAssert.assertThat(processor.parts.get(4).partMap.get("x"), equalTo(2127));
        MatcherAssert.assertThat(processor.parts.get(4).partMap.get("m"), equalTo(1623));
        MatcherAssert.assertThat(processor.parts.get(4).partMap.get("a"), equalTo(2188));
        MatcherAssert.assertThat(processor.parts.get(4).partMap.get("s"), equalTo(1013));
    }


    @Test
    void process_workflows_from_input() {

        List<String> input = List.of(
                "px{a<2006:qkq,m>2090:A,rfg}",
                "pv{a>1716:R,A}",
                "lnx{m>1548:A,A}",
                "rfg{s<537:gd,x>2440:R,A}",
                "qs{s>3448:A,lnx}",
                "qkq{x<1416:A,crn}",
                "crn{x>2662:A,R}",
                "in{s<1351:px,qqz}",
                "qqz{s>2770:qs,m<1801:hdj,R}",
                "gd{a>3333:R,R}",
                "hdj{m>838:A,pv}",
                "",
                "{x=787,m=2655,a=1222,s=2876}",
                "{x=1679,m=44,a=2067,s=496}",
                "{x=2036,m=264,a=79,s=2244}",
                "{x=2461,m=1339,a=466,s=291}",
                "{x=2127,m=1623,a=2188,s=1013}");

        PartProcessor processor = new PartProcessor(input);

        MatcherAssert.assertThat(processor.workflows.size(), equalTo(11));

        MatcherAssert.assertThat(processor.workflows.get("px").id, equalTo("px"));
        MatcherAssert.assertThat(processor.workflows.get("px").instructions.size(), equalTo(3));
        MatcherAssert.assertThat(processor.workflows.get("px").instructions.get(0).instruction, equalTo("a<2006:qkq"));
        MatcherAssert.assertThat(processor.workflows.get("px").instructions.get(1).instruction, equalTo("m>2090:A"));
        MatcherAssert.assertThat(processor.workflows.get("px").instructions.get(2).instruction, equalTo("rfg"));

        MatcherAssert.assertThat(processor.workflows.get("hdj").id, equalTo("hdj"));
        MatcherAssert.assertThat(processor.workflows.get("hdj").instructions.size(), equalTo(2));
        MatcherAssert.assertThat(processor.workflows.get("hdj").instructions.get(0).instruction, equalTo("m>838:A"));
        MatcherAssert.assertThat(processor.workflows.get("hdj").instructions.get(1).instruction, equalTo("pv"));
    }

    @Test
    void process_process_parts() {

        List<String> input = List.of(
                "px{a<2006:qkq,m>2090:A,rfg}",
                "pv{a>1716:R,A}",
                "lnx{m>1548:A,A}",
                "rfg{s<537:gd,x>2440:R,A}",
                "qs{s>3448:A,lnx}",
                "qkq{x<1416:A,crn}",
                "crn{x>2662:A,R}",
                "in{s<1351:px,qqz}",
                "qqz{s>2770:qs,m<1801:hdj,R}",
                "gd{a>3333:R,R}",
                "hdj{m>838:A,pv}",
                "",
                "{x=787,m=2655,a=1222,s=2876}",
                "{x=1679,m=44,a=2067,s=496}",
                "{x=2036,m=264,a=79,s=2244}",
                "{x=2461,m=1339,a=466,s=291}",
                "{x=2127,m=1623,a=2188,s=1013}");

        PartProcessor processor = new PartProcessor(input);
        processor.process();

        MatcherAssert.assertThat(processor.parts.size(), equalTo(5));

        MatcherAssert.assertThat(processor.parts.get(0).state, equalTo(Part.State.ACCEPTED));
        MatcherAssert.assertThat(processor.parts.get(1).state, equalTo(Part.State.REJECTED));
        MatcherAssert.assertThat(processor.parts.get(2).state, equalTo(Part.State.ACCEPTED));
        MatcherAssert.assertThat(processor.parts.get(3).state, equalTo(Part.State.REJECTED));
        MatcherAssert.assertThat(processor.parts.get(4).state, equalTo(Part.State.ACCEPTED));
    }


}
