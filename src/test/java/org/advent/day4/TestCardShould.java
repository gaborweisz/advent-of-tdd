package org.advent.day4;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestCardShould {

    @Test
    void parse_a_row_and_create_a_card() {

        String row = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
        Card card = Card.parseCard(row);

        MatcherAssert.assertThat(card.id, equalTo("Card 1"));
        MatcherAssert.assertThat(card.winningNumbers.size(), equalTo(5));
        MatcherAssert.assertThat(card.yourNumbers.size(), equalTo(8));
    }

    @Test
    void calculate_the_winning_cards() {

        MatcherAssert.assertThat(Card.parseCard("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53").calculateWinningCards(), equalTo(4.0));
        MatcherAssert.assertThat(Card.parseCard("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19").calculateWinningCards(), equalTo(2.0));
        MatcherAssert.assertThat(Card.parseCard("Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1").calculateWinningCards(), equalTo(2.0));
        MatcherAssert.assertThat(Card.parseCard("Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83").calculateWinningCards(), equalTo(1.0));
        MatcherAssert.assertThat(Card.parseCard("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36").calculateWinningCards(), equalTo(0.0));
        MatcherAssert.assertThat(Card.parseCard("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11").calculateWinningCards(), equalTo(0.0));
    }

    @Test
    void calculate_the_poits() {

        MatcherAssert.assertThat(Card.parseCard("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53").calculatePoints(), equalTo(8.0));
        MatcherAssert.assertThat(Card.parseCard("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19").calculatePoints(), equalTo(2.0));
        MatcherAssert.assertThat(Card.parseCard("Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1").calculatePoints(), equalTo(2.0));
        MatcherAssert.assertThat(Card.parseCard("Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83").calculatePoints(), equalTo(1.0));
        MatcherAssert.assertThat(Card.parseCard("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36").calculatePoints(), equalTo(0.0));
        MatcherAssert.assertThat(Card.parseCard("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11").calculatePoints(), equalTo(0.0));
    }
}
