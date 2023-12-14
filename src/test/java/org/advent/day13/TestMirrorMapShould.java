package org.advent.day13;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import util.MatrixUtil;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestMirrorMapShould {
    @Test
    void calculate_theb() {

        List<String> input = List.of(
                "#.##.#.##.#" +
                ".####.####." +
                ".####.####." +
                ".#..#.#...." +
                "#.##.#.##.#" +
                "#....#....#" +
                "##..###..##");

        MatcherAssert.assertThat(MirrorMap.countRows(input), equalTo(400.0));
        MatcherAssert.assertThat(MirrorMap.countRowsAfterFixingSmudge(input), equalTo(400.0));

    }

}
