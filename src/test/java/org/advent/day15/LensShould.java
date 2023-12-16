package org.advent.day15;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class LensShould {

    @Test
    void parse_the_input_and_create_lens() {
        Lens lens = new Lens("rn=1");

        MatcherAssert.assertThat(lens.id, equalTo("rn"));
        MatcherAssert.assertThat(lens.focalLength, equalTo(1));
    }
}
