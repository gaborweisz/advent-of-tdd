package org.advent.day8;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestDesertMapShould {

    @Test
    void calculate_the_solution_for_puzzle_a() {

        List<String> input1 = List.of(
                "RL",
                "",
                "AAA = (BBB, CCC)",
                "BBB = (DDD, EEE)",
                "CCC = (ZZZ, GGG)",
                "DDD = (DDD, DDD)",
                "EEE = (EEE, EEE)",
                "GGG = (GGG, GGG)",
                "ZZZ = (ZZZ, ZZZ)");

        DesertMap map = new DesertMap(input1);

        MatcherAssert.assertThat(map.instructions, equalTo("RL"));
        MatcherAssert.assertThat(map.nodeMap.size(), equalTo(7));
        MatcherAssert.assertThat(map.nodeMap.get("AAA").id, equalTo("AAA"));
        MatcherAssert.assertThat(map.nodeMap.get("AAA").left, equalTo("BBB"));
        MatcherAssert.assertThat(map.nodeMap.get("AAA").right, equalTo("CCC"));
        MatcherAssert.assertThat(map.nodeMap.get("BBB").id, equalTo("BBB"));
        MatcherAssert.assertThat(map.nodeMap.get("BBB").left, equalTo("DDD"));
        MatcherAssert.assertThat(map.nodeMap.get("BBB").right, equalTo("EEE"));
        MatcherAssert.assertThat(map.nodeMap.get("CCC").id, equalTo("CCC"));
        MatcherAssert.assertThat(map.nodeMap.get("CCC").left, equalTo("ZZZ"));
        MatcherAssert.assertThat(map.nodeMap.get("CCC").right, equalTo("GGG"));
        MatcherAssert.assertThat(map.nodeMap.get("DDD").id, equalTo("DDD"));
        MatcherAssert.assertThat(map.nodeMap.get("DDD").left, equalTo("DDD"));
        MatcherAssert.assertThat(map.nodeMap.get("DDD").right, equalTo("DDD"));
        MatcherAssert.assertThat(map.nodeMap.get("EEE").id, equalTo("EEE"));
        MatcherAssert.assertThat(map.nodeMap.get("EEE").left, equalTo("EEE"));
        MatcherAssert.assertThat(map.nodeMap.get("EEE").right, equalTo("EEE"));
        MatcherAssert.assertThat(map.nodeMap.get("GGG").id, equalTo("GGG"));
        MatcherAssert.assertThat(map.nodeMap.get("GGG").left, equalTo("GGG"));
        MatcherAssert.assertThat(map.nodeMap.get("GGG").right, equalTo("GGG"));
        MatcherAssert.assertThat(map.nodeMap.get("ZZZ").id, equalTo("ZZZ"));
        MatcherAssert.assertThat(map.nodeMap.get("ZZZ").left, equalTo("ZZZ"));
        MatcherAssert.assertThat(map.nodeMap.get("ZZZ").right, equalTo("ZZZ"));
    }

    @Test
    void get_the_starting_keys() {

        List<String> input1 = List.of(
                "LR",
                "",
                "11A = (11B, XXX)",
                "11B = (XXX, 11Z)",
                "11Z = (11B, XXX)",
                "22A = (22B, XXX)",
                "22B = (22C, 22C)",
                "22C = (22Z, 22Z)",
                "22Z = (22B, 22B)",
                "XXX = (XXX, XXX)");

        DesertMap map = new DesertMap(input1);
        List<Node> startingKeys = map.getStartingNodes();

        MatcherAssert.assertThat(startingKeys.size(), equalTo(2));
        MatcherAssert.assertThat(startingKeys.get(0).id, equalTo("11A"));
        MatcherAssert.assertThat(startingKeys.get(1).id, equalTo("22A"));
    }

    @Test
    void get_the_end_state() {

        List<String> input1 = List.of(
                "LR",
                "",
                "11A = (11B, XXX)",
                "11B = (XXX, 11Z)",
                "11Z = (11B, XXX)",
                "22A = (22B, XXX)",
                "22B = (22C, 22C)",
                "22C = (22Z, 22Z)",
                "22Z = (22B, 22B)",
                "XXX = (XXX, XXX)");

        DesertMap map = new DesertMap(input1);

        List<Node> keys = List.of(
                new Node("11A", "11B", "XXX"),
                new Node("11B", "XXX", "11Z"),
                new Node("11Z", "11B", "XXX"),
                new Node("22A", "22B", "XXX"),
                new Node("22B", "22C", "22C"),
                new Node("22C", "22Z", "22Z"),
                new Node("22Z", "22B", "22B"),
                new Node("XXX", "XXX", "XXX")
        );

        MatcherAssert.assertThat(map.allEndsWithZ(keys),equalTo(false));

        List<Node> keys2 = List.of(
                new Node("11Z", "11B", "XXX"),
                new Node("11Z", "XXX", "11Z"),
                new Node("11Z", "11B", "XXX"),
                new Node("22Z", "22B", "XXX"),
                new Node("22Z", "22C", "22C"),
                new Node("22Z", "22Z", "22Z"),
                new Node("22Z", "22B", "22B"),
                new Node("XXZ", "XXX", "XXX")
        );

        MatcherAssert.assertThat(map.allEndsWithZ(keys2),equalTo(true));
    }
}
