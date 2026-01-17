package org.advent2023.day7;

import java.util.HashMap;
import java.util.Map;

public class Hand implements Comparable<Hand> {

    String hand;
    int bid;
    int strength;

    Map<Character, Integer> strengthMap = new HashMap<>();

    {
        strengthMap.put('A', 14);
        strengthMap.put('K', 13);
        strengthMap.put('Q', 12);
        strengthMap.put('J', 11);
        strengthMap.put('T', 10);
        strengthMap.put('9', 9);
        strengthMap.put('8', 8);
        strengthMap.put('7', 7);
        strengthMap.put('6', 6);
        strengthMap.put('5', 5);
        strengthMap.put('4', 4);
        strengthMap.put('3', 3);
        strengthMap.put('2', 2);
    }


    public Hand(String hand, int bid) {
        this.hand = hand;
        this.bid = bid;
        this.strength = strength();
    }

    /**
     * Calculates the strength of the hand
     * @return
     */
    int strength() {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : hand.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, (map.get(c) + 1));
            } else {
                map.put(c, 1);
            }
        }

        if (map.values().size() == 1) {
            //five of a kind (AAAAA)
            return 7;
        } else if (map.values().size() == 2 && map.values().contains(4)) {
            //four of a kind (AAAAB)
            return 6;
        } else if (map.values().size() == 2 && map.values().contains(3)) {
            //full house (AAABB)
            return 5;
        } else if (map.values().size() == 3 && map.values().contains(3)) {
            //three of a kind  (AAABC)
            return 4;
        } else if (map.values().size() == 3 && map.values().contains(2) && map.values().contains(1)) {
            //two pair  (AABBC)
            return 3;
        } else if (map.values().size() == 4 && map.values().contains(2)) {
            //one pair (AABCD)
            return 2;
        } else {
            //high card (ABCDE)
            return 1;
        }
    }

    public int compareCards(String hand1, String hand2) {
        for (int i = 0; i < 5; i++) {
            if (strengthMap.get(hand1.charAt(i)) > strengthMap.get(hand2.charAt(i))) {
                return 1;
            } else if (strengthMap.get(hand1.charAt(i)) < strengthMap.get(hand2.charAt(i))) {
                return -1;
            }
        }

        return 0;
    }

    @Override
    public int compareTo(Hand o) {
        if (this.strength == o.strength) {
            return compareCards(this.hand, o.hand);
        } else {
            return this.strength - o.strength;
        }
    }
}
