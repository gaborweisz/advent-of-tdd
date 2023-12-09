package org.advent.day9;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestReportLineShould {

    @Test
    void parse_the_input() {

        String input = "0 3 6 9 12 15";

        ReportLine reportLine = new ReportLine(input);

        MatcherAssert.assertThat(reportLine.values.size(), equalTo(6));
        MatcherAssert.assertThat(reportLine.values.get(0), equalTo(0L));
        MatcherAssert.assertThat(reportLine.values.get(1), equalTo(3L));
        MatcherAssert.assertThat(reportLine.values.get(2), equalTo(6L));
        MatcherAssert.assertThat(reportLine.values.get(3), equalTo(9L));
        MatcherAssert.assertThat(reportLine.values.get(4), equalTo(12L));
        MatcherAssert.assertThat(reportLine.values.get(5), equalTo(15L));
        MatcherAssert.assertThat(reportLine.extrapolatedValue, equalTo(18L));
    }

    @Test
    void calculate_the_differences_of_a_line() {

        MatcherAssert.assertThat(ReportLine.calculateDifference(List.of(0L, 3L, 6L, 9L, 12L, 15L)), equalTo(List.of(3L, 3L, 3L, 3L, 3L)));
        MatcherAssert.assertThat(ReportLine.calculateDifference(List.of(3L, 3L, 3L, 3L, 3L)), equalTo(List.of(0L, 0L, 0L, 0L)));
    }

    @Test
    void detect_all_zero_lines() {

        MatcherAssert.assertThat(ReportLine.isAllZero(List.of(0L, 0L, 0L, 0L, 0L)), equalTo(true));
        MatcherAssert.assertThat(ReportLine.isAllZero(List.of(0L, 0L, 0L, 0L, 1L)), equalTo(false));
    }

    @Test
    void calculate_difference_hierarchy() {

        List<List<Long>> result = ReportLine.calculateDifferenceHierarchy(List.of(0L, 3L, 6L, 9L, 12L, 15L));

        MatcherAssert.assertThat(result.size(), equalTo(2));
        MatcherAssert.assertThat(result.get(0), equalTo(List.of(3L, 3L, 3L, 3L, 3L)));
        MatcherAssert.assertThat(result.get(1), equalTo(List.of(0L, 0L, 0L, 0L)));


        List<List<Long>> result2 = ReportLine.calculateDifferenceHierarchy(List.of(1L, 3L, 6L, 10L, 15L, 21L));
        MatcherAssert.assertThat(result2.size(), equalTo(3));
        MatcherAssert.assertThat(result2.get(0), equalTo(List.of(2L, 3L, 4L, 5L, 6L)));
        MatcherAssert.assertThat(result2.get(1), equalTo(List.of(1L, 1L, 1L, 1L)));
        MatcherAssert.assertThat(result2.get(2), equalTo(List.of(0L, 0L, 0L)));

        List<List<Long>> result3 = ReportLine.calculateDifferenceHierarchy(List.of(10L, 13L, 16L, 21L, 30L, 45L));
        MatcherAssert.assertThat(result3.size(), equalTo(4));
        MatcherAssert.assertThat(result3.get(0), equalTo(List.of(3L, 3L, 5L, 9L, 15L)));
        MatcherAssert.assertThat(result3.get(1), equalTo(List.of(0L, 2L, 4L, 6L)));
        MatcherAssert.assertThat(result3.get(2), equalTo(List.of(2L, 2L, 2L)));
        MatcherAssert.assertThat(result3.get(3), equalTo(List.of(0L, 0L)));
    }

    @Test
    void extrapolate() {

        List<List<Long>> diffs = ReportLine.calculateDifferenceHierarchy(List.of(0L, 3L, 6L, 9L, 12L, 15L));
        List<List<Long>> result = ReportLine.extrapolate(diffs);

        MatcherAssert.assertThat(result.size(), equalTo(2));
        MatcherAssert.assertThat(result.get(0).size(), equalTo(6));
        MatcherAssert.assertThat(result.get(0).get(0), equalTo(3L));
        MatcherAssert.assertThat(result.get(0).get(1), equalTo(3L));
        MatcherAssert.assertThat(result.get(0).get(2), equalTo(3L));
        MatcherAssert.assertThat(result.get(0).get(3), equalTo(3L));
        MatcherAssert.assertThat(result.get(0).get(4), equalTo(3L));
        MatcherAssert.assertThat(result.get(0).get(5), equalTo(3L));

    }

    @Test
    void calculate_the_extrapolated_value() {
        MatcherAssert.assertThat(ReportLine.calculateExtrapolatedValue(List.of(0L, 3L, 6L, 9L, 12L, 15L)), equalTo(18L));
        MatcherAssert.assertThat(ReportLine.calculateExtrapolatedValue(List.of(1L, 3L, 6L, 10L, 15L, 21L)), equalTo(28L));
        MatcherAssert.assertThat(ReportLine.calculateExtrapolatedValue(List.of(10L, 13L, 16L, 21L, 30L, 45L)), equalTo(68L));
    }

    @Test
    void calculate_the_extrapolated_first_value() {
        MatcherAssert.assertThat(ReportLine.calculateExtrapolatedFirstValue(List.of(10L, 13L, 16L, 21L, 30L, 45L)), equalTo(5L));
    }


}
