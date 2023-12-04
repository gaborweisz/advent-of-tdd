package org.advent.day4;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    List<Card> cards = new ArrayList<>();

    public Deck(List<String> rows) {
        parseCards(rows);
    }

    /**
     * Parses the input and creates cards
     *
     * @param rows input
     */
    public void parseCards(List<String> rows) {
        for (String row : rows) {
            Card c = Card.parseCard(row);
            cards.add(c);
        }
    }

    /**
     * Calculates the number of copies for each card
     */
    public void calculateCopies() {
        for (int i = 0; i < cards.size(); i++) {
            addCopies(i);
        }
    }

    /**
     * Calculates the number of all cards, including copies
     *
     * @return number of cards
     */
    public double calculateCards() {
        double copies = 0.0;
        for (Card card : cards) {
            copies += card.copies;
        }
        return copies + cards.size();
    }

    private void addCopies(int index) {

        Card c = cards.get(index);
        for (int i = 1; i <= c.calculateWinningCards(); i++) {
            if (index + i < cards.size()) {
                Card nextCard = cards.get(index + i);
                nextCard.addCopy(c.copies + 1);
            }
        }
    }



}

