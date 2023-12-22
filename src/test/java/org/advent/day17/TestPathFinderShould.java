package org.advent.day17;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestPathFinderShould {

    @Test
    void parse_the_input() {

        List<String> input = List.of(
                "2413432311323",
                "3215453535623",
                "3255245654254",
                "3446585845452",
                "4546657867536",
                "1438598798454",
                "4457876987766",
                "3637877979653",
                "4654967986887",
                "4564679986453",
                "1224686865563",
                "2546548887735",
                "4322674655533");

        PathFinder pathFinder = new PathFinder(input);

        MatcherAssert.assertThat(pathFinder.heatMap.length, equalTo(13));
        MatcherAssert.assertThat(pathFinder.heatMap[0].length, equalTo(13));
    }
}
