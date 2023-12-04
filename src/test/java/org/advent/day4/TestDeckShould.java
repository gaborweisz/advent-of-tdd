package org.advent.day4;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TestDeckShould {
    @Test
    void parse_rows_into_list_of_cards() {
        List<String> input = List.of(
                "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
                "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
                "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
                "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
                "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
                "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11");

        Deck deck = new Deck(input);

        MatcherAssert.assertThat(deck.cards.size() , equalTo(6));

    }

    @Test
    void calculate_copies() {
        List<String> input = List.of(
                "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
                "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
                "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
                "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
                "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
                "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11");

        Deck deck = new Deck(input);
        deck.calculateCopies();

        MatcherAssert.assertThat(deck.cards.size() , equalTo(6));
        MatcherAssert.assertThat(deck.cards.get(0).copies , equalTo(0));
        MatcherAssert.assertThat(deck.cards.get(1).copies , equalTo(1));
        MatcherAssert.assertThat(deck.cards.get(2).copies , equalTo(3));
        MatcherAssert.assertThat(deck.cards.get(3).copies , equalTo(7));
        MatcherAssert.assertThat(deck.cards.get(4).copies , equalTo(13));
        MatcherAssert.assertThat(deck.cards.get(5).copies , equalTo(0));

    }

    @Test
    void calculate_number_of_cards() {
        List<String> input = List.of(
                "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
                "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
                "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
                "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
                "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
                "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11");

        Deck deck = new Deck(input);
        deck.calculateCopies();

        MatcherAssert.assertThat(deck.calculateCards() , equalTo(30.0));


    }

}
