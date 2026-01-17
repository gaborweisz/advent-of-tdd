package org.advent2023.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JokerDeck {

    List<JokerHand> jokerHands;

    public JokerDeck(List<String> rows) {
        parse(rows);
    }

    /**
     * Parses the input and creates hands
     * @param rows input
     */
    public void parse(List<String> rows) {
        this.jokerHands = new ArrayList<>();
        for (String row : rows) {
            String[] parts = row.split(" ");
            JokerHand hand = new JokerHand(parts[0], Integer.parseInt(parts[1]));
            jokerHands.add(hand);
        }
    }

    /**
     *  Sorts the hands by rank
     * @return sorted list of hands
     */
    public List<JokerHand> rankHands() {
        return jokerHands.stream().sorted().collect(Collectors.toList());
    }

    /**
     * Calculates the winning value
     * @return winning value
     */
    public double calculateWinning() {
        List<JokerHand> ranked = rankHands();

        double value = 0;
        for (int rank = 0; rank < ranked.size(); rank++) {
            JokerHand hand = ranked.get(rank);
            value += (rank + 1) * hand.bid;
        }

        return value;
    }
}
