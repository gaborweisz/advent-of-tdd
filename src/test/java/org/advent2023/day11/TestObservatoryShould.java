package org.advent2023.day11;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestObservatoryShould {

    @Test
    void read_the_galaxy_map_on_construction() {

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
        MatcherAssert.assertThat(o.galaxyMap.length, equalTo(10));
        MatcherAssert.assertThat(o.galaxyMap[0].length, equalTo(10));

    }

    @Test
    void identify_the_galaxies_on_construction() {

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
            MatcherAssert.assertThat(o.galaxies.size(), equalTo(9));

            //first and last galaxies on expanded galaxy map
            MatcherAssert.assertThat(o.galaxies.get(0).posX, equalTo(0));
            MatcherAssert.assertThat(o.galaxies.get(0).posY, equalTo(3));
            MatcherAssert.assertThat(o.galaxies.get(8).posX, equalTo(9));
            MatcherAssert.assertThat(o.galaxies.get(8).posY, equalTo(4));

    }

    @Test
    void calculate_the_distance_between_galaxies() {

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
        MatcherAssert.assertThat(o.calculateTheSumDistancesOfAllGalaxyPairs(1), equalTo(374.0));

    }

    @Test
    void calculate_the_distance_between_galaxies_factor_10() {

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
        MatcherAssert.assertThat(o.calculateTheSumDistancesOfAllGalaxyPairs(10), equalTo(1030.0));

    }

    @Test
    void calculate_the_distance_between_galaxies_factor_100() {

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
        MatcherAssert.assertThat(o.calculateTheSumDistancesOfAllGalaxyPairs(100), equalTo(8410.0));

    }

}
