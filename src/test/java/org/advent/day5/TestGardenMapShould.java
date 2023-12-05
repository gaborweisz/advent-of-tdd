package org.advent.day5;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestGardenMapShould {

    @Test
    void parse_ids() {
        List<String> input = List.of(
                "seeds: 79 14 55 13",
                "",
                "seed-to-soil map:",
                "50 98 2",
                "52 50 48");

        GardenMap map = new GardenMap(input.get(2));

        MatcherAssert.assertThat(map.name, equalTo("seed-to-soil"));
        MatcherAssert.assertThat(map.destinationId, equalTo("soil"));
        MatcherAssert.assertThat(map.sourceId, equalTo("seed"));

    }

    @Test
    void add_ranges() {
        List<String> input = List.of(
                "seeds: 79 14 55 13",
                "",
                "seed-to-soil map:",
                "50 98 2",
                "52 50 48");

        GardenMap map = new GardenMap(input.get(2));
        map.addRange(input.get(3));
        map.addRange(input.get(4));

        MatcherAssert.assertThat(map.ranges.size(), equalTo(2));
        MatcherAssert.assertThat(map.ranges.get(0).destinationRange, equalTo(50.0));
        MatcherAssert.assertThat(map.ranges.get(0).sourceRange, equalTo(98.0));
        MatcherAssert.assertThat(map.ranges.get(0).rangeLength, equalTo(2.0));
        MatcherAssert.assertThat(map.ranges.get(1).destinationRange, equalTo(52.0));
        MatcherAssert.assertThat(map.ranges.get(1).sourceRange, equalTo(50.0));
        MatcherAssert.assertThat(map.ranges.get(1).rangeLength, equalTo(48.0));

    }

    @Test
    void add_get_corresponding_number() {
        List<String> input = List.of(
                "seeds: 79 14 55 13",
                "",
                "seed-to-soil map:",
                "50 98 2",
                "52 50 48");

        GardenMap map = new GardenMap(input.get(2));
        map.addRange(input.get(3));
        map.addRange(input.get(4));

        MatcherAssert.assertThat(map.getCorrespondingNumber(98.0), equalTo(50.0));
        MatcherAssert.assertThat(map.getCorrespondingNumber(79.0), equalTo(81.0));
        MatcherAssert.assertThat(map.getCorrespondingNumber(14.0), equalTo(14.0));
        MatcherAssert.assertThat(map.getCorrespondingNumber(55.0), equalTo(57.0));
        MatcherAssert.assertThat(map.getCorrespondingNumber(13.0), equalTo(13.0));

    }
}
