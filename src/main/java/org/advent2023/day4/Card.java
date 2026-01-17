package org.advent2023.day4;

import util.StringParser;

import java.util.List;

public class Card {

    String id;
    List<Integer> winningNumbers;
    List<Integer> yourNumbers;
    int copies = 0;

    /**
     * Parses a row into a card
     *
     * @param row input
     * @return card
     */
    public static Card parseCard(String row) {
        Card c = new Card();

        String[] parts = row.split(":");
        String[] numbers = parts[1].split("\\|");

        c.id = parts[0].trim();
        c.winningNumbers = StringParser.parseStringToIntArrayList(numbers[0], " ");
        c.yourNumbers = StringParser.parseStringToIntArrayList(numbers[1], " ");

        return c;
    }

    /**
     * Calculates the number of winning cards
     *
     * @return number of winning cards
     */
    public double calculateWinningCards() {
        double winningCards = 0.0;
        for (Integer number : yourNumbers) {
            if (winningNumbers.contains(number)) {
                winningCards++;
            }
        }
        return winningCards;
    }

    /**
     * Calculates the points for this card
     *
     * @return points
     */
    public double calculatePoints() {
        double points = calculateWinningCards();
        return points == 0.0 ? 0.0 : Math.pow(2.00, points-1.00);
    }

    /**
     * Adds a copy to this card
     *
     * @param number number of copies
     */
    public void addCopy(int number) {
        copies += number;
    }
}
