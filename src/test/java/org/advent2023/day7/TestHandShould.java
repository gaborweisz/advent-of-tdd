package org.advent2023.day7;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestHandShould {

    @Test
    void calculate_the_solution_for_puzzle_a() {

        /**
         * Every hand is exactly one type. From strongest to weakest, they are:
         *
         * Five of a kind, where all five cards have the same label: AAAAA
         * Four of a kind, where four cards have the same label and one card has a different label: AA8AA
         * Full house, where three cards have the same label, and the remaining two cards share a different label: 23332
         * Three of a kind, where three cards have the same label, and the remaining two cards are each different from any other card in the hand: TTT98
         * Two pair, where two cards share one label, two other cards share a second label, and the remaining card has a third label: 23432
         * One pair, where two cards share one label, and the other three cards have a different label from the pair and each other: A23A4
         * High card, where all cards' labels are distinct: 23456
         */

        MatcherAssert.assertThat(new Hand("AAAAA", 1).strength, equalTo(7));
        MatcherAssert.assertThat(new Hand("AA8AA", 1).strength, equalTo(6));
        MatcherAssert.assertThat(new Hand("23332", 1).strength, equalTo(5));
        MatcherAssert.assertThat(new Hand("TTT98", 1).strength, equalTo(4));
        MatcherAssert.assertThat(new Hand("23432", 1).strength, equalTo(3));
        MatcherAssert.assertThat(new Hand("A23A4", 1).strength, equalTo(2));
        MatcherAssert.assertThat(new Hand("23456", 1).strength, equalTo(1));
    }

    @Test
    void compare_to_other_hands() {

        /**
         *  33332 and 2AAAA are both three of a kind, but 33332 is stronger.
         *  77888 and 77788 are both a full house, but 77888 is stronger because its third card is stronger (and both hands have the same first and second card).
         */

        MatcherAssert.assertThat(new Hand("33332", 1).compareTo(new Hand("2AAAA", 1)),  equalTo(1));
        MatcherAssert.assertThat(new Hand("77888", 1).compareTo(new Hand("77788", 1)),  equalTo(1));
        MatcherAssert.assertThat(new Hand("AAAAA", 1).compareTo(new Hand("33332", 1)),  equalTo(1));
        MatcherAssert.assertThat(new Hand("33332", 1).compareTo(new Hand("AAAAA", 1)),  equalTo(-1));
        MatcherAssert.assertThat(new Hand("QQQJA", 1).compareTo(new Hand("T55J5", 1)),  equalTo(1));
        MatcherAssert.assertThat(new Hand("T55J5", 1).compareTo(new Hand("KK677", 1)),  equalTo(1));
        MatcherAssert.assertThat(new Hand("KK677", 1).compareTo(new Hand("KTJJT", 1)),  equalTo(1));
        MatcherAssert.assertThat(new Hand("KTJJT", 1).compareTo(new Hand("32T3K", 1)),  equalTo(1));
    }
}
