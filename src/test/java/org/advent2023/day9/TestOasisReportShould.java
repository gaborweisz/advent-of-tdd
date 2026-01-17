package org.advent2023.day9;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestOasisReportShould {

    @Test
    void parse_the_input() {

        List<String> input = List.of(
                "0 3 6 9 12 15",
                "1 3 6 10 15 21",
                "10 13 16 21 30 45");

        OasisReport oasisReport = new OasisReport(input);

        MatcherAssert.assertThat(oasisReport.lines.size(), equalTo(3));
        MatcherAssert.assertThat(oasisReport.lines.get(0).values.size(), equalTo(6));
        MatcherAssert.assertThat(oasisReport.lines.get(0).values.get(0), equalTo(0L));

        MatcherAssert.assertThat(oasisReport.lines.get(1).values.size(), equalTo(6));
        MatcherAssert.assertThat(oasisReport.lines.get(1).values.get(0), equalTo(1L));

        MatcherAssert.assertThat(oasisReport.lines.get(2).values.size(), equalTo(6));
        MatcherAssert.assertThat(oasisReport.lines.get(2).values.get(0), equalTo(10L));
    }

    @Test
    void calculate_the_summary_of_the_extraplated_values() {
        List<String> input = List.of(
                "0 3 6 9 12 15",
                "1 3 6 10 15 21",
                "10 13 16 21 30 45");

        OasisReport oasisReport = new OasisReport(input);

        MatcherAssert.assertThat(oasisReport.lines.size(), equalTo(3));
        MatcherAssert.assertThat(oasisReport.lines.get(0).extrapolatedValue, equalTo(18L));
        MatcherAssert.assertThat(oasisReport.lines.get(1).extrapolatedValue, equalTo(28L));
        MatcherAssert.assertThat(oasisReport.lines.get(2).extrapolatedValue, equalTo(68L));

        MatcherAssert.assertThat(oasisReport.extrapolateLinesAndSum(), equalTo(114L));
    }

}
