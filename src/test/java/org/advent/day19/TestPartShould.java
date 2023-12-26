package org.advent.day19;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestPartShould {

    @Test
    void process_part_string() {

        Part part = Part.parse("{x=787,m=2655,a=1222,s=2876}");

        MatcherAssert.assertThat(part.partMap.get("x"), equalTo(787));
        MatcherAssert.assertThat(part.partMap.get("m"), equalTo(2655));
        MatcherAssert.assertThat(part.partMap.get("a"), equalTo(1222));
        MatcherAssert.assertThat(part.partMap.get("s"), equalTo(2876));

    }

    @Test
    void sum() {

        Part part = Part.parse("{x=787,m=2655,a=1222,s=2876}");

        MatcherAssert.assertThat(part.sum(), equalTo(7540));
    }
}
