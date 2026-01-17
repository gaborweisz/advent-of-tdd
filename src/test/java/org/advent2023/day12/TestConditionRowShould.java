package org.advent2023.day12;

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
    void calculate_arrangements_if_folded_1() {

        MatcherAssert.assertThat(new ConditionRow("???.### 1,1,3",5).calculateArrangements(), equalTo(1));
    }

    @Test
    void calculate_arrangements_if_folded_2() {
        MatcherAssert.assertThat(new ConditionRow("?#?#?#?#?#?#?#? 1,3,1,6",5).calculateArrangements(), equalTo(1));
    }

    @Test
    void calculate_arrangements_if_folded_3() {
        //MatcherAssert.assertThat(new ConditionRow("????.#...#... 4,1,1",5).calculateArrangements(), equalTo(16));
    }

    @Test
    void calculate_arrangements_if_folded_4() {
        //MatcherAssert.assertThat(new ConditionRow("????.######..#####. 1,6,5",5).calculateArrangements(), equalTo(2500));
    }

    @Test
    void calculate_arrangements_if_folded_5() {
        //MatcherAssert.assertThat(new ConditionRow(".??..??...?##. 1,1,3",5).calculateArrangements(), equalTo(16384));
    }

    @Test
    void calculate_arrangements_if_folded_6() {
        //MatcherAssert.assertThat(new ConditionRow("?###???????? 3,2,1",5).calculateArrangements(), equalTo(506250));
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
    void fold_position_map() {

        ConditionRow conditionRow = new ConditionRow("???.### 1,1,3", 5);

        MatcherAssert.assertThat(conditionRow.condition, equalTo("???.###????.###????.###????.###????.###"));
        MatcherAssert.assertThat(conditionRow.damagedSprings.size(), equalTo(15));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(0).position, equalTo(1));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(0).length, equalTo(1));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(1).position, equalTo(3));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(1).length, equalTo(1));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(2).position, equalTo(5));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(2).length, equalTo(3));

        MatcherAssert.assertThat(conditionRow.damagedSprings.get(3).position, equalTo(9));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(3).length, equalTo(1));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(4).position, equalTo(11));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(4).length, equalTo(1));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(5).position, equalTo(13));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(5).length, equalTo(3));

        MatcherAssert.assertThat(conditionRow.damagedSprings.get(6).position, equalTo(17));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(6).length, equalTo(1));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(7).position, equalTo(19));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(7).length, equalTo(1));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(8).position, equalTo(21));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(8).length, equalTo(3));

        MatcherAssert.assertThat(conditionRow.damagedSprings.get(9).position, equalTo(25));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(9).length, equalTo(1));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(10).position, equalTo(27));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(10).length, equalTo(1));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(11).position, equalTo(29));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(11).length, equalTo(3));

        MatcherAssert.assertThat(conditionRow.damagedSprings.get(12).position, equalTo(33));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(12).length, equalTo(1));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(13).position, equalTo(35));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(13).length, equalTo(1));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(14).position, equalTo(37));
        MatcherAssert.assertThat(conditionRow.damagedSprings.get(14).length, equalTo(3));
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
