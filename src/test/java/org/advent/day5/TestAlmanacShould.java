package org.advent.day5;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestAlmanacShould {

    @Test
    void parse_seeds() {

        List<String> input = List.of(
                "seeds: 79 14 55 13",
                "",
                "seed-to-soil map:",
                "50 98 2",
                "52 50 48");

        List<Double> result = Almanac.parseSeeds(input.get(0));

        assert result != null;
        MatcherAssert.assertThat(result.size(), equalTo(4));
        MatcherAssert.assertThat(result.get(0), equalTo(79.0));
        MatcherAssert.assertThat(result.get(1), equalTo(14.0));
        MatcherAssert.assertThat(result.get(2), equalTo(55.0));
        MatcherAssert.assertThat(result.get(3), equalTo(13.0));

        MatcherAssert.assertThat(Almanac.parseSeeds(input.get(1)), equalTo(null));
        MatcherAssert.assertThat(Almanac.parseSeeds(input.get(2)), equalTo(null));
        MatcherAssert.assertThat(Almanac.parseSeeds(input.get(3)), equalTo(null));
        MatcherAssert.assertThat(Almanac.parseSeeds(input.get(4)), equalTo(null));
    }

    @Test
    void parse_seed_range() {

        List<String> input = List.of(
                "seeds: 79 14 55 13",
                "",
                "seed-to-soil map:",
                "50 98 2",
                "52 50 48");

        List<SeedRange> result = Almanac.parseSeedRanges(input.get(0));

        MatcherAssert.assertThat(result.size(), equalTo(2));
        MatcherAssert.assertThat(result.get(0).from, equalTo(79.0));
        MatcherAssert.assertThat(result.get(0).rangeLength, equalTo(14.0));
        MatcherAssert.assertThat(result.get(1).from, equalTo(55.0));
        MatcherAssert.assertThat(result.get(1).rangeLength, equalTo(13.0));

    }

    @Test
    void parse_maps_and_ranges() {

        List<String> input = List.of(
                "seeds: 79 14 55 13",
                "",
                "seed-to-soil map:",
                "50 98 2",
                "52 50 48",
                "",
                "soil-to-fertilizer map:",
                "0 15 37",
                "37 52 2",
                "39 0 15",
                "",
                "fertilizer-to-water map:",
                "49 53 8",
                "0 11 42",
                "42 0 7",
                "57 7 4",
                "",
                "water-to-light map:",
                "88 18 7",
                "18 25 70",
                "",
                "light-to-temperature map:",
                "45 77 23",
                "81 45 19",
                "68 64 13",
                "",
                "temperature-to-humidity map:",
                "0 69 1",
                "1 0 69",
                "",
                "humidity-to-location map:",
                "60 56 37",
                "56 93 4");

        Almanac almanac = new Almanac(input);

        MatcherAssert.assertThat(almanac.seeds.size(), equalTo(4));
        MatcherAssert.assertThat(almanac.maps.size(), equalTo(7));


        MatcherAssert.assertThat(almanac.maps.get("seed-to-soil").ranges.size(), equalTo(2));
        MatcherAssert.assertThat(almanac.maps.get("seed-to-soil").ranges.get(0).destinationRange, equalTo(50.0));
        MatcherAssert.assertThat(almanac.maps.get("seed-to-soil").ranges.get(0).sourceRange, equalTo(98.0));
        MatcherAssert.assertThat(almanac.maps.get("seed-to-soil").ranges.get(0).rangeLength, equalTo(2.0));
        MatcherAssert.assertThat(almanac.maps.get("seed-to-soil").ranges.get(1).destinationRange, equalTo(52.0));
        MatcherAssert.assertThat(almanac.maps.get("seed-to-soil").ranges.get(1).sourceRange, equalTo(50.0));
        MatcherAssert.assertThat(almanac.maps.get("seed-to-soil").ranges.get(1).rangeLength, equalTo(48.0));

        MatcherAssert.assertThat(almanac.maps.get("soil-to-fertilizer").ranges.size(), equalTo(3));
        MatcherAssert.assertThat(almanac.maps.get("soil-to-fertilizer").ranges.get(0).destinationRange, equalTo(0.0));
        MatcherAssert.assertThat(almanac.maps.get("soil-to-fertilizer").ranges.get(0).sourceRange, equalTo(15.0));
        MatcherAssert.assertThat(almanac.maps.get("soil-to-fertilizer").ranges.get(0).rangeLength, equalTo(37.0));
        MatcherAssert.assertThat(almanac.maps.get("soil-to-fertilizer").ranges.get(1).destinationRange, equalTo(37.0));
        MatcherAssert.assertThat(almanac.maps.get("soil-to-fertilizer").ranges.get(1).sourceRange, equalTo(52.0));
        MatcherAssert.assertThat(almanac.maps.get("soil-to-fertilizer").ranges.get(1).rangeLength, equalTo(2.0));
        MatcherAssert.assertThat(almanac.maps.get("soil-to-fertilizer").ranges.get(2).destinationRange, equalTo(39.0));
        MatcherAssert.assertThat(almanac.maps.get("soil-to-fertilizer").ranges.get(2).sourceRange, equalTo(0.0));
        MatcherAssert.assertThat(almanac.maps.get("soil-to-fertilizer").ranges.get(2).rangeLength, equalTo(15.0));

        MatcherAssert.assertThat(almanac.maps.get("fertilizer-to-water").ranges.size(), equalTo(4));
        MatcherAssert.assertThat(almanac.maps.get("fertilizer-to-water").ranges.get(0).destinationRange, equalTo(49.0));
        MatcherAssert.assertThat(almanac.maps.get("fertilizer-to-water").ranges.get(0).sourceRange, equalTo(53.0));
        MatcherAssert.assertThat(almanac.maps.get("fertilizer-to-water").ranges.get(0).rangeLength, equalTo(8.0));
        MatcherAssert.assertThat(almanac.maps.get("fertilizer-to-water").ranges.get(1).destinationRange, equalTo(0.0));
        MatcherAssert.assertThat(almanac.maps.get("fertilizer-to-water").ranges.get(1).sourceRange, equalTo(11.0));
        MatcherAssert.assertThat(almanac.maps.get("fertilizer-to-water").ranges.get(1).rangeLength, equalTo(42.0));
        MatcherAssert.assertThat(almanac.maps.get("fertilizer-to-water").ranges.get(2).destinationRange, equalTo(42.0));
        MatcherAssert.assertThat(almanac.maps.get("fertilizer-to-water").ranges.get(2).sourceRange, equalTo(0.0));
        MatcherAssert.assertThat(almanac.maps.get("fertilizer-to-water").ranges.get(2).rangeLength, equalTo(7.0));
        MatcherAssert.assertThat(almanac.maps.get("fertilizer-to-water").ranges.get(3).destinationRange, equalTo(57.0));
        MatcherAssert.assertThat(almanac.maps.get("fertilizer-to-water").ranges.get(3).sourceRange, equalTo(7.0));
        MatcherAssert.assertThat(almanac.maps.get("fertilizer-to-water").ranges.get(3).rangeLength, equalTo(4.0));

        MatcherAssert.assertThat(almanac.maps.get("water-to-light").ranges.size(), equalTo(2));
        MatcherAssert.assertThat(almanac.maps.get("water-to-light").ranges.get(0).destinationRange, equalTo(88.0));
        MatcherAssert.assertThat(almanac.maps.get("water-to-light").ranges.get(0).sourceRange, equalTo(18.0));
        MatcherAssert.assertThat(almanac.maps.get("water-to-light").ranges.get(0).rangeLength, equalTo(7.0));
        MatcherAssert.assertThat(almanac.maps.get("water-to-light").ranges.get(1).destinationRange, equalTo(18.0));
        MatcherAssert.assertThat(almanac.maps.get("water-to-light").ranges.get(1).sourceRange, equalTo(25.0));
        MatcherAssert.assertThat(almanac.maps.get("water-to-light").ranges.get(1).rangeLength, equalTo(70.0));

        MatcherAssert.assertThat(almanac.maps.get("light-to-temperature").ranges.size(), equalTo(3));
        MatcherAssert.assertThat(almanac.maps.get("light-to-temperature").ranges.get(0).destinationRange, equalTo(45.0));
        MatcherAssert.assertThat(almanac.maps.get("light-to-temperature").ranges.get(0).sourceRange, equalTo(77.0));

    }

    @Test
    void get_corresponding_location_to_a_seed() {

        List<String> input = List.of(
                "seeds: 79 14 55 13",
                "",
                "seed-to-soil map:",
                "50 98 2",
                "52 50 48",
                "",
                "soil-to-fertilizer map:",
                "0 15 37",
                "37 52 2",
                "39 0 15",
                "",
                "fertilizer-to-water map:",
                "49 53 8",
                "0 11 42",
                "42 0 7",
                "57 7 4",
                "",
                "water-to-light map:",
                "88 18 7",
                "18 25 70",
                "",
                "light-to-temperature map:",
                "45 77 23",
                "81 45 19",
                "68 64 13",
                "",
                "temperature-to-humidity map:",
                "0 69 1",
                "1 0 69",
                "",
                "humidity-to-location map:",
                "60 56 37",
                "56 93 4");

        Almanac almanac = new Almanac(input);


        MatcherAssert.assertThat(almanac.getCorrespondingLocation(79.0), equalTo(82.0));
        MatcherAssert.assertThat(almanac.getCorrespondingLocation(14.0), equalTo(43.0));
        MatcherAssert.assertThat(almanac.getCorrespondingLocation(55.0), equalTo(86.0));
        MatcherAssert.assertThat(almanac.getCorrespondingLocation(13.0), equalTo(35.0));
    }

    @Test
    void find_the_lowest_location_number_for_a_seed() {

        List<String> input = List.of(
                "seeds: 79 14 55 13",
                "",
                "seed-to-soil map:",
                "50 98 2",
                "52 50 48",
                "",
                "soil-to-fertilizer map:",
                "0 15 37",
                "37 52 2",
                "39 0 15",
                "",
                "fertilizer-to-water map:",
                "49 53 8",
                "0 11 42",
                "42 0 7",
                "57 7 4",
                "",
                "water-to-light map:",
                "88 18 7",
                "18 25 70",
                "",
                "light-to-temperature map:",
                "45 77 23",
                "81 45 19",
                "68 64 13",
                "",
                "temperature-to-humidity map:",
                "0 69 1",
                "1 0 69",
                "",
                "humidity-to-location map:",
                "60 56 37",
                "56 93 4");

        Almanac almanac = new Almanac(input);


        MatcherAssert.assertThat(almanac.getLowestLocationNumber(), equalTo(35.0));

    }

    @Test
    void find_the_lowest_location_number_for_a_seed_range() {
        List<String> input = List.of(
                "seeds: 79 14 55 13",
                "",
                "seed-to-soil map:",
                "50 98 2",
                "52 50 48",
                "",
                "soil-to-fertilizer map:",
                "0 15 37",
                "37 52 2",
                "39 0 15",
                "",
                "fertilizer-to-water map:",
                "49 53 8",
                "0 11 42",
                "42 0 7",
                "57 7 4",
                "",
                "water-to-light map:",
                "88 18 7",
                "18 25 70",
                "",
                "light-to-temperature map:",
                "45 77 23",
                "81 45 19",
                "68 64 13",
                "",
                "temperature-to-humidity map:",
                "0 69 1",
                "1 0 69",
                "",
                "humidity-to-location map:",
                "60 56 37",
                "56 93 4");
        Almanac almanac = new Almanac(input);

        MatcherAssert.assertThat(almanac.getLowestLocationNumberFromSeedRange(79.0, 14.0), equalTo(46.0));
    }
}
