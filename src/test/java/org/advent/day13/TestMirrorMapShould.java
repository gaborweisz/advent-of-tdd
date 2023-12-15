package org.advent.day13;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import util.MatrixUtil;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestMirrorMapShould {
    @Test
    void calculate_example1() {

        List<String> input = List.of(
                "#.##.#.##.#" ,
                ".####.####." ,
                ".####.####." ,
                ".#..#.#...." ,
                "#.##.#.##.#" ,
                "#....#....#" ,
                "##..###..##");

        MatcherAssert.assertThat(MirrorMap.countRows(input), equalTo(3));
        MatcherAssert.assertThat(MirrorMap.countRowsAfterFixingSmudge(input), equalTo(8));

    }

    @Test
    void calculate_exmaple2() {

        List<String> input = List.of(
                "###.###.#.#" ,
                "...##......" ,
                "..#########" ,
                "###.#......" ,
                "##....#####" ,
                "......#..##" ,
                "###....#..." ,
                "...##....##" ,
                "##...#..###");

        MatcherAssert.assertThat(MirrorMap.countRows(input), equalTo(1));
        MatcherAssert.assertThat(MirrorMap.countRowsAfterFixingSmudge(input), equalTo(10));

    }
    
    
   

}
