package org.advent2023.day7;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestJokerHandShould {

    @Test
    void apply_the_joker_card() {
        JokerHand jokerHand = new JokerHand("JJJJJ", 0);

        MatcherAssert.assertThat(jokerHand.applyJoker("JJJJJ"), equalTo("AAAAA"));
        MatcherAssert.assertThat(jokerHand.applyJoker("JJJJA"), equalTo("AAAAA"));
        MatcherAssert.assertThat(jokerHand.applyJoker("AAAAJ"), equalTo("AAAAA"));
        MatcherAssert.assertThat(jokerHand.applyJoker("JJJAA"), equalTo("AAAAA"));
        MatcherAssert.assertThat(jokerHand.applyJoker("AAAJJ"), equalTo("AAAAA"));
        MatcherAssert.assertThat(jokerHand.applyJoker("AAAKJ"), equalTo("AAAKA"));
        MatcherAssert.assertThat(jokerHand.applyJoker("JJJKQ"), equalTo("KKKKQ"));

        MatcherAssert.assertThat(jokerHand.applyJoker("T55J5"), equalTo("T5555"));
        MatcherAssert.assertThat(jokerHand.applyJoker("KTJJT"), equalTo("KTTTT"));
        MatcherAssert.assertThat(jokerHand.applyJoker("QQQQA"), equalTo("QQQQA"));
        MatcherAssert.assertThat(jokerHand.applyJoker("3344J"), equalTo("33444"));
        MatcherAssert.assertThat(jokerHand.applyJoker("JJ33A"), equalTo("3333A"));
        MatcherAssert.assertThat(jokerHand.applyJoker("3234J"), equalTo("32343"));
        MatcherAssert.assertThat(jokerHand.applyJoker("A345J"), equalTo("A345A"));
    }

    @Test
    void calculate_the_solution_for_puzzle_a() {

        /**
         * J cards can pretend to be whatever card is best for the purpose of determining hand type; for example, QJJQ2 is now considered four of a kind.
         * However, for the purpose of breaking ties between two hands of the same type, J is always treated as J, not the card it's pretending to be:
         * JKKK2 is weaker than QQQQ2 because J is weaker than Q.
         */

        MatcherAssert.assertThat(new JokerHand("AAAAA", 1).strength, equalTo(7));
        MatcherAssert.assertThat(new JokerHand("AA8AA", 1).strength, equalTo(6));
        MatcherAssert.assertThat(new JokerHand("23332", 1).strength, equalTo(5));
        MatcherAssert.assertThat(new JokerHand("TTT98", 1).strength, equalTo(4));
        MatcherAssert.assertThat(new JokerHand("23432", 1).strength, equalTo(3));
        MatcherAssert.assertThat(new JokerHand("A23A4", 1).strength, equalTo(2));
        MatcherAssert.assertThat(new JokerHand("23456", 1).strength, equalTo(1));
        MatcherAssert.assertThat(new JokerHand("QJJQ2", 1).strength, equalTo(6));
    }

    @Test
    void compare_to_other_hands() {

        /**
         *  33332 and 2AAAA are both three of a kind, but 33332 is stronger.
         *  77888 and 77788 are both a full house, but 77888 is stronger because its third card is stronger (and both hands have the same first and second card).
         */

        MatcherAssert.assertThat(new JokerHand("33332", 1).compareTo(new JokerHand("2AAAA", 1)),  equalTo(1));
        MatcherAssert.assertThat(new JokerHand("77888", 1).compareTo(new JokerHand("77788", 1)),  equalTo(1));
        MatcherAssert.assertThat(new JokerHand("AAAAA", 1).compareTo(new JokerHand("33332", 1)),  equalTo(1));
        MatcherAssert.assertThat(new JokerHand("33332", 1).compareTo(new JokerHand("AAAAA", 1)),  equalTo(-1));
        MatcherAssert.assertThat(new JokerHand("QQQJA", 1).compareTo(new JokerHand("T55J5", 1)),  equalTo(1));
        MatcherAssert.assertThat(new JokerHand("T55J5", 1).compareTo(new JokerHand("KK677", 1)),  equalTo(1));
        MatcherAssert.assertThat(new JokerHand("KK677", 1).compareTo(new JokerHand("KTJJT", 1)),  equalTo(-1));
        MatcherAssert.assertThat(new JokerHand("KTJJT", 1).compareTo(new JokerHand("32T3K", 1)),  equalTo(1));
    }
}
