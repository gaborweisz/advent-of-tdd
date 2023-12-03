package org.advent.day3;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestEngineShould {

    @Test
    void parse_parts_from_the_input() {

        List<String> input = List.of(
                "467..114..",
                "...*......",
                "..35..633.",
                ".........1");

        Engine engine = new Engine(input);
        engine.parseParts();

        MatcherAssert.assertThat(engine.parts.size(), equalTo(5));
        MatcherAssert.assertThat(engine.parts.get(0).number , equalTo(467));
        MatcherAssert.assertThat(engine.parts.get(0).startPos , equalTo(0));
        MatcherAssert.assertThat(engine.parts.get(0).endPos , equalTo(2));
        MatcherAssert.assertThat(engine.parts.get(0).valid , equalTo(true));

        MatcherAssert.assertThat(engine.parts.get(1).number , equalTo(114));
        MatcherAssert.assertThat(engine.parts.get(1).startPos , equalTo(5));
        MatcherAssert.assertThat(engine.parts.get(1).endPos , equalTo(7));
        MatcherAssert.assertThat(engine.parts.get(1).lineNumber , equalTo(1));
        MatcherAssert.assertThat(engine.parts.get(1).valid , equalTo(false));

        MatcherAssert.assertThat(engine.parts.get(2).number , equalTo(35));
        MatcherAssert.assertThat(engine.parts.get(2).startPos , equalTo(2));
        MatcherAssert.assertThat(engine.parts.get(2).endPos , equalTo(3));
        MatcherAssert.assertThat(engine.parts.get(2).lineNumber , equalTo(3));
        MatcherAssert.assertThat(engine.parts.get(2).valid , equalTo(true));

        MatcherAssert.assertThat(engine.parts.get(3).number , equalTo(633));
        MatcherAssert.assertThat(engine.parts.get(3).startPos , equalTo(6));
        MatcherAssert.assertThat(engine.parts.get(3).endPos , equalTo(8));
        MatcherAssert.assertThat(engine.parts.get(3).lineNumber , equalTo(3));
        MatcherAssert.assertThat(engine.parts.get(3).valid , equalTo(false));

        MatcherAssert.assertThat(engine.parts.get(4).number , equalTo(1));
        MatcherAssert.assertThat(engine.parts.get(4).startPos , equalTo(9));
        MatcherAssert.assertThat(engine.parts.get(4).endPos , equalTo(9));
        MatcherAssert.assertThat(engine.parts.get(4).lineNumber , equalTo(4));
        MatcherAssert.assertThat(engine.parts.get(4).valid , equalTo(false));
    }

    @Test
    void find_gears_from_the_input() {

        List<String> input = List.of(
                "467..114..",
                "...*......",
                "..35..633.",
                ".........1");

        Engine engine = new Engine(input);
        engine.parseParts();
        engine.parseGears();

        MatcherAssert.assertThat(engine.parts.size(), equalTo(5));
        MatcherAssert.assertThat(engine.gears.size(), equalTo(1));
        MatcherAssert.assertThat(engine.gears.get("2_3").size(), equalTo(2));
        Part p1 = (Part) engine.gears.get("2_3").toArray()[0];
        MatcherAssert.assertThat(p1.number, equalTo(35));
        Part p2 = (Part) engine.gears.get("2_3").toArray()[1];
        MatcherAssert.assertThat(p2.number, equalTo(467));
    }

}
