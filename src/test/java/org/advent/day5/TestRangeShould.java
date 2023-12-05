package org.advent.day5;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestRangeShould {

    @Test
    void parse_ranges() {
        List<String> input = List.of(
                "seeds: 79 14 55 13",
                "",
                "seed-to-soil map:",
                "50 98 2",
                "52 50 48");

        Range range = new Range(input.get(3));

        MatcherAssert.assertThat(range.destinationRange, equalTo(50.0));
        MatcherAssert.assertThat(range.sourceRange, equalTo(98.0));
        MatcherAssert.assertThat(range.rangeLength, equalTo(2.0));

    }
}
