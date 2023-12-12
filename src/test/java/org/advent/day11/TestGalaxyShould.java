package org.advent.day11;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestGalaxyShould {

    @Test
    void calculate_the_distance_to_an_other_galaxy() {
        List<String> input = List.of(
                "...#......",
                ".......#..",
                "#.........",
                "..........",
                "......#...",
                ".#........",
                ".........#",
                "..........",
                ".......#..",
                "#...#.....");

        Observatory o = new Observatory(input);

        Galaxy g1 = new Galaxy(0, 3);
        Galaxy g2 = new Galaxy(8, 7);

        MatcherAssert.assertThat(g1.distanceTo(g2, o, 1), org.hamcrest.Matchers.equalTo(15));


        Galaxy g3 = new Galaxy(2, 0);
        Galaxy g4 = new Galaxy(6, 9);

        MatcherAssert.assertThat(g3.distanceTo(g4, o, 1), org.hamcrest.Matchers.equalTo(17));

    }

}
