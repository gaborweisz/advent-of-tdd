package org.advent.day7;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestDeckShould {

    @Test
    void parse_the_input_and_create_hands() {

        List<String> input = List.of(
                "32T3K 765",
                "T55J5 684",
                "KK677 28",
                "KTJJT 220",
                "QQQJA 483");

        Deck deck = new Deck(input);

        MatcherAssert.assertThat(deck.hands.size(), equalTo(5));
        MatcherAssert.assertThat(deck.hands.get(0).hand, equalTo("32T3K"));
        MatcherAssert.assertThat(deck.hands.get(0).bid, equalTo(765));
        MatcherAssert.assertThat(deck.hands.get(1).hand, equalTo("T55J5"));
        MatcherAssert.assertThat(deck.hands.get(1).bid, equalTo(684));
        MatcherAssert.assertThat(deck.hands.get(2).hand, equalTo("KK677"));
        MatcherAssert.assertThat(deck.hands.get(2).bid, equalTo(28));
        MatcherAssert.assertThat(deck.hands.get(3).hand, equalTo("KTJJT"));
        MatcherAssert.assertThat(deck.hands.get(3).bid, equalTo(220));
        MatcherAssert.assertThat(deck.hands.get(4).hand, equalTo("QQQJA"));
        MatcherAssert.assertThat(deck.hands.get(4).bid, equalTo(483));

    }

    @Test
    void rank_the_hands() {

        /**
         * 32T3K is the only one pair and the other hands are all a stronger type, so it gets rank 1.
         * KK677 and KTJJT are both two pair. Their first cards both have the same label, but the second card of KK677 is stronger (K vs T), so KTJJT gets rank 2 and KK677 gets rank 3.
         * T55J5 and QQQJA are both three of a kind. QQQJA has a stronger first card, so it gets rank 5 and T55J5 gets rank 4.
         */

        List<String> input = List.of(
                "32T3K 765",
                "T55J5 684",
                "KK677 28",
                "KTJJT 220",
                "QQQJA 483");

        Deck deck = new Deck(input);
        List<Hand> ranked = deck.rankHands();

        MatcherAssert.assertThat(ranked.size(), equalTo(5));
        MatcherAssert.assertThat(ranked.get(4).hand, equalTo("QQQJA"));
        MatcherAssert.assertThat(ranked.get(3).hand, equalTo("T55J5"));
        MatcherAssert.assertThat(ranked.get(2).hand, equalTo("KK677"));
        MatcherAssert.assertThat(ranked.get(1).hand, equalTo("KTJJT"));
        MatcherAssert.assertThat(ranked.get(0).hand, equalTo("32T3K"));

    }


    @Test
    void rank_the_joker_hands() {

        /**
         * 32T3K is still the only one pair; it doesn't contain any jokers, so its strength doesn't increase.
         * KK677 is now the only two pair, making it the second-weakest hand.
         * T55J5, KTJJT, and QQQJA are now all four of a kind! T55J5 gets rank 3, QQQJA gets rank 4, and KTJJT gets rank 5.
         */

        List<String> input = List.of(
                "32T3K 765",
                "T55J5 684",
                "KK677 28",
                "KTJJT 220",
                "QQQJA 483");

        JokerDeck deck = new JokerDeck(input);
        List<JokerHand> ranked = deck.rankHands();

        MatcherAssert.assertThat(ranked.size(), equalTo(5));
        MatcherAssert.assertThat(ranked.get(4).hand, equalTo("KTJJT"));
        MatcherAssert.assertThat(ranked.get(3).hand, equalTo("QQQJA"));
        MatcherAssert.assertThat(ranked.get(2).hand, equalTo("T55J5"));
        MatcherAssert.assertThat(ranked.get(1).hand, equalTo("KK677"));
        MatcherAssert.assertThat(ranked.get(0).hand, equalTo("32T3K"));

    }
}
