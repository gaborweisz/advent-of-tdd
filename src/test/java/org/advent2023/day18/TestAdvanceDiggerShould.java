package org.advent2023.day18;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestAdvanceDiggerShould {

    @Test
    void parse_the_dig_plan() {

        List<String> input = List.of(
                "R 6 (#70c710)",
                "D 5 (#0dc571)",
                "L 2 (#5713f0)",
                "D 2 (#d2c081)",
                "R 2 (#59c680)",
                "D 2 (#411b91)",
                "L 5 (#8ceee2)",
                "U 2 (#caa173)",
                "L 1 (#1b58a2)",
                "U 2 (#caa171)",
                "R 2 (#7807d2)",
                "U 3 (#a77fa3)",
                "L 2 (#015232)",
                "U 2 (#7a21e3)");

        AdvancedDigger digger = new AdvancedDigger(input);

        MatcherAssert.assertThat(digger.steps.size(), equalTo(14));
        MatcherAssert.assertThat(digger.steps.get(0).direction, equalTo('R'));
        MatcherAssert.assertThat(digger.steps.get(0).steps, equalTo(461937));
        MatcherAssert.assertThat(digger.steps.get(13).direction, equalTo('U'));
        MatcherAssert.assertThat(digger.steps.get(13).steps, equalTo(500254));

    }


    @Test
    void dig_calculate_size() {

        List<String> input = List.of(
                "R 6 (#70c710)",
                "D 5 (#0dc571)",
                "L 2 (#5713f0)",
                "D 2 (#d2c081)",
                "R 2 (#59c680)",
                "D 2 (#411b91)",
                "L 5 (#8ceee2)",
                "U 2 (#caa173)",
                "L 1 (#1b58a2)",
                "U 2 (#caa171)",
                "R 2 (#7807d2)",
                "U 3 (#a77fa3)",
                "L 2 (#015232)",
                "U 2 (#7a21e3)");


        AdvancedDigger digger = new AdvancedDigger(input);

        double capacity = digger.calculateTrenchCapacity();

        System.out.printf("Capacity: %.0f \n" , capacity);
        System.out.printf("Diff : %.0f \n" ,  952408144115.0 - capacity);

        MatcherAssert.assertThat(capacity, equalTo(952408144115.0));
    }
}
