package org.advent2023.day6;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestBoatShould {

    @Test
    void calculate_the_distance_based_on_charge_and_time() {

        Boat boat = new Boat(7, 9);

        MatcherAssert.assertThat(boat.travelDistance(0), equalTo(0.0));
        MatcherAssert.assertThat(boat.travelDistance(1), equalTo(6.0));
        MatcherAssert.assertThat(boat.travelDistance(2), equalTo(10.0));
        MatcherAssert.assertThat(boat.travelDistance(3), equalTo(12.0));
        MatcherAssert.assertThat(boat.travelDistance(4), equalTo(12.0));
        MatcherAssert.assertThat(boat.travelDistance(5), equalTo(10.0));
        MatcherAssert.assertThat(boat.travelDistance(6), equalTo(6.0));
        MatcherAssert.assertThat(boat.travelDistance(7), equalTo(0.0));
        MatcherAssert.assertThat(boat.travelDistance(7), equalTo(0.0));
    }

    @Test
    void calculate_the_number_of_ways_teh_record_can_be_beaten() {

        Boat boat = new Boat(7, 9);

        MatcherAssert.assertThat(boat.numberOfWaysToBeatTheRecord(), equalTo(4.0));
    }

}
