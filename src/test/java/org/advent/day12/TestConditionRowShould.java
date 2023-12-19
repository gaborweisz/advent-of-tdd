package org.advent.day12;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestConditionRowShould {

    @Test
    void parse_the_input_row() {

        ConditionRow conditionRow = new ConditionRow("???.### 1,1,3");

        MatcherAssert.assertThat(conditionRow.condition, equalTo("???.###"));
        MatcherAssert.assertThat(conditionRow.damagedSprings.size(), equalTo(3));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(0).length, equalTo(1));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(1).length, equalTo(1));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(2).length, equalTo(3));

    }

    /**
     * ???.### 1,1,3 - 1 arrangement
     * .??..??...?##. 1,1,3 - 4 arrangements
     * ?#?#?#?#?#?#?#? 1,3,1,6 - 1 arrangement
     * ????.#...#... 4,1,1 - 1 arrangement
     * ????.######..#####. 1,6,5 - 4 arrangements
     * ?###???????? 3,2,1 - 10 arrangements
     */
    @Test
    void calculate_arrangements() {

        MatcherAssert.assertThat(new ConditionRow("???.### 1,1,3").calculateArrangements(), equalTo(1));
        MatcherAssert.assertThat(new ConditionRow(".??..??...?##. 1,1,3").calculateArrangements(), equalTo(4));
        MatcherAssert.assertThat(new ConditionRow("?#?#?#?#?#?#?#? 1,3,1,6").calculateArrangements(), equalTo(1));
        MatcherAssert.assertThat(new ConditionRow("????.#...#... 4,1,1").calculateArrangements(), equalTo(1));
        MatcherAssert.assertThat(new ConditionRow("????.######..#####. 1,6,5").calculateArrangements(), equalTo(4));
        MatcherAssert.assertThat(new ConditionRow("?###???????? 3,2,1").calculateArrangements(), equalTo(10));
    }

    @Test
    void calculate_arrangements_2() {
        MatcherAssert.assertThat(new ConditionRow("???????????? 1,1,1,1").calculateArrangements(), equalTo(126));
    }

    @Test
    void calculate_arrangements_3() {
        MatcherAssert.assertThat(new ConditionRow("?##?#??????????##. 11,3").calculateArrangements(), equalTo(2));
    }

    @Test
    void calculate_arrangements_4() {
        MatcherAssert.assertThat(new ConditionRow("?.?????.##..??? 1,2,1").calculateArrangements(), equalTo(18));
    }


    @Test
    void init_position_map() {

        ConditionRow conditionRow = new ConditionRow("???.### 1,1,3");


        MatcherAssert.assertThat(conditionRow.damagedSprings.size(), equalTo(3));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(0).position, equalTo(1));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(0).length, equalTo(1));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(1).position, equalTo(3));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(1).length, equalTo(1));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(2).position, equalTo(5));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(2).length, equalTo(3));

    }


    @Test
    void shift_position_map() {

        ConditionRow conditionRow = new ConditionRow("???.### 1,1,3");
        List<DamagedSpring> shiftedPositions = conditionRow.shiftPositions(conditionRow.damagedSprings, 1);

        MatcherAssert.assertThat(shiftedPositions.size(), equalTo(3));
        MatcherAssert.assertThat(shiftedPositions.get(0).position, equalTo(2));
        MatcherAssert.assertThat(shiftedPositions.get(0).length, equalTo(1));
        MatcherAssert.assertThat(shiftedPositions.get(1).position, equalTo(4));
        MatcherAssert.assertThat(shiftedPositions.get(1).length, equalTo(1));
        MatcherAssert.assertThat(shiftedPositions.get(2).position, equalTo(6));
        MatcherAssert.assertThat(shiftedPositions.get(2).length, equalTo(3));

        List<DamagedSpring> shiftedPositions2 = conditionRow.shiftPositions(shiftedPositions, 3);

        MatcherAssert.assertThat(shiftedPositions2.size(), equalTo(3));
        MatcherAssert.assertThat(shiftedPositions2.get(0).position, equalTo(2));
        MatcherAssert.assertThat(shiftedPositions2.get(0).length, equalTo(1));
        MatcherAssert.assertThat(shiftedPositions2.get(1).position, equalTo(5));
        MatcherAssert.assertThat(shiftedPositions2.get(1).length, equalTo(1));
        MatcherAssert.assertThat(shiftedPositions2.get(2).position, equalTo(7));
        MatcherAssert.assertThat(shiftedPositions2.get(2).length, equalTo(3));

    }

    @Test
    void calculate_length() {

        ConditionRow conditionRow = new ConditionRow("???.### 1,1,3");
        List<DamagedSpring> shiftedPositions = conditionRow.shiftPositions(conditionRow.damagedSprings, 1);

        //#.#.###
        MatcherAssert.assertThat(conditionRow.calculateLength(conditionRow.damagedSprings), equalTo(7));

        //.#.#.###
        MatcherAssert.assertThat(conditionRow.calculateLength(shiftedPositions), equalTo(8));
    }

    @Test
    void calculate_variations_for_a_row() {
        ConditionRow conditionRow = new ConditionRow("#.#.### 1,1,3");
        conditionRow.calculateVariations();

        ConditionRow conditionRow2 = new ConditionRow(".#...#....###. 1,1,3");
        conditionRow2.calculateVariations();

    }

}
