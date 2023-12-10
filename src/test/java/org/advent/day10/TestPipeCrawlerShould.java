package org.advent.day10;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestPipeCrawlerShould {

    @Test
    void find_the_start_position() {

        List<String> input = List.of(
                ".....",
                ".S-7.",
                ".|.|.",
                ".L-J.",
                ".....");


        PipeCrawler crawler = new PipeCrawler(input);

        MatcherAssert.assertThat(crawler.posI, equalTo(1));
        MatcherAssert.assertThat(crawler.posJ, equalTo(2));

    }

    @Test
    void find_the_start_position2() {

        List<String> input = List.of(
                "..F7.",
                ".FJ|.",
                "SJ.L7",
                "|F--J",
                "LJ...");


        PipeCrawler crawler = new PipeCrawler(input);

        MatcherAssert.assertThat(crawler.posI, equalTo(2));
        MatcherAssert.assertThat(crawler.posJ, equalTo(1));

    }

    @Test
    void find_the_start_position3() {

        List<String> input = List.of(
                ".....",
                ".....",
                ".....",
                "|F--S",
                "LJ...");


        PipeCrawler crawler = new PipeCrawler(input);

        MatcherAssert.assertThat(crawler.posI, equalTo(3));
        MatcherAssert.assertThat(crawler.posJ, equalTo(3));

    }

    @Test
    void find_the_start_position4() {

        List<String> input = List.of(
                ".....",
                ".....",
                ".....",
                "|FS..",
                "LJ...");


        PipeCrawler crawler = new PipeCrawler(input);

        MatcherAssert.assertThat(crawler.posI, equalTo(3));
        MatcherAssert.assertThat(crawler.posJ, equalTo(1));

    }
}
